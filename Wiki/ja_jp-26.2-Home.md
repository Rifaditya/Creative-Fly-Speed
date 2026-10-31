# ✈️ Creative Fly Speed (Minecraft 26.2)

🌐 **Languages**: [[🇺🇸 English|Home]] | [[🇨🇳 简体中文|zh_cn-Home]] | [[🇭🇰 繁體中文|zh_tw-Home]] | [[🇷🇺 Русский|ru_ru-Home]] | [[🇪🇸 Español|es_es-Home]] | [[🇩🇪 Deutsch|de_de-Home]] | [[🇫🇷 Français|fr_fr-Home]] | [[🇧🇷 Português|pt_br-Home]] | [[🇯🇵 日本語|ja_jp-Home]] | [[🇮🇩 Bahasa Indonesia|id_id-Home]] | [[🇰🇷 한국어|ko_kr-Home]]

> 📌 **リポジトリソースコードに関する免責事項**: このWikiのドキュメントは**リポジトリ内の現在のソースコード状態**を反映しており、CurseForgeやModrinthでの一般公開ビルドに先立つ最新の開発コミットや未リリース機能が含まれている場合があります。

---

## 🎯 Anchor Overview: Minecraft 26.2

Welcome to the dedicated documentation tree for **Creative Fly Speed v1.0.0+26.2** running on **Minecraft 26.2**.

| Specification | Target Parameter |
| :--- | :--- |
| **Minecraft Anchor** | `26.2` |
| **Mod SemVer** | `1.0.0+26.2` |
| **Fabric Loader** | `>=0.19.4` |
| **Java Toolchain** | Java 25 |
| **Loom Version** | `1.11` |
| **Status Classification** | 🟡 Parity Anchor |
| **Subproject Path** | `Creative Fly Speed v26.2` |

---

## 🧭 Subsystem Documentation Pages

Explore the 5 core technical guides for this version anchor:

1. [[✈️ Flight Speed Kinematics|ja_jp-26.2-Flight-Speed-Kinematics]]
   - Permille velocity calculation formulas ($S_{\text{fly}} = 0.05 \times \frac{P}{1000}$).
   - Sprint compounding ($1.4\times$) and float epsilon drift guards ($10^{-6}\text{ F}$).
   - Instantaneous server-to-client abilities packet dispatch.

2. [[⚙️ Configuration & Dynamic GameRules|ja_jp-26.2-Configuration-and-GameRules]]
   - Sovereign GameRules: `vo_creative_fly_speed:creative_fly_speed` & `vo_creative_fly_speed:spectator_fly_speed`.
   - Permille integer range $[1, 100000]$ ($0.001\times$ to $100.0\times$).
   - Dynamic unregistration lifecycle on server stop via `DynamicGameRuleManager`.

3. [[💬 Brigadier Commands & Suite (/cfs)|ja_jp-26.2-Commands-and-Brigadier]]
   - Complete `/cfs` and `/creativeflyspeed` command tree.
   - Live querying (`status`, `get`) and modification (`set`, `reset`).
   - Operator permissions and formatted feedback.

4. [[💻 Architecture & Mixins Breakdown|ja_jp-26.2-Architecture-and-Mixins]]
   - `ServerPlayerMixin.tick()` injection at `@At("HEAD")`.
   - Mixin purity: zero business logic in mixin, delegated to `FlySpeedLogic`.
   - $O(1)$ complexity, zero heap allocation, and Knot classloader safety.

5. [[🛠️ Developer Setup & Building|ja_jp-26.2-Developer-Setup-and-Building]]
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

[[⬅️ Back to Version Selector Portal|ja_jp-Home]]
