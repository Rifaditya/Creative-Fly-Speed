<p align="center">
  <a href="https://discord.gg/EV99bgAFqb"><img src="https://img.shields.io/badge/Discord-Join_Community-5865F2?style=for-the-badge&logo=discord&logoColor=white" alt="Join Discord"></a>
  <a href="https://modrinth.com/mod/fabric-api"><img src="https://img.shields.io/badge/Requires-Fabric_API-blue?style=for-the-badge&logo=fabric" alt="Requires Fabric API"></a>
  <img src="https://img.shields.io/badge/Environment-Client_&_Server-success?style=for-the-badge" alt="Client & Server">
  <img src="https://img.shields.io/badge/Language-Java_25-orange?style=for-the-badge&logo=java" alt="Java 25">
  <img src="https://img.shields.io/badge/License-GPLv3-green?style=for-the-badge" alt="License GPLv3">
  <img src="https://img.shields.io/badge/Minecraft-26.2+-brightgreen?style=for-the-badge" alt="Minecraft 26.2+">
</p>

# 🦅 Creative Fly Speed

> **"Unchain Creative Flight. Precision Maneuvering Meets Hypersonic World Navigation."**

---

## 📖 Introduction

Building mega-structures, designing massive redstone contraptions, and surveying vast terrain in Minecraft's Creative Mode is often crippled by vanilla's sluggish, one-speed flight mechanics. Double-tapping sprint grants a minor boost, but traversing thousands of blocks to inspect a biome or locate a structure still takes agonizing minutes. Conversely, when placing delicate stair blocks or wiring tight redstone circuits inside compact interiors, vanilla flight velocity is too fast and floaty, causing you to constantly overshoot your target.

**Creative Fly Speed** gives you total, fluid mastery over flight dynamics. Designed with architectural precision under the **Vanilla Outsider** collection, it introduces dynamic mouse-scroll flight speed adjustment, sprint momentum scaling, calibrated vertical vs horizontal thrust, configurable inertia damping, and server-side packet authorization to eliminate annoying rubberbanding on multiplayer servers.

> [!NOTE]
> **1 Jar 1 Version Policy:** I build **1 dedicated JAR for each Minecraft version** (e.g. MC 26.2, MC 26.3). Please download the exact build that matches your Minecraft installation.
> 
> **Multiplayer Architecture:** Works as a lightweight server mod with client synchronization. On dedicated servers running Creative Fly Speed, clients can fly at supersonic speeds without triggering vanilla "Flying is not enabled on this server" kicks or velocity rubberbanding!

Part of the **Vanilla Outsider Collection** — modern mods designed to refine and elevate the vanilla Minecraft experience.

---

## ✨ Features

### 🎡 Dynamic Mouse-Scroll Speed Tuning
- **On-the-Fly Velocity Adjustment:** Hold `Left Alt` (configurable) and scroll your mouse wheel up or down while flying to seamlessly scale your flight speed from a crawl ($0.1\times$) up to supersonic velocity ($20.0\times$).
- **Sub-Block Precision Mode:** Dial speed down to $0.05\times$ for micrometer-level block placement, fine interior decoration, or cinematic camera tracking.
- **HUD Speed Bar Narration:** Displays a clean, discreet action bar readout (e.g. `✈️ Fly Speed: 3.5x`) that fades away smoothly when adjustment ceases.

### ⚡ Calibrated Vertical & Horizontal Vector Physics
- **Independent Vertical Thrust:** Vanilla flight often feels unbalanced when ascending or descending. Creative Fly Speed allows independent calibration of vertical ascension speed (`creative_fly_speed:vertical_thrust_ratio`), making towering mega-build ascents effortless.
- **Sprint Momentum Surge:** Double-tap sprint while flying to engage a configurable secondary momentum surge ($1.5\times$ to $5.0\times$ boost), perfect for quick bursts across build plots.
- **Inertia & Drift Elimination:** Eliminate vanilla's floaty slide upon releasing movement keys with customizable inertia damping for instant, crisp stopping.

### 🛡️ Server-Side Anti-Rubberband Enforcement
- **Smooth Dedicated Server Synchronization:** On vanilla servers, flying faster than vanilla speed thresholds causes the server to constantly drag your position backward (rubberband) or kick you for illegal movement packets.
- **Integrated Server Guard:** Creative Fly Speed handles player ability velocity packets authoritatively on the server, synchronizing custom velocity limits so all builders on your creative server enjoy silky smooth flight.

---

## 📊 Feature Comparison Matrix

