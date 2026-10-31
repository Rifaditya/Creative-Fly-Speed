# ✈️ Creative Fly Speed (Minecraft 26.3)

🌐 **Languages**: [[🇺🇸 English|Home]] | [[🇨🇳 简体中文|zh_cn-Home]] | [[🇭🇰 繁體中文|zh_tw-Home]] | [[🇷🇺 Русский|ru_ru-Home]] | [[🇪🇸 Español|es_es-Home]] | [[🇩🇪 Deutsch|de_de-Home]] | [[🇫🇷 Français|fr_fr-Home]] | [[🇧🇷 Português|pt_br-Home]] | [[🇯🇵 日本語|ja_jp-Home]] | [[🇮🇩 Bahasa Indonesia|id_id-Home]] | [[🇰🇷 한국어|ko_kr-Home]]

> 📌 **Haftungsausschluss für Repository-Quellcode**: Die Dokumentation in diesem Wiki spiegelt den **aktuellen Quellcode-Zustand im Repository** wider, der aktuelle, unveröffentlichte Commits oder Entwicklungsfunktionen vor öffentlichen Builds auf CurseForge und Modrinth enthalten kann.

---

## 🎯 Anchor Overview: Minecraft 26.3

Welcome to the dedicated documentation tree for **Creative Fly Speed v1.0.0+26.3** running on **Minecraft 26.3**.

| Specification | Target Parameter |
| :--- | :--- |
| **Minecraft Anchor** | `26.3` |
| **Mod SemVer** | `1.0.0+26.3` |
| **Fabric Loader** | `>=0.19.5` |
| **Java Toolchain** | Java 25 |
| **Loom Version** | `1.11` |
| **Status Classification** | 🟢 Active Lead |
| **Subproject Path** | `Creative Fly Speed v26.3` |

---

## 🧭 Subsystem Documentation Pages

Explore the 5 core technical guides for this version anchor:

1. [[✈️ Flight Speed Kinematics|de_de-26.3-Flight-Speed-Kinematics]]
   - Permille velocity calculation formulas ($S_{\text{fly}} = 0.05 \times \frac{P}{1000}$).
   - Sprint compounding ($1.4\times$) and float epsilon drift guards ($10^{-6}\text{ F}$).
   - Instantaneous server-to-client abilities packet dispatch.

2. [[⚙️ Configuration & Dynamic GameRules|de_de-26.3-Configuration-and-GameRules]]
   - Sovereign GameRules: `vo_creative_fly_speed:creative_fly_speed` & `vo_creative_fly_speed:spectator_fly_speed`.
   - Permille integer range $[1, 100000]$ ($0.001\times$ to $100.0\times$).
   - Dynamic unregistration lifecycle on server stop via `DynamicGameRuleManager`.

3. [[💬 Brigadier Commands & Suite (/cfs)|de_de-26.3-Commands-and-Brigadier]]
   - Complete `/cfs` and `/creativeflyspeed` command tree.
   - Live querying (`status`, `get`) and modification (`set`, `reset`).
   - Operator permissions and formatted feedback.

4. [[💻 Architecture & Mixins Breakdown|de_de-26.3-Architecture-and-Mixins]]
   - `ServerPlayerMixin.tick()` injection at `@At("HEAD")`.
   - Mixin purity: zero business logic in mixin, delegated to `FlySpeedLogic`.
   - $O(1)$ complexity, zero heap allocation, and Knot classloader safety.

5. [[🛠️ Developer Setup & Building|de_de-26.3-Developer-Setup-and-Building]]
   - Subproject layout, JDK 25 setup, and Gradle build instructions.
   - Headless test execution (`./gradlew test`).

---

## ⚡ Quick Start: Operator Commands

```mcfunction
# View active flight speeds
/cfs status

# Set Creative flight speed to 2.5x
/cfs set creative 2500

# Set Spectator flight speed to 0.5x for camera recording
/cfs set spectator 500

# Reset all speeds to vanilla 1.0x
/cfs reset
```

---

[[⬅️ Back to Version Selector Portal|de_de-Home]]
