# ✈️ Vanilla Outsider: Creative Fly Speed Wiki

🌐 **Languages**: [[🇺🇸 English|Home]] | [[🇨🇳 简体中文|zh_cn-Home]] | [[🇭🇰 繁體中文|zh_tw-Home]] | [[🇷🇺 Русский|ru_ru-Home]] | [[🇪🇸 Español|es_es-Home]] | [[🇩🇪 Deutsch|de_de-Home]] | [[🇫🇷 Français|fr_fr-Home]] | [[🇧🇷 Português|pt_br-Home]] | [[🇯🇵 日本語|ja_jp-Home]] | [[🇮🇩 Bahasa Indonesia|id_id-Home]] | [[🇰🇷 한국어|ko_kr-Home]]

> 📌 **Repository Source Disclaimer**: The documentation in this Wiki reflects the **current source code state in the repository**, which may include recent unreleased commits or developmental features ahead of public release builds on CurseForge and Modrinth.

---

## 🎯 Welcome to the Official Documentation

**Creative Fly Speed** is a high-performance, lightweight flight kinematics mod in the **Vanilla Outsider Collection**, engineered by **Dasik (Rifaditya)**. It gives builders, world creators, operators, and cinematic observers native, seamless control over player flight speed in Creative and Spectator modes directly through server-synchronized Minecraft GameRules.

Designed around the **Player Agency & Anti-Nanny Invariant**, this mod imposes zero artificial ceilings: players can tune flight speeds up to $100\times$ baseline velocity for rapid world traversal or scale down to $0.1\times$ for microscopic voxel detailing.

---

## 🧭 Active Version Selector Portal

Select your targeted Minecraft version to access the isolated documentation tree:

| Target Minecraft Version | Mod Release Anchor | Runtime Toolchain | Status | Direct Documentation Portal |
| :--- | :--- | :--- | :---: | :--- |
| **Minecraft 26.3** | `1.0.0+26.3` | Fabric Loader `>=0.19.3` / Java 25 | 🟢 Active Current | [[👉 Enter MC 26.3 Wiki Portal|26.3-Home]] |
| **Minecraft 26.2** | `1.0.0+26.2` | Fabric Loader `>=0.16.10` / Java 25 | 🟡 Parity Anchor | [[👉 Enter MC 26.2 Wiki Portal|26.2-Home]] |

> [!NOTE]
> Under the project's **1 Jar 1 Version Policy**, each version branch is maintained as a sovereign, self-contained implementation with dedicated dependency mappings.

---

## 🌟 Core Architectural Flowchart

```
                 [ Server Player Tick ]
                           |
                           v
           [ ServerPlayerMixin.tick() @ HEAD ]
                           |
                           v
         [ FlySpeedLogic.applyFlySpeedToPlayer() ]
                           |
          +----------------+----------------+
          |                                 |
  GameType == CREATIVE            GameType == SPECTATOR
          |                                 |
          v                                 v
[ Fetch CREATIVE_FLY_SPEED ]    [ Fetch SPECTATOR_FLY_SPEED ]
          |                                 |
          +----------------+----------------+
                           |
                           v
        [ Calculate targetSpeed = 0.05 * (P / 1000) ]
                           |
                           v
          [ Guard: |current - target| > 1e-6 ]
                           |
                 +---------+---------+
                 |                   |
            (Within Drift)      (Drift Exceeded)
                 |                   |
                 v                   v
            [ Early Return ]    [ abilities.setFlyingSpeed(target) ]
            [  (No Packets) ]   [ player.onUpdateAbilities()       ]
                                     |
                                     v
                        [ Dispatch Abilities Packet ]
```

---

## 🚀 Core Subsystem Overviews

### 1. [[Flight Speed Kinematics|26.3-Flight-Speed-Kinematics]]
- **Permille Scaling Precision**: Translates permille integers ($P \in [1, 100000]$) into fractional velocity units ($S_{\text{fly}} = 0.05 \times \frac{P}{1000}$ blocks/tick).
- **Compounding Sprint Velocity**: Vanilla flight sprinting multiplier ($1.4\times$) cascades directly on top of the calculated flight speed.
- **Float Epsilon Guard**: Enforces $|\text{speed}_{\text{current}} - \text{speed}_{\text{target}}| > 10^{-6}$ before mutating abilities, completely eliminating redundant packet transmissions.
- **Side-Safe Packet Synchronization**: Emits `ClientboundPlayerAbilitiesPacket` via `ServerPlayer.onUpdateAbilities()` for jitter-free client flight rendering.

### 2. [[Configuration & Dynamic GameRules|26.3-Configuration-and-GameRules]]
- **Dynamic GameRule Integration**: Dynamic category registration under `vo_creative_fly_speed:fly_speed` powered by DasikLibrary.
- **Sovereign Multiplier Rules**:
  - `vo_creative_fly_speed`: Flight speed multiplier for Creative mode (default: `1000` = $1.0\times$).
  - `vo_spectator_fly_speed`: Flight speed multiplier for Spectator mode (default: `1000` = $1.0\times$).
- **Anti-Nanny Invariant**: Allows integer values up to $100,000$ ($100\times$ vanilla speed) without arbitrary mod-imposed ceilings.
- **Per-World Persistence**: Native persistence inside `level.dat` with zero external JSON configs required.

### 3. [[Architecture & Mixins Breakdown|26.3-Architecture-and-Mixins]]
- **Mixin Purity**: `ServerPlayerMixin` injects at `@At("HEAD")` of `ServerPlayer.tick()`, containing strictly zero business logic.
- **Stateless Computation**: All calculations execute in `FlySpeedLogic` with zero object allocations and $O(1)$ arithmetic complexity.
- **Safe Isolation**: Survival and Adventure game modes are immediately bypassed without touching vanilla flight mechanics.

---

## 📚 General Documentation & Developer Reference

- [[Version Compatibility & Matrix|Version-Compatibility]]: Exhaustive breakdown of Loom, Fabric Loader, Parchment, and Java version requirements.
- [[Troubleshooting & FAQ|Troubleshooting-and-FAQ]]: Detailed diagnosis for flight jitter, floating-point drift, server tick rate considerations, and world save migration.
- [[Developer Setup & Building Guide|Developer-Setup-and-Building]]: Instructions for compiling the repository, setting up Gradle, and configuring the Loom toolchain.

---

## 📜 Credits & Licensing

- **Author & Maintainer**: **Dasik (Rifaditya)**
- **License**: **GNU General Public License v3.0 (GPLv3)**
- **Mod Name**: Creative Fly Speed (`vo_creative_fly_speed`)
- **Source Code**: [GitHub Repository](https://github.com/Rifaditya/Creative-Fly-Speed)
