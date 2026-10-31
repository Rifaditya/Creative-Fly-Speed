# 💬 Brigadier Commands & Suite (Minecraft 1.21.1)

> 📌 **Haftungsausschluss für Repository-Quellcode**: Die Dokumentation in diesem Wiki spiegelt den **aktuellen Quellcode-Zustand im Repository** wider, der aktuelle, unveröffentlichte Commits oder Entwicklungsfunktionen vor öffentlichen Builds auf CurseForge und Modrinth enthalten kann.

---

## 1. Official-Style Infobox

| Property | Technical Details |
| :--- | :--- |
| **Command Aliases** | `/cfs`, `/creativeflyspeed` |
| **Registration Hook** | `CommandRegistrationCallback.EVENT` (Fabric API) |
| **Implementation Class** | `CreativeFlySpeedCommand.java` |
| **Target Minecraft Version** | `1.21.1` (`1.0.0+1.21.1`) |
| **Query Permission Required** | Level 0 (All players) |
| **Mutation Permission Required** | Level 2 (`Commands.LEVEL_GAMEMASTERS` / Operator) |
| **Tab Completion** | Full dynamic Brigadier tab-completion |

---

## 2. Command Tree & Hierarchy

```
/cfs (or /creativeflyspeed)
├── (no args)                     -> Displays help prompt and status shortcut
├── help                          -> Displays full command guide
├── status                        -> Displays current Creative & Spectator permille and multiplier
├── get
│   ├── creative                  -> Queries active Creative permille & multiplier
│   └── spectator                 -> Queries active Spectator permille & multiplier
├── set (Operator Level 2)
│   ├── creative <permille>       -> Sets Creative fly speed permille (1..100000)
│   └── spectator <permille>      -> Sets Spectator fly speed permille (1..100000)
└── reset (Operator Level 2)      -> Resets both speeds to default (1000‰ / 1.0x)
```

---

## 3. Step-by-Step Command Usage Guide

### A. Viewing Current Status
Any player can check active flight speeds:
```mcfunction
/cfs status
```
**Output**:
```text
[Creative Fly Speed] Status:
  Creative: 2500‰ (2.5x)
  Spectator: 1000‰ (1.0x)
```

### B. Querying a Specific Mode
```mcfunction
/cfs get creative
/cfs get spectator
```
**Output**:
```text
[Creative Fly Speed] Creative: 2500‰ (2.5x)
```

### C. Modifying Speeds (Operator Level 2)
Set the Creative speed to $3.0\times$ ($3000‰$):
```mcfunction
/cfs set creative 3000
```
Set the Spectator speed to $0.25\times$ ($250‰$):
```mcfunction
/cfs set spectator 250
```
**Output**:
```text
[Creative Fly Speed] Set Creative fly speed to 3000‰ (3.0x)
```

### D. Resetting Speeds (Operator Level 2)
Quickly restore all speeds to default ($1000‰$ / $1.0\times$):
```mcfunction
/cfs reset
```
**Output**:
```text
[Creative Fly Speed] Reset Creative and Spectator fly speeds to default 1000‰ (1.0x)
```

---

## 4. Parameter Reference Table

| Subcommand | Argument | Type | Valid Range | Permission | Description |
| :--- | :--- | :--- | :--- | :---: | :--- |
| `help` | None | None | N/A | Level 0 | Shows command usage syntax. |
| `status` | None | None | N/A | Level 0 | Displays both Creative and Spectator speeds. |
| `get` | `<mode>` | Literal (`creative`&#124;`spectator`) | Literal | Level 0 | Queries the specific mode speed. |
| `set` | `<mode>` | Literal (`creative`&#124;`spectator`) | Literal | Level 2 | Specifies the game mode to update. |
| `set ...` | `<permille>` | Integer (`IntegerArgumentType`) | `1`..`100000` | Level 2 | Flight speed multiplier permille ($1000 = 1.0\times$). |
| `reset` | None | None | N/A | Level 2 | Reverts both speeds to `1000`. |

---

[[⬅️ Back to MC 1.21.1 Portal|de_de-1.21.1-Home]]
