# Architecture & Symbol Index: Creative Fly Speed (MC 1.21.11)

## 1. Mod Metadata & Entrypoint
- **Mod ID**: `vo_creative_fly_speed`
- **Minecraft Anchor**: `1.21.11` (Java 21, Loom Remap 1.15-SNAPSHOT, Mojang Mappings)
- **Main Entrypoint**: `net.vanillaoutsider.vo_creative_fly_speed.CreativeFlySpeedFabric` (`net.fabricmc.api.ModInitializer`)
- **Client Entrypoint**: `net.vanillaoutsider.vo_creative_fly_speed.CreativeFlySpeedFabricClient` (`net.fabricmc.api.ClientModInitializer`)

## 2. Bytecode Mixin Target Registry
| Target Vanilla Class | Mixin Class | Injection Point | Purpose |
| :--- | :--- | :--- | :--- |
| `net.minecraft.server.level.ServerPlayer` | `net.vanillaoutsider.vo_creative_fly_speed.mixin.ServerPlayerMixin` | `@At("HEAD")` on `tick()` | Applies desired flight speed per-tick via `FlySpeedLogic` |

## 3. Core Mechanics & Subsystems
- **`FlySpeedLogic`**: Stateless helper calculating speed from permille and applying to `ServerPlayer` abilities.
- **`CreativeFlySpeedRules`**: Dynamic GameRules (`vo_creative_fly_speed:creative_fly_speed`, `vo_creative_fly_speed:spectator_fly_speed`) registered via DasikLibrary's `DynamicGameRuleManager`.
- **`CreativeFlySpeedCommand`**: Full Brigadier command suite (`/cfs` and `/creativeflyspeed`) with status, query, set (Level 2), and reset (Level 2).
- **`CreativeFlySpeedSupport`**: Centralized creator support and community URIs via DasikLibrary.

## 4. 5-Pillar Autonomous Verification Harness
- **Pillar 1**: `CreativeFlySpeedStressFuzzTest` (50,000 randomized and edge-case iterations)
- **Pillar 2**: `CreativeFlySpeedConcurrencyLoadTest` (50 worker threads, 500,000 operations)
- **Pillar 3**: `CreativeFlySpeedCommandTest` (Brigadier AST syntax, permissions, and parsing)
- **Pillar 4**: `CreativeFlySpeedGameTest` (Gamemode transition simulation & epsilon guarding)
- **Pillar 5**: `CreativeFlySpeedSidednessContractTest` (Bytecode and source sidedness contract + GPLv3 headers)
