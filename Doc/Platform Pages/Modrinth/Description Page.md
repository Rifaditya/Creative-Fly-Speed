<div align="center">

<!-- Banner placeholder — replace URL when banner is uploaded -->
<!-- ![Creative Fly Speed Banner](https://example.com/banner.jpg) -->

</div>
<p align="center">
    <a href="https://discord.gg/EV99bgAFqb"><img src="https://img.shields.io/badge/Discord-Join_Community-5865F2?style=for-the-badge&logo=discord&logoColor=white" alt="Join Discord"></a>
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

### 💬 Join the Community & Get Support
Looking for help, want to test early beta builds, or vote on upcoming features? Join our official Discord community!
<p align="center">
  <a href="https://discord.gg/EV99bgAFqb">
    <img src="https://img.shields.io/badge/💬_Discord-Join_Community-5865F2?style=for-the-badge&logo=discord&logoColor=white" alt="Join Official Discord">
  </a>
</p>

---

## ☕ Support

If you enjoy **Creative Fly Speed** and the **Vanilla Outsider Collection**, consider fueling future updates!

<p align="center">
  <a href="https://ko-fi.com/dasikigaijin/tip"><img src="https://img.shields.io/badge/Ko--fi-Support%20Me-FF5E5B?style=for-the-badge&logo=ko-fi&logoColor=white" alt="Ko-fi"></a>
  <a href="https://sociabuzz.com/dasikigaijin/tribe"><img src="https://img.shields.io/badge/SocioBuzz-Local_Support-7BB32E?style=for-the-badge" alt="SocioBuzz"></a>
  <a href="https://saweria.co/DasikIgaijinn"><img src="https://img.shields.io/badge/Saweria-Local_Support-FFA500?style=for-the-badge" alt="Saweria"></a>
</p>

> [!NOTE]
> **🇮🇩 Indonesian Users:** SocioBuzz and Saweria support local payment methods (Gopay, OVO, Dana, etc.) if you want to support me without using PayPal/Ko-fi!

---

## 📜 Credits & Modpack Permissions

| Role / Property | Author / Link |
| :--- | :--- |
| **Creator / Author** | **Dasik** (Rifaditya) |
| **Community** | [Official Discord](https://discord.gg/EV99bgAFqb) |
| **Collection** | Vanilla Outsider |
| **License** | [GNU General Public License v3.0 (GPLv3)](https://www.gnu.org/licenses/gpl-3.0.html) |
| **Source Code** | [GitHub - Rifaditya/Creative-Fly-Speed](https://github.com/Rifaditya/Creative-Fly-Speed) |
| **Issue Tracker** | [GitHub Issues](https://github.com/Rifaditya/Creative-Fly-Speed/issues) |
| **Documentation / Wiki** | [GitHub Wiki](https://github.com/Rifaditya/Creative-Fly-Speed/wiki) |

> [!IMPORTANT]
> **📦 Modpack Permissions & Distribution:**<br>
> You are fully welcome to include this mod in any modpack on any platform! However, the mod file must be downloaded directly through official distribution channels (**Modrinth** or **CurseForge**). Re-uploading, mirroring, or redistributing the original mod JAR to third-party mirror sites, scraper portals, or unauthorized launchers is strictly prohibited.
> <br><br>
> **⚖️ License & Fork Guidelines (No Zero-Change Re-uploads):**<br>
> This project is open-source under the **GNU GPLv3**. You are fully encouraged to inspect the code, learn from it, and fork the repository to create genuine modifications, substantial feature expansions, or community ports—provided your project remains open-source under GPLv3 with proper attribution.<br>
> **However, straight 1:1 re-uploads, clone forks with no meaningful functional changes, or re-publishing identical builds under different project names (e.g. to farm downloads or rewards) are strictly forbidden.**

---

<div align="center">

**Made with ❤️ for the Minecraft community**

*Part of the Vanilla Outsider Collection*

</div>
