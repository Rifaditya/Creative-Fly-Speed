# Concept: Creative Fly Speed

## Overview
Allows players to adjust their flight speed in Creative and Spectator modes using native Minecraft GameRules. This provides fine-grained control for builders, map-makers, and observers without requiring external mods or complex commands.

## Feature Checklist
- [x] **Adjustable Creative Fly Speed**: Rule to set the flight speed multiplier for Creative mode.
- [x] **Adjustable Spectator Fly Speed**: Rule to set the flight speed multiplier for Spectator mode.
- [x] **Permille Precision**: Use 1/1000 integer values for precise control (e.g., 1000 = 1x, 2500 = 2.5x).
- [x] **Instant Sync**: Updates take effect immediately upon GameRule change (applied every tick).
- [x] **Persistance**: GameRules are saved per-world as per Vanilla standards.

## Technical Specifications

### GameRules
| Rule Name | Type | Default | Description |
|:---|:---|:---|:---|
| `creativeFlySpeed` | `Integer` (Permille) | 1000 | Multiplier for Creative flight speed. |
| `spectatorFlySpeed` | `Integer` (Permille) | 1000 | Multiplier for Spectator flight speed. |

### Implementation Details
- **Logic**: The base Vanilla fly speed is `0.05f`. The mod will calculate the new speed as `0.05f * (GameRuleValue / 1000.0f)`.
- **Hooks**: 
    - `PlayerAbilities`: Update flight speed when the player's abilities are checked or when the GameRule changes.
    - `ServerPlayer`: Sync flight speed to the client on login and GameRule update to prevent visual jitter.

### Constraints
- **Java 25**: Use modern syntax and Records where applicable.
- **Snapshot 26.1**: Must target the latest Mojang mappings.
- **Standalone**: No external dependencies other than Fabric API.

## Design Philosophy (Vanilla Outsider)
- **Minimalist**: Only adds what is necessary.
- **Native**: Integrated directly into the game's existing config system (GameRules).
- **Performant**: Zero-overhead calculation in high-frequency loops.
