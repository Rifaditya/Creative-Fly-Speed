# ✈️ Creative Fly Speed (Minecraft 1.21.11)

🌐 **Languages**: [[🇺🇸 English|Home]] | [[🇨🇳 简体中文|zh_cn-Home]] | [[🇭🇰 繁體中文|zh_tw-Home]] | [[🇷🇺 Русский|ru_ru-Home]] | [[🇪🇸 Español|es_es-Home]] | [[🇩🇪 Deutsch|de_de-Home]] | [[🇫🇷 Français|fr_fr-Home]] | [[🇧🇷 Português|pt_br-Home]] | [[🇯🇵 日本語|ja_jp-Home]] | [[🇮🇩 Bahasa Indonesia|id_id-Home]] | [[🇰🇷 한국어|ko_kr-Home]]

> 📌 **Descargo de responsabilidad del código fuente del repositorio**: La documentación de esta Wiki refleja el **estado actual del código fuente en el repositorio**, que puede incluir confirmaciones recientes no publicadas o características en desarrollo antes de las compilaciones públicas en CurseForge y Modrinth.

---

## 🎯 Anchor Overview: Minecraft 1.21.11

Welcome to the dedicated documentation tree for **Creative Fly Speed v1.0.0+1.21.11** running on **Minecraft 1.21.11**.

| Specification | Target Parameter |
| :--- | :--- |
| **Minecraft Anchor** | `1.21.11` |
| **Mod SemVer** | `1.0.0+1.21.11` |
| **Fabric Loader** | `>=0.16.5` |
| **Java Toolchain** | Java 21 |
| **Loom Version** | `1.10` |
| **Status Classification** | 🔵 Transitional Anchor |
| **Subproject Path** | `Creative Fly Speed v1.21.11` |

---

## 🧭 Subsystem Documentation Pages

Explore the 5 core technical guides for this version anchor:

1. [[✈️ Flight Speed Kinematics|es_es-1.21.11-Flight-Speed-Kinematics]]
   - Permille velocity calculation formulas ($S_{\text{fly}} = 0.05 \times \frac{P}{1000}$).
   - Sprint compounding ($1.4\times$) and float epsilon drift guards ($10^{-6}\text{ F}$).
   - Instantaneous server-to-client abilities packet dispatch.

2. [[⚙️ Configuration & Dynamic GameRules|es_es-1.21.11-Configuration-and-GameRules]]
   - Sovereign GameRules: `vo_creative_fly_speed:creative_fly_speed` & `vo_creative_fly_speed:spectator_fly_speed`.
   - Permille integer range $[1, 100000]$ ($0.001\times$ to $100.0\times$).
   - Dynamic unregistration lifecycle on server stop via `DynamicGameRuleManager`.

3. [[💬 Brigadier Commands & Suite (/cfs)|es_es-1.21.11-Commands-and-Brigadier]]
   - Complete `/cfs` and `/creativeflyspeed` command tree.
   - Live querying (`status`, `get`) and modification (`set`, `reset`).
   - Operator permissions and formatted feedback.

4. [[💻 Architecture & Mixins Breakdown|es_es-1.21.11-Architecture-and-Mixins]]
   - `ServerPlayerMixin.tick()` injection at `@At("HEAD")`.
   - Mixin purity: zero business logic in mixin, delegated to `FlySpeedLogic`.
   - $O(1)$ complexity, zero heap allocation, and Knot classloader safety.

5. [[🛠️ Developer Setup & Building|es_es-1.21.11-Developer-Setup-and-Building]]
   - Subproject layout, JDK 21 setup, and Gradle build instructions.
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

[[⬅️ Back to Version Selector Portal|es_es-Home]]
