// Copyright (C) 2026 Dasik (Rifaditya) | GNU GPLv3
package net.vanillaoutsider.vo_creative_fly_speed.command;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.level.GameRules;
import net.vanillaoutsider.vo_creative_fly_speed.CreativeFlySpeedRules;

/**
 * Dedicated Brigadier command suite for Creative Fly Speed (/cfs and /creativeflyspeed) in MC 1.20.1.
 * Provides status inspection, granular speed queries, live modification, and reset controls.
 */
public final class CreativeFlySpeedCommand {

    private CreativeFlySpeedCommand() {}

    /**
     * Registers both /cfs and /creativeflyspeed command trees into the server dispatcher.
     *
     * @param dispatcher The server command dispatcher.
     */
    public static void register(final CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(buildCommandTree("cfs"));
        dispatcher.register(buildCommandTree("creativeflyspeed"));
    }

    private static LiteralArgumentBuilder<CommandSourceStack> buildCommandTree(final String root) {
        return Commands.literal(root)
                .executes(CreativeFlySpeedCommand::executeRoot)
                .then(Commands.literal("help")
                        .executes(CreativeFlySpeedCommand::executeHelp))
                .then(Commands.literal("status")
                        .executes(CreativeFlySpeedCommand::executeStatus))
                .then(Commands.literal("get")
                        .then(Commands.literal("creative")
                                .executes(ctx -> executeGet(ctx, true)))
                        .then(Commands.literal("spectator")
                                .executes(ctx -> executeGet(ctx, false))))
                .then(Commands.literal("set")
                        .requires(source -> source.hasPermission(2))
                        .then(Commands.literal("creative")
                                .then(Commands.argument("permille", IntegerArgumentType.integer(1, 100000))
                                         .executes(ctx -> executeSet(ctx, true))))
                        .then(Commands.literal("spectator")
                                .then(Commands.argument("permille", IntegerArgumentType.integer(1, 100000))
                                         .executes(ctx -> executeSet(ctx, false)))))
                .then(Commands.literal("reset")
                        .requires(source -> source.hasPermission(2))
                        .executes(CreativeFlySpeedCommand::executeReset));
    }

    private static GameRules getRules(final MinecraftServer server) {
        if (server == null) {
            return null;
        }
        return server.getGameRules();
    }

    private static int executeRoot(final CommandContext<CommandSourceStack> ctx) {
        ctx.getSource().sendSuccess(
                () -> Component.literal("§6[Creative Fly Speed]§r Use §b/cfs status§r to view speeds or §b/cfs help§r for command usage."),
                false
        );
        return 1;
    }

    private static int executeHelp(final CommandContext<CommandSourceStack> ctx) {
        ctx.getSource().sendSuccess(() -> Component.literal(
                "§6[Creative Fly Speed]§r Command Guide:\n" +
                "  §b/cfs status§r - View current Creative & Spectator speeds\n" +
                "  §b/cfs get <creative|spectator>§r - Query speed for a specific mode\n" +
                "  §b/cfs set <creative|spectator> <permille>§r - Set speed (1..100000, 1000 = 1.0x)\n" +
                "  §b/cfs reset§r - Reset all speeds to default (1000‰ / 1.0x)"
        ), false);
        return 1;
    }

    private static int executeStatus(final CommandContext<CommandSourceStack> ctx) {
        final CommandSourceStack source = ctx.getSource();
        final MinecraftServer server = source.getServer();
        final GameRules rules = getRules(server);
        if (rules == null) {
            source.sendFailure(Component.literal("§c[Creative Fly Speed] GameRules are unavailable."));
            return 0;
        }

        final int creativePermille = (CreativeFlySpeedRules.CREATIVE_FLY_SPEED != null)
                ? rules.getRule(CreativeFlySpeedRules.CREATIVE_FLY_SPEED).get()
                : 1000;
        final int spectatorPermille = (CreativeFlySpeedRules.SPECTATOR_FLY_SPEED != null)
                ? rules.getRule(CreativeFlySpeedRules.SPECTATOR_FLY_SPEED).get()
                : 1000;

        source.sendSuccess(() -> Component.literal(
                "§6[Creative Fly Speed]§r Status:\n" +
                "  Creative: §b" + creativePermille + "‰§r (§a" + (creativePermille / 1000.0F) + "x§r)\n" +
                "  Spectator: §b" + spectatorPermille + "‰§r (§a" + (spectatorPermille / 1000.0F) + "x§r)"
        ), false);
        return 1;
    }

    private static int executeGet(final CommandContext<CommandSourceStack> ctx, final boolean isCreative) {
        final CommandSourceStack source = ctx.getSource();
        final MinecraftServer server = source.getServer();
        final GameRules rules = getRules(server);
        if (rules == null) {
            source.sendFailure(Component.literal("§c[Creative Fly Speed] GameRules are unavailable."));
            return 0;
        }

        final GameRules.Key<GameRules.IntegerValue> rule = isCreative ? CreativeFlySpeedRules.CREATIVE_FLY_SPEED : CreativeFlySpeedRules.SPECTATOR_FLY_SPEED;
        final String modeName = isCreative ? "Creative" : "Spectator";
        final int permille = (rule != null) ? rules.getRule(rule).get() : 1000;

        source.sendSuccess(() -> Component.literal(
                "§6[Creative Fly Speed]§r " + modeName + ": §b" + permille + "‰§r (§a" + (permille / 1000.0F) + "x§r)"
        ), false);
        return permille;
    }

    private static int executeSet(final CommandContext<CommandSourceStack> ctx, final boolean isCreative) {
        final CommandSourceStack source = ctx.getSource();
        final MinecraftServer server = source.getServer();
        final GameRules rules = getRules(server);
        if (rules == null || server == null) {
            source.sendFailure(Component.literal("§c[Creative Fly Speed] Server or GameRules are unavailable."));
            return 0;
        }

        final int permille = IntegerArgumentType.getInteger(ctx, "permille");
        final GameRules.Key<GameRules.IntegerValue> rule = isCreative ? CreativeFlySpeedRules.CREATIVE_FLY_SPEED : CreativeFlySpeedRules.SPECTATOR_FLY_SPEED;
        final String modeName = isCreative ? "Creative" : "Spectator";

        if (rule != null) {
            rules.getRule(rule).set(permille, server);
        }

        source.sendSuccess(() -> Component.literal(
                "§a[Creative Fly Speed]§r Set " + modeName + " fly speed to §b" + permille + "‰§r (§a" + (permille / 1000.0F) + "x§r)"
        ), true);
        return permille;
    }

    private static int executeReset(final CommandContext<CommandSourceStack> ctx) {
        final CommandSourceStack source = ctx.getSource();
        final MinecraftServer server = source.getServer();
        final GameRules rules = getRules(server);
        if (rules == null || server == null) {
            source.sendFailure(Component.literal("§c[Creative Fly Speed] Server or GameRules are unavailable."));
            return 0;
        }

        if (CreativeFlySpeedRules.CREATIVE_FLY_SPEED != null) {
            rules.getRule(CreativeFlySpeedRules.CREATIVE_FLY_SPEED).set(1000, server);
        }
        if (CreativeFlySpeedRules.SPECTATOR_FLY_SPEED != null) {
            rules.getRule(CreativeFlySpeedRules.SPECTATOR_FLY_SPEED).set(1000, server);
        }

        source.sendSuccess(() -> Component.literal(
                "§a[Creative Fly Speed]§r Reset Creative and Spectator fly speeds to default §b1000‰§r (§a1.0x§r)"
        ), true);
        return 1;
    }
}
