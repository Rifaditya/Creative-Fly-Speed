# Architecture & Symbol Index: Creative Fly Speed

## 1. Mod Metadata & Entrypoint
- **Mod ID**: `vo_creative_fly_speed`
- **Main Entrypoint**: `net.vanillaoutsider.vo_creative_fly_speed.CreativeFlySpeedFabric` (`net.fabricmc.api.ModInitializer`)
- **Client Entrypoint**: `net.vanillaoutsider.vo_creative_fly_speed.CreativeFlySpeedFabricClient`

## 2. Bytecode Mixin Target Registry
| Target Vanilla Class | Mixin Class | Purpose |
| :--- | :--- | :--- |
| `Vanilla Class` | `net.vanillaoutsider.vo_creative_fly_speed.mixin.ServerPlayerMixin` | Core mixin hook |

## 3. Core Mechanics & Subsystems
- **Source Root**: `src/main/java/`
- **Resource Root**: `src/main/resources/`

## 4. Dynamic GameRules & Commands
- **GameRules / Commands**: Configured dynamically via namespaced keys (`vo_creative_fly_speed:*`).

## 5. Configuration & Sidedness Isolation
- **Sidedness**: Server-safe logic in main, client isolated in `src/client/java` or client entrypoint.
