# 🚀 Creative Fly Speed

**Targets Minecraft 26.1+ (Snapshot 8). No backports.**

> **Fly at the speed YOU want.**

Adjust Creative and Spectator flight speed via native Minecraft GameRules. No config files required — everything is live and in-game.

---

## ✨ Features

- **`creativeFlySpeed`** GameRule: Scale Creative mode flight speed (permille, default `1000` = vanilla).
- **`spectatorFlySpeed`** GameRule: Scale Spectator mode flight speed independently.
- **Instant Effect**: Speed applies every server tick. No relog or restart needed.
- **Server-Side Only**: Clients do not need the mod.
- **Permille Precision**: `1000 = 1.0x`, `2500 = 2.5x`, `10000 = 10x`.

---

## 📋 Quick Start

```
/gamerule creativeFlySpeed 2500      → 2.5x Creative speed
/gamerule spectatorFlySpeed 500      → 0.5x Spectator speed
/gamerule creativeFlySpeed 1000      → Reset to vanilla
```

---

## 📦 Requirements

- **Fabric API**
- **DasikLibrary**
- **Java 25**
- **Minecraft 26.1+**

---

## 📜 Credits

| Role | Author |
| :--- | :--- |
| **Creator** | **Rifaditya** (Dasik) |
| **Collection** | Vanilla Outsider |
| **License** | GNU GPLv3 |
