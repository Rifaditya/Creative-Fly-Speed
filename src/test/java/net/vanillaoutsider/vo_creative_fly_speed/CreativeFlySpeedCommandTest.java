// Copyright (C) 2026 Dasik (Rifaditya) | GNU GPLv3
package net.vanillaoutsider.vo_creative_fly_speed;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.ParseResults;
import com.mojang.brigadier.tree.CommandNode;
import net.minecraft.SharedConstants;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.network.chat.Component;
import net.minecraft.server.Bootstrap;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.vanillaoutsider.vo_creative_fly_speed.command.CreativeFlySpeedCommand;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Pillar 3: Brigadier AST Syntax & Permission Node Verification Suite for Creative Fly Speed (MC 1.20.1).
 * Asserts root command registrations (/cfs and /creativeflyspeed), subcommand trees,
 * argument parsing, and permission gating (Level 2 Gamemasters vs Level 0 unprivileged players).
 */
class CreativeFlySpeedCommandTest {

    private CommandDispatcher<CommandSourceStack> dispatcher;
    private CommandSourceStack adminSource;
    private CommandSourceStack unprivilegedSource;

    @BeforeAll
    static void initMinecraft() {
        try {
            SharedConstants.tryDetectVersion();
            Bootstrap.bootStrap();
        } catch (Throwable ignored) {
            // Headless unit tests can run even if bootstrap is already performed or mock environment
        }
    }

    private static CommandSourceStack createSource(int permLevel, String name) {
        return new CommandSourceStack(
                CommandSource.NULL,
                Vec3.ZERO,
                Vec2.ZERO,
                null,
                permLevel,
                name,
                Component.literal(name),
                null,
                null
        );
    }

    @BeforeEach
    void setUp() {
        dispatcher = new CommandDispatcher<>();
        CreativeFlySpeedCommand.register(dispatcher);

        adminSource = createSource(2, "AdminTester");
        unprivilegedSource = createSource(0, "GuestTester");
    }

    @Test
    @DisplayName("Pillar 3: Both root aliases (/cfs and /creativeflyspeed) are registered")
    void testRootCommandRegistration() {
        assertNotNull(dispatcher.getRoot().getChild("cfs"), "Root literal /cfs must be registered");
        assertNotNull(dispatcher.getRoot().getChild("creativeflyspeed"), "Root literal /creativeflyspeed must be registered");
    }

    @Test
    @DisplayName("Pillar 3: Command tree hierarchy possesses all required subcommands and argument nodes")
    void testCommandTreeHierarchy() {
        String[] roots = {"cfs", "creativeflyspeed"};

        for (String rootName : roots) {
            CommandNode<CommandSourceStack> root = dispatcher.getRoot().getChild(rootName);
            assertNotNull(root, "Root node " + rootName + " must exist");

            // Subcommands: help, status, get, set, reset
            CommandNode<CommandSourceStack> helpNode = root.getChild("help");
            assertNotNull(helpNode, "Subcommand /" + rootName + " help must exist");

            CommandNode<CommandSourceStack> statusNode = root.getChild("status");
            assertNotNull(statusNode, "Subcommand /" + rootName + " status must exist");

            CommandNode<CommandSourceStack> getNode = root.getChild("get");
            assertNotNull(getNode, "Subcommand /" + rootName + " get must exist");
            assertNotNull(getNode.getChild("creative"), "Subcommand /" + rootName + " get creative must exist");
            assertNotNull(getNode.getChild("spectator"), "Subcommand /" + rootName + " get spectator must exist");

            CommandNode<CommandSourceStack> setNode = root.getChild("set");
            assertNotNull(setNode, "Subcommand /" + rootName + " set must exist");
            CommandNode<CommandSourceStack> setCreative = setNode.getChild("creative");
            assertNotNull(setCreative, "Subcommand /" + rootName + " set creative must exist");
            assertNotNull(setCreative.getChild("permille"), "Argument permille must exist under set creative");

            CommandNode<CommandSourceStack> setSpectator = setNode.getChild("spectator");
            assertNotNull(setSpectator, "Subcommand /" + rootName + " set spectator must exist");
            assertNotNull(setSpectator.getChild("permille"), "Argument permille must exist under set spectator");

            CommandNode<CommandSourceStack> resetNode = root.getChild("reset");
            assertNotNull(resetNode, "Subcommand /" + rootName + " reset must exist");
        }
    }

    @Test
    @DisplayName("Pillar 3: Permission Gating enforces Level 0 for status/get and Level 2 for set/reset")
    void testPermissionGating() {
        CommandNode<CommandSourceStack> root = dispatcher.getRoot().getChild("cfs");
        assertNotNull(root);

        CommandNode<CommandSourceStack> statusNode = root.getChild("status");
        CommandNode<CommandSourceStack> helpNode = root.getChild("help");
        CommandNode<CommandSourceStack> getNode = root.getChild("get");
        CommandNode<CommandSourceStack> setNode = root.getChild("set");
        CommandNode<CommandSourceStack> resetNode = root.getChild("reset");

        // Status, Help, and Get must be accessible to unprivileged players (Level 0)
        assertTrue(statusNode.getRequirement().test(unprivilegedSource), "Unprivileged player must pass status check");
        assertTrue(helpNode.getRequirement().test(unprivilegedSource), "Unprivileged player must pass help check");
        assertTrue(getNode.getRequirement().test(unprivilegedSource), "Unprivileged player must pass get check");

        // Set and Reset require Level 2 (Gamemasters)
        assertTrue(setNode.getRequirement().test(adminSource), "Admin player must pass set permission check");
        assertFalse(setNode.getRequirement().test(unprivilegedSource), "Unprivileged player must fail set permission check");

        assertTrue(resetNode.getRequirement().test(adminSource), "Admin player must pass reset permission check");
        assertFalse(resetNode.getRequirement().test(unprivilegedSource), "Unprivileged player must fail reset permission check");
    }

    @Test
    @DisplayName("Pillar 3: Brigadier command syntax parsing succeeds for valid paths")
    void testCommandParsing() {
        assertParseSuccess("cfs", adminSource);
        assertParseSuccess("cfs status", unprivilegedSource);
        assertParseSuccess("cfs get creative", unprivilegedSource);
        assertParseSuccess("cfs get spectator", unprivilegedSource);
        assertParseSuccess("cfs set creative 2500", adminSource);
        assertParseSuccess("cfs set spectator 1500", adminSource);
        assertParseSuccess("cfs reset", adminSource);

        assertParseSuccess("creativeflyspeed status", unprivilegedSource);
        assertParseSuccess("creativeflyspeed set creative 1000", adminSource);
    }

    private void assertParseSuccess(String command, CommandSourceStack source) {
        ParseResults<CommandSourceStack> parse = dispatcher.parse(command, source);
        assertFalse(parse.getReader().canRead(),
                "Command parsing left unread input for: '" + command + "' -> " + parse.getReader().getRemaining());
        assertEquals(0, parse.getExceptions().size(),
                "Command parsing generated exceptions for: '" + command + "': " + parse.getExceptions());
        assertNotNull(parse.getContext().getCommand(),
                "Command node has no executable handler bound for: '" + command + "'");
    }
}
