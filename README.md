# 🚀 Creative Fly Speed

> "Fly at the speed YOU want."

**Creative Fly Speed** lets you scale Creative and Spectator flight speed via two native Minecraft GameRules — no config files, no restarts, instant effect.

**Part of the [Vanilla Outsider](https://github.com/Rifaditya/Vanilla-Outsider-Creative-Fly-Speed) collection.**

## Features

- **`creativeFlySpeed`** — Scale Creative flight (`1000` = vanilla, `2500` = 2.5x, etc.)
- **`spectatorFlySpeed`** — Scale Spectator flight independently.
- **Instant Sync**: Applied every server tick. No relog required.
- **Server-Side Only**: Clients don't need the mod installed.
- **Permille Precision**: Integer values — no float config imprecision.

## Configuration

All settings use `/gamerule` or the **Edit Game Rules** screen.

| Rule | Default | Description |
|---|---|---|
| `creativeFlySpeed` | `1000` | Creative mode fly speed (permille, `1000` = vanilla `0.05f`) |
| `spectatorFlySpeed` | `1000` | Spectator mode fly speed (permille, `1000` = vanilla `0.05f`) |

**Scale**: `0.05f × (value / 1000)` — e.g., `2500` → `0.125 blocks/tick`.

## Building

```bash
./gradlew build
```

Output JAR: `build/libs/creative-fly-speed-<version>.jar`

## Requirements

- **Minecraft**: 26.1 Snapshot 8
- **Fabric Loader**: 0.16.10+
- **Fabric API**: 0.142.1+26.1
- **DasikLibrary**: 1.6.9+build.5+
- **Java**: 25+

## License

GPL-3.0-or-later
