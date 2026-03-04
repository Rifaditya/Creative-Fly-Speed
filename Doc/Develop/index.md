# Developer Hub

Welcome to the **Creative Fly Speed** development documentation.

## Sections

- **[Getting Started](Getting-Started/index.md)**: Requirements, building, and project structure.
- **[Architecture](Architecture/Architecture.md)**: System flow, module responsibilities, design decisions.
- **[GameRules Reference](gamerules_reference.md)**: Complete reference for `creativeFlySpeed` and `spectatorFlySpeed`.
- **[Changelogs](Changelogs/History.md)**: Full release history.

## Architecture Overview

| Component | Purpose |
| :--- | :--- |
| `CreativeFlySpeedFabric` | Main entrypoint. Triggers GameRule registration via `CreativeFlySpeedRules`. |
| `CreativeFlySpeedRules` | Registers `creativeFlySpeed` and `spectatorFlySpeed` via `DynamicGameRuleManager`. |
| `FlySpeedLogic` | Stateless helper. Calculates target flySpeed and applies it to the player. |
| `ServerPlayerMixin` | Pure hook into `ServerPlayer.tick()`. Delegates all logic to `FlySpeedLogic`. |

## Key Design Decisions

1. **Tick-based application**: Speed is applied every server tick via a Mixin hook and guarded by an epsilon check — changes are applied **instantly** without requiring a relog, and redundant packets are suppressed.
2. **Permille units**: Storing 1/1000th values as integers avoids floating-point imprecision in GameRule config. `1000 = 1.0x`, `2500 = 2.5x`.
3. **Mixin purity**: `ServerPlayerMixin` is a hook only. All business logic lives in `FlySpeedLogic`.
