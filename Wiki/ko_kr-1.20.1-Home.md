# ✈️ Creative Fly Speed (Minecraft 1.20.1)

🌐 **Languages**: [[🇺🇸 English|Home]] | [[🇨🇳 简体中文|zh_cn-Home]] | [[🇭🇰 繁體中文|zh_tw-Home]] | [[🇷🇺 Русский|ru_ru-Home]] | [[🇪🇸 Español|es_es-Home]] | [[🇩🇪 Deutsch|de_de-Home]] | [[🇫🇷 Français|fr_fr-Home]] | [[🇧🇷 Português|pt_br-Home]] | [[🇯🇵 日本語|ja_jp-Home]] | [[🇮🇩 Bahasa Indonesia|id_id-Home]] | [[🇰🇷 한국어|ko_kr-Home]]

> 📌 **저장소 소스 코드 면책 조항**: 이 위키의 문서는 CurseForge 및 Modrinth의 공개 릴리스 빌드보다 앞선 최신 미출시 커밋 또는 개발 기능을 포함할 수 있는 **저장소의 현재 소스 코드 상태**를 반영합니다.

---

## 🎯 Anchor Overview: Minecraft 1.20.1

Welcome to the dedicated documentation tree for **Creative Fly Speed v1.0.0+1.20.1** running on **Minecraft 1.20.1**.

| Specification | Target Parameter |
| :--- | :--- |
| **Minecraft Anchor** | `1.20.1` |
| **Mod SemVer** | `1.0.0+1.20.1` |
| **Fabric Loader** | `>=0.15.11` |
| **Java Toolchain** | Java 17 |
| **Loom Version** | `1.10` |
| **Status Classification** | 🟣 Master Legacy |
| **Subproject Path** | `Creative Fly Speed v1.20.1` |

---

## 🧭 Subsystem Documentation Pages

Explore the 5 core technical guides for this version anchor:

1. [[✈️ Flight Speed Kinematics|ko_kr-1.20.1-Flight-Speed-Kinematics]]
   - Permille velocity calculation formulas ($S_{\text{fly}} = 0.05 \times \frac{P}{1000}$).
   - Sprint compounding ($1.4\times$) and float epsilon drift guards ($10^{-6}\text{ F}$).
   - Instantaneous server-to-client abilities packet dispatch.

2. [[⚙️ Configuration & Dynamic GameRules|ko_kr-1.20.1-Configuration-and-GameRules]]
   - Sovereign GameRules: `vo_creative_fly_speed:creative_fly_speed` & `vo_creative_fly_speed:spectator_fly_speed`.
   - Permille integer range $[1, 100000]$ ($0.001\times$ to $100.0\times$).
   - Dynamic unregistration lifecycle on server stop via `DynamicGameRuleManager`.

3. [[💬 Brigadier Commands & Suite (/cfs)|ko_kr-1.20.1-Commands-and-Brigadier]]
   - Complete `/cfs` and `/creativeflyspeed` command tree.
   - Live querying (`status`, `get`) and modification (`set`, `reset`).
   - Operator permissions and formatted feedback.

4. [[💻 Architecture & Mixins Breakdown|ko_kr-1.20.1-Architecture-and-Mixins]]
   - `ServerPlayerMixin.tick()` injection at `@At("HEAD")`.
   - Mixin purity: zero business logic in mixin, delegated to `FlySpeedLogic`.
   - $O(1)$ complexity, zero heap allocation, and Knot classloader safety.

5. [[🛠️ Developer Setup & Building|ko_kr-1.20.1-Developer-Setup-and-Building]]
   - Subproject layout, JDK 17 setup, and Gradle build instructions.
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

[[⬅️ Back to Version Selector Portal|ko_kr-Home]]
