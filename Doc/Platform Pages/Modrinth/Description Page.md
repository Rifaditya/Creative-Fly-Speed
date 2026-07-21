<div align="center">

<!-- Banner placeholder — replace URL when banner is uploaded -->
<!-- ![Creative Fly Speed Banner](https://example.com/banner.jpg) -->

</div>
<p align="center">
    <a href="https://modrinth.com/mod/fabric-api"><img src="https://img.shields.io/badge/Requires-Fabric_API-blue?style=for-the-badge&logo=fabric" alt="Requires Fabric API"></a>
    <a href="https://modrinth.com/mod/dasik-library"><img src="https://img.shields.io/badge/Requires-Dasik_Library-blue?style=for-the-badge&logo=modrinth" alt="Modrinth: Dasik Library"></a>
    <img src="https://img.shields.io/badge/Language-Java-orange?style=for-the-badge&logo=java" alt="Java">
    <img src="https://img.shields.io/badge/License-GPLv3-green?style=for-the-badge" alt="License">
    <img src="https://img.shields.io/badge/Minecraft-26.1+-brightgreen?style=for-the-badge" alt="Minecraft 26.1+">
</p>

# 🚀 Creative Fly Speed

**Active Version Policy:** I build **1 JAR for 1 Version**. I only update and maintain the latest active Minecraft version (e.g. when 26.3 is released, 26.2 is retired). No backports or legacy version maintenance. Please do not ask.

> **Fly at the speed YOU want. No limits, no friction.**

**Creative Fly Speed** gives you surgical control over flight dynamics. Tired of the sluggish vanilla flight speed when building massive structures? Or maybe you need slow, cinematic precision in Spectator mode? It’s all just a GameRule away. 

Part of the **Vanilla Outsider Collection** — mods that refine the vanilla experience with modern standards.

---

## ✨ Features

### ⚡ Creative Flight Control
Adjust how fast you soar through your builds. 
- **`creativeFlySpeed`** GameRule: Scale your flight speed using permille units.
- **Precision Scaling**: `1000` is the vanilla default (1.0x). Want to go faster? Set it to `2500` for 2.5x speed.
- **Hot-Swappable**: Settings apply every tick manually. No need to relog or restart the server.

### 🎥 Spectator Precision
Traverse your world with ease or capture the perfect shot.
- **`spectatorFlySpeed`** GameRule: Independent multiplier for Spectator mode.
- **Smooth Traversal**: Crank it up to `10000` (10x) to scout terrains, or drop it to `500` (0.5x) for steady camera work.

---

## 📋 Quick Start

```sql
/gamerule creativeFlySpeed 2500      → 2.5x Creative speed
/gamerule spectatorFlySpeed 500      → 0.5x Spectator speed
/gamerule creativeFlySpeed 1000      → Reset to vanilla
```

---

## ⚙️ Config


> [!IMPORTANT]
> **Config vs. In-Game GameRules:**
> The global configuration file only defines **default values for new worlds** at creation time.
> If you have **already created/opened a world**, changing the config file will have no effect. You must change the settings in-game using the **Edit Game Rules** UI screen or the /gamerule command.
No messy config files. Everything lives in the **Edit Game Rules** screen or via standard commands.
- **Instant Sync**: Changes are pushed to all players in the corresponding game mode immediately.
- **Server-Side Only**: This mod is purely server-side. Clients don't need it to fly at high speeds!

---

## 📦 Install

1. Install **[Fabric API](https://modrinth.com/mod/fabric-api)**.
2. Install **[DasikLibrary](https://modrinth.com/mod/dasik-library)**.
3. Download the latest JAR and place it in your `mods` folder.

---

## ☕ Support

If you enjoy the **Vanilla Outsider** collection, consider fueling the next update!

[![Ko-fi](https://img.shields.io/badge/Ko--fi-Support%20Me-FF5E5B?style=for-the-badge&logo=ko-fi&logoColor=white)](https://ko-fi.com/dasikigaijin/tip)
[![SocioBuzz](https://img.shields.io/badge/SocioBuzz-Local_Support-7BB32E?style=for-the-badge)](https://sociabuzz.com/dasikigaijin/tribe)
[![Saweria](https://img.shields.io/badge/Saweria-Local_Support-FFA500?style=for-the-badge)](https://saweria.co/DasikIgaijinn)

> [!NOTE]
> **Indonesian Users:** SocioBuzz and Saweria support local payment methods (Gopay, OVO, Dana, etc.) if you want to support me without using PayPal/Ko-fi!

---

## 📜 Credits

| Role | Author |
| :--- | :--- |
| **Creator** | **Rifaditya** (Dasik) |
| **Collection** | Vanilla Outsider |
| **License** | GPLv3 |

---

> [!IMPORTANT]
> **📦 Modpack Permissions & Distribution:** You are free to include this mod in any modpack on any platform. However, the mod itself must be downloaded from its official distribution pages on **Modrinth** or **CurseForge**. Re-uploading or redistributing the mod jar file to third-party sites is strictly prohibited unless explicitly permitted by the creator.
> 
> **License & Forks:** Since the source code is licensed under **GNU GPLv3**, you are fully permitted to fork the repository, make modifications, build your own versions, and distribute them under the terms of the GPLv3. The prohibition on third-party redistribution applies exclusively to the official compiled releases/jars published by the original creator (Dasik/Rifaditya). Forks must be published as distinct projects, not direct re-uploads of official builds.

---

<div align="center">

**Made with ❤️ for the Minecraft community**

*Part of the Vanilla Outsider Collection*

</div>
