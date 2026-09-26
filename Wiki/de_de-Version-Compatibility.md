# 📋 Versionskompatibilität & Toolchain-Matrix

🌐 **Languages**: [[🇺🇸 English|Home]] | [[🇨🇳 简体中文|zh_cn-Home]] | [[🇭🇰 繁體中文|zh_tw-Home]] | [[🇷🇺 Русский|ru_ru-Home]] | [[🇪🇸 Español|es_es-Home]] | [[🇩🇪 Deutsch|de_de-Home]] | [[🇫🇷 Français|fr_fr-Home]] | [[🇧🇷 Português|pt_br-Home]] | [[🇯🇵 日本語|ja_jp-Home]] | [[🇮🇩 Bahasa Indonesia|id_id-Home]] | [[🇰🇷 한국어|ko_kr-Home]]

> 📌 **Haftungsausschluss zum Repository-Quellcode**: Die Dokumentation in diesem Wiki spiegelt den **aktuellen Quellcode-Zustand im Repository** wider, der neuere unveröffentlichte Commits oder Entwicklungsfunktionen vor den öffentlichen Builds auf CurseForge und Modrinth enthalten kann.

---

## 🏛️ Die „1-Jar-1-Version“-Richtlinie

**Creative Fly Speed** hält sich strikt an die **1-Jar-1-Version-Richtlinie**:
- **Keine Frankenstein-Universal-JARs**: Jeder Release-Anker wird als unabhängiges deterministisches Teilprojekt entwickelt und kompiliert.
- **Dedizierte Teilprojekte**:
  - `Creative Fly Speed/` (Minecraft 26.2 Anker)
  - `Creative Fly Speed v26.3/Creative Fly Speed 26.3/` (Minecraft 26.3 Anker)
- **Universelle Bibliotheksausnahme**: Das einzige versionsübergreifende Modul ist `DasikLibrary`.

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
