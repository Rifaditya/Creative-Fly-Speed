# 📋 版本相容性與工具鏈矩陣

🌐 **Languages**: [[🇺🇸 English|Home]] | [[🇨🇳 简体中文|zh_cn-Home]] | [[🇭🇰 繁體中文|zh_tw-Home]] | [[🇷🇺 Русский|ru_ru-Home]] | [[🇪🇸 Español|es_es-Home]] | [[🇩🇪 Deutsch|de_de-Home]] | [[🇫🇷 Français|fr_fr-Home]] | [[🇧🇷 Português|pt_br-Home]] | [[🇯🇵 日本語|ja_jp-Home]] | [[🇮🇩 Bahasa Indonesia|id_id-Home]] | [[🇰🇷 한국어|ko_kr-Home]]

> 📌 **存放庫原始碼免責聲明**：本 Wiki 中的文件反映了**存放庫中的當前原始碼狀態**，可能包含領先於 CurseForge 與 Modrinth 上公開版本的近期未發布提交或開發特性。

---

## 🏛️ 「單版本單 Jar (1 Jar 1 Version)」策略

**Creative Fly Speed** 嚴格恪守 **1 Jar 1 Version 策略**：
- **拒絕拼裝怪通用 Jar**：與其在不同 Minecraft 快照架構之間引入不安全的執行時期反射或脆弱的類別載入黑客技巧，本模組將每個 Minecraft 發布錨點作為獨立的確定性子專案進行開發與編譯。
- **獨立子工程**：
  - `Creative Fly Speed/`（Minecraft 26.2 錨點）
  - `Creative Fly Speed v26.3/Creative Fly Speed 26.3/`（Minecraft 26.3 錨點）
- **通用程式庫例外**：唯一跨多個版本的模組是 `DasikLibrary`，它嚴格遵循向後相容的 API 契約。

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
