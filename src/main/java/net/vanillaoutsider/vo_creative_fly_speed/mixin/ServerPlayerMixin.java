package net.vanillaoutsider.vo_creative_fly_speed.mixin;

import net.minecraft.server.level.ServerPlayer;
import net.vanillaoutsider.vo_creative_fly_speed.FlySpeedLogic;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * Mixin into ServerPlayer.tick() to apply fly speed each tick.
 *
 * Purity: This mixin contains ZERO business logic.
 * All logic is delegated to FlySpeedLogic.applyFlySpeedToPlayer().
 *
 * Target: ServerPlayer.tick() — called once per server tick per player.
 * // Verified against: ServerPlayer.java (26.1 Snapshot 10) — public void tick(), line 599.
 *
 * The @HEAD injection runs before any other tick logic, ensuring speed is always
 * up-to-date before movement is processed.
 *
 * Prefix: creativeflyspeed$
 */
@Mixin(ServerPlayer.class)
public abstract class ServerPlayerMixin {

    /**
     * Injected at the HEAD of ServerPlayer.tick().
     * Delegates to FlySpeedLogic for O(1) speed application.
     */
    @Inject(method = "tick", at = @At("HEAD"))
    private void creativeflyspeed$applyFlySpeed(final CallbackInfo ci) {
        // Safe cast: this mixin is scoped to ServerPlayer only.
        FlySpeedLogic.applyFlySpeedToPlayer((ServerPlayer) (Object) this);
    }
}
