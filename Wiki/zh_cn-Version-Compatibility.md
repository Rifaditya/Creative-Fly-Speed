# 📋 版本兼容性与工具链矩阵

🌐 **Languages**: [[🇺🇸 English|Home]] | [[🇨🇳 简体中文|zh_cn-Home]] | [[🇭🇰 繁體中文|zh_tw-Home]] | [[🇷🇺 Русский|ru_ru-Home]] | [[🇪🇸 Español|es_es-Home]] | [[🇩🇪 Deutsch|de_de-Home]] | [[🇫🇷 Français|fr_fr-Home]] | [[🇧🇷 Português|pt_br-Home]] | [[🇯🇵 日本語|ja_jp-Home]] | [[🇮🇩 Bahasa Indonesia|id_id-Home]] | [[🇰🇷 한국어|ko_kr-Home]]

> 📌 **仓库源码免责声明**：本 Wiki 中的文档反映了**仓库中的当前源代码状态**，可能包含领先于 CurseForge 和 Modrinth 上公开版本的近期未发布提交或开发特性。

---

## 🏛️ “单版本单 Jar (1 Jar 1 Version)” 策略

**Creative Fly Speed** 严格恪守 **1 Jar 1 Version 策略**：
- **拒绝缝合怪通用 Jar**：与其在不同 Minecraft 快照架构之间引入不安全的运行时反射或脆弱的类加载黑客技巧，本模组将每个 Minecraft 发布锚点作为独立的确定性子项目进行开发与编译。
- **独立子工程**：
  - `Creative Fly Speed/`（Minecraft 26.2 锚点）
  - `Creative Fly Speed v26.3/Creative Fly Speed 26.3/`（Minecraft 26.3 锚点）
- **通用库例外**：唯一跨多个版本的模块是 `DasikLibrary`，它严格遵循向后兼容的 API 契约。

---

## 📊 Complete Technical Compatibility Matrix

| Minecraft Anchor | Mod Release Target | Fabric Loader | Fabric API | Java Runtime | Mappings / Parchment | DasikLibrary Version | Release Status |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
| **Minecraft 26.3** | `1.0.0+26.3` | `>=0.19.3` | `0.156.1+26.3` | **Java 25** (`>=25`) | Yarn `26.3-snapshot-6` / Parchment `2026.01.22` | `>=1.8.36` | 🟢 **Active Current** |
| **Minecraft 26.2** | `1.0.0+26.2` | `>=0.16.10` | `0.142.1+26.1` | **Java 25** (`>=25`) | Yarn `26.1-snapshot-11+build.1` / Parchment `2026.01.22` | `>=1.6.9+build.14` | 🟡 **Parity Anchor** |

---

## 🧩 Dependencies & Ecosystem Integration

| Dependency | Dependency ID | Required Bounds | Side Scope | Purpose |
| :--- | :--- | :--- | :---: | :--- |
| **Fabric Loader** | `fabricloader` | `>=0.16.9` | Client & Server | Mod loading environment and Mixin transformation service |
| **Fabric API** | `fabric-api` | `*` | Client & Server | Core lifecycle hooks and server networking event pipelines |
| **Java Runtime** | `java` | `>=25` | Client & Server | Modern JVM features (Records, Switch pattern matching, Unnamed variables) |
| **DasikLibrary** | `dasiklibrary` | `>=1.6.9` (26.2) / `>=1.8.36` (26.3) | Client & Server | Dynamic GameRule registration (`DynamicGameRuleManager`) and category binding |

---

## 🔒 Dedicated Server & Classloader Safety

Creative Fly Speed is fully engineered for multi-environment reliability:
- **Dedicated Server**: Runs headless without any client graphical dependencies.
- **Pure GameRule Architecture**: Speed modifications take place in `ServerPlayer` on the logical server, automatically transmitting ability updates to connected clients.
- **Client Independence**: While client entrypoint `CreativeFlySpeedFabricClient` is registered for Fabric standards, unmodded vanilla clients can connect to servers running Creative Fly Speed if permitted by server packet configurations.

---

## 🗄️ Local Archive & Build Artifacts

Compiled mod JARs are automatically archived under:
- `Archive Jar of all versions/MC 26.3/`
- `Creative Fly Speed/Archive/`
- Central Release Hub: `minecraft-mod-release-hub/archives/creative-fly-speed/`
