# Creative Fly Speed

**Creative Fly Speed** lets you set exactly how fast you (or your players) fly in Creative and Spectator modes — directly from a GameRule command.

## How It Works

Minecraft's vanilla fly speed is locked at **`0.05 blocks/tick`** (approximately **1 block per second** at normal game speed). This mod lets you scale that speed up or down using a **permille** (1/1000th) multiplier.

**Formula**: `flySpeed = 0.05 × (gamerule / 1000)`

## Configuration

### Creative Fly Speed

Controls flight speed in **Creative mode**.

```
/gamerule creativeFlySpeed 1000    → Vanilla speed (default)
/gamerule creativeFlySpeed 2000    → 2x speed
/gamerule creativeFlySpeed 2500    → 2.5x speed — great for large builds
/gamerule creativeFlySpeed 5000    → 5x speed — rapidly cross the map
```

### Spectator Fly Speed

Controls flight speed in **Spectator mode**.

```
/gamerule spectatorFlySpeed 1000   → Vanilla speed (default)
/gamerule spectatorFlySpeed 500    → 0.5x speed — precision cinematic work
/gamerule spectatorFlySpeed 3000   → 3x speed — rapid world review
```

## Use Cases

| Scenario | Recommended Setting |
| :--- | :--- |
| Normal Building | `creativeFlySpeed 1000` (vanilla) |
| Large Terrain Projects | `creativeFlySpeed 2500 - 5000` |
| Tiny Detail Work | `creativeFlySpeed 500` |
| Cinematic Camera | `spectatorFlySpeed 200 - 500` |
| World Review / Speed Run | `spectatorFlySpeed 5000+` |

## Notes

- Changes apply **instantly** — no relog or restart required.
- Values are **per-world** (saved in the world's GameRules data).
- Setting a value of **`0`** will bring flight to a complete stop (hover in place). This is intentional.
- Survival and Adventure players are **never affected**.