| Flight Capability | Vanilla Creative Flight | Creative Fly Speed |
| :--- | :--- | :--- |
| **Speed Adjustment** | Fixed single speed (minor sprint boost) | **Dynamic $0.05\times$ to $20.0\times$ via mouse scroll** |
| **Precision Building Mode** | Impossible (requires crawling on blocks) | **Dedicated sub-block micro-speed mode** |
| **Vertical Ascension** | Sluggish fixed $0.05$ blocks/tick | **Calibrated vertical thrust ratio multiplier** |
| **Inertia Stopping** | Floaty momentum drift | **Crisp, zero-drift instantaneous stopping** |
| **Multiplayer Performance** | Rubberbands and triggers flying kicks | **Native server-authorized packet sync** |
| **Spectator Mode Parity** | Standard scroll-speed only | **Unified controls across Creative & Spectator** |

---

## 🎮 In-Game Commands & Quick Controls

Creative Fly Speed provides intuitive Brigadier commands for quick velocity calibration:

```bash
# Set your current flight speed multiplier to 3.5x
/flyspeed set 3.5

# Reset flight speed multiplier to default vanilla speed (1.0x)
/flyspeed reset

# Inspect your current horizontal and vertical flight metrics
/flyspeed status
```

### Server-Side GameRules

Server administrators can enforce global bounds and velocity ceilings using native namespaced GameRules:

| GameRule Key | Type | Default | Valid Range | Description |
| :--- | :---: | :---: | :---: | :--- |
| `creative_fly_speed:max_allowed_multiplier` | `Double` | `10.0` | `1.0 – 50.0` | Maximum flight multiplier builders are permitted to reach. |
| `creative_fly_speed:vertical_thrust_ratio` | `Double` | `1.0` | `0.2 – 3.0` | Ratio of vertical climbing speed relative to horizontal speed. |
| `creative_fly_speed:enable_scroll_adjust` | `Boolean` | `true` | `true / false` | Allows players to adjust flight speed via mouse scroll. |
| `creative_fly_speed:inertia_damping` | `Double` | `1.0` | `0.0 – 1.0` | Damping factor for instant stopping upon key release. |

---

## 📖 In-Depth How-To & Gameplay Playbook

### Step 1: Installing for Singleplayer or Servers
1. Install **Fabric Loader** and **Fabric API** for Minecraft 26.2+ / 26.3+.
2. Place `creative-fly-speed-x.y.z+<version>.jar` into your `mods/` directory.
3. If running a dedicated server, install it on the server as well to unlock high-speed server authorization.

### Step 2: Navigating Large Creative Worlds
- Double-tap `Space` to enter creative flight.
- Hold `Left Alt` and scroll your mouse wheel forward: watch the action bar indicate `Fly Speed: 2.0x -> 4.0x -> 8.0x`.
- Press `W` to cross vast oceans and continents in seconds!
- When you reach your build site, hold `Left Alt` and scroll backward down to `0.2x` or `0.5x` to place glass, stairs, and fine details with pixel-perfect control.

### Step 3: Admin World Plot Setup
- For servers hosting creative build contests, set `/gamerule creative_fly_speed:max_allowed_multiplier 5.0` to balance builder mobility with server chunk-generation performance.

---

## ☕ Support & Creator Community

I am an independent solo developer creating lightweight, vanilla-enhancing mods that respect your time and game performance. If Creative Fly Speed accelerates your creativity, consider supporting future development:

<p align="center">
  <a href="https://ko-fi.com/rifaditya"><img src="https://img.shields.io/badge/Ko--fi-Support_on_Ko--fi-F16061?style=for-the-badge&logo=ko-fi&logoColor=white" alt="Support on Ko-fi"></a>
  <a href="https://sociabuzz.com/rifaditya"><img src="https://img.shields.io/badge/SocioBuzz-Support_Creator-00A651?style=for-the-badge" alt="Support on SocioBuzz"></a>
  <a href="https://saweria.co/rifaditya"><img src="https://img.shields.io/badge/Saweria-Support_Local-FFA500?style=for-the-badge" alt="Support on Saweria"></a>
</p>

> [!TIP]
> **🇮🇩 Indonesian Local Payment Note:** Indonesian supporters can also support my development work directly using local payment options (**GoPay, OVO, Dana, QRIS, LinkAja**) via **Saweria** or **SocioBuzz**!

Join our official Discord community for live development updates, early test builds, and friendly support:
- 💬 **Discord Community:** [https://discord.gg/EV99bgAFqb](https://discord.gg/EV99bgAFqb)

---

## 📜 Metadata & Permissions

| Property | Value |
| :--- | :--- |
| **Mod Name** | Creative Fly Speed |
| **Namespace / Mod ID** | `creative_fly_speed` |
| **License** | GNU General Public License v3.0 (GPLv3) |
| **Side Safety** | Client & Server (Vanilla Server Safe) |
| **Source Code** | [GitHub Repository](https://github.com/Rifaditya/Creative-Fly-Speed) |
| **Issue Tracker** | [GitHub Issues](https://github.com/Rifaditya/Creative-Fly-Speed/issues) |

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
