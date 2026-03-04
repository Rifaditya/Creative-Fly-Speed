# Architecture

## Overview

**Creative Fly Speed** hooks into the server-side player tick to apply a GameRule-controlled fly speed to Creative and Spectator players on every tick.

## Logic Flow

1. **Registration (`CreativeFlySpeedFabric.onInitialize()`)**:
    - Class-loads `CreativeFlySpeedRules`, triggering its `static {}` block.
    - `DynamicGameRuleManager.registerInteger()` registers `creativeFlySpeed` and `spectatorFlySpeed` into the Minecraft GameRule registry.

2. **Speed Application (`ServerPlayerMixin → FlySpeedLogic`)**:
    - Every server tick, `ServerPlayerMixin` injects at `HEAD` of `ServerPlayer.tick()`.
    - Delegates to `FlySpeedLogic.applyFlySpeedToPlayer(player)`.
    - `FlySpeedLogic` reads the player's current `GameType` via `player.gameMode.getGameModeForPlayer()`.
    - Looks up the corresponding GameRule value from `player.level().getGameRules()`.
    - Computes `targetSpeed = 0.05f * (permille / 1000.0f)`.
    - **Guards** against redundant syncs: only calls `player.onUpdateAbilities()` if `|current - target| > 1e-6f`.

3. **Client Sync (`ServerPlayer.onUpdateAbilities()`)**:
    - Sends `ClientboundPlayerAbilitiesPacket` to the client.
    - The client updates its local `flyingSpeed` and immediately applies it to movement.

## Module Responsibilities

| Class | Responsibility |
| :--- | :--- |
| `CreativeFlySpeedFabric` | Entrypoint. Triggers rule registration only. |
| `CreativeFlySpeedRules` | Single-responsibility: holds the two `GameRule<Integer>` handles and the vanilla base speed constant. |
| `FlySpeedLogic` | Single-responsibility: O(1) speed calculation and epsilon-guarded player mutation. No Mixin code. |
| `ServerPlayerMixin` | Pure hook into `ServerPlayer.tick()`. Contains no logic — only calls `FlySpeedLogic`. |

## Performance

| Concern | Mitigation |
| :--- | :--- |
| **Tick overhead** | O(1) — two `GameRules.get()` calls + float arithmetic. No allocations. |
| **Network spam** | Epsilon guard (`1e-6f`) ensures `onUpdateAbilities()` is called at most once per speed change. |
| **Survival/Adventure interference** | Early return on `default` (SURVIVAL, ADVENTURE) game modes — these players are never touched. |

## Verified Sources

- `Abilities.java` (26.1 Snapshot 10): `flyingSpeed = 0.05F`, `setFlyingSpeed(float)`, `getFlyingSpeed()`
- `ServerPlayer.java` (26.1 Snapshot 10): `public final ServerPlayerGameMode gameMode` (line 229)
- `ServerPlayerGameMode.java` (26.1 Snapshot 10): `getGameModeForPlayer()` (line 92)
- `GameRules.java` (26.1 Snapshot 10): `get(GameRule<T>)` returns `T` directly (line 124)
