# GameRules Reference

**Creative Fly Speed** uses GameRules for all configuration — changeable via `/gamerule` or the **Edit Game Rules** screen, with no restarts required.

## Rules

| Rule Name | Description | Default | Min | Max |
| :--- | :--- | :--- | :--- | :--- |
| `creativeFlySpeed` | Flight speed multiplier for **Creative** mode players (permille). `1000` = vanilla speed. | `1000` | `0` | `Integer.MAX_VALUE` |
| `spectatorFlySpeed` | Flight speed multiplier for **Spectator** mode players (permille). `1000` = vanilla speed. | `1000` | `0` | `Integer.MAX_VALUE` |

## Permille Scale

Values use **permille** (1/1000th) to avoid floating-point precision issues.

| Value | Speed | Blocks/Tick |
| :--- | :--- | :--- |
| `500` | 0.5x (half speed) | ~0.025 |
| `1000` | 1.0x (vanilla) | ~0.05 |
| `2000` | 2.0x | ~0.10 |
| `2500` | 2.5x | ~0.125 |
| `5000` | 5.0x | ~0.25 |
| `10000` | 10.0x | ~0.50 |

## Category

All rules are located in the custom **Creative Fly Speed** category in the Edit Game Rules screen.

## Examples

```
/gamerule creativeFlySpeed 2500    → Creative at 2.5x speed
/gamerule spectatorFlySpeed 500    → Spectator at 0.5x (slower, precise)
/gamerule creativeFlySpeed 1000    → Reset Creative to vanilla
/gamerule spectatorFlySpeed 0      → Freeze spectator flight
```

> **Note**: A value of `0` will set fly speed to zero (stationary hover). This is intentional and can be useful for map-making precision work.
