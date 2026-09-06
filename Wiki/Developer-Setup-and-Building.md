# 🛠️ Developer Setup & Building Guide

🌐 **Languages**: [[🇺🇸 English|Home]] | [[🇨🇳 简体中文|zh_cn-Home]] | [[🇭🇰 繁體中文|zh_tw-Home]] | [[🇷🇺 Русский|ru_ru-Home]] | [[🇪🇸 Español|es_es-Home]] | [[🇩🇪 Deutsch|de_de-Home]] | [[🇫🇷 Français|fr_fr-Home]] | [[🇧🇷 Português|pt_br-Home]] | [[🇯🇵 日本語|ja_jp-Home]] | [[🇮🇩 Bahasa Indonesia|id_id-Home]] | [[🇰🇷 한국어|ko_kr-Home]]

> 📌 **Repository Source Disclaimer**: The documentation in this Wiki reflects the **current source code state in the repository**, which may include recent unreleased commits or developmental features ahead of public release builds on CurseForge and Modrinth.

---

## 💻 Prerequisites & Development Environment

To compile, test, or contribute to **Creative Fly Speed**, ensure your environment meets the following specifications:

- **Java Development Kit (JDK)**: **JDK 25** (Eclipse Adoptium Temurin 25 or Microsoft OpenJDK 25).
- **Build Automation**: **Gradle 9.3+** (bundled via `gradlew` wrapper).
- **IDE**: IntelliJ IDEA 2025.3+ or Eclipse with modern Java 25 preview support.
- **Git**: Configured for LF/CRLF hygiene.

---

## 🏗️ Repository Layout

The repository is structured around isolated version subprojects:

```
Creative Fly Speed/
├── Creative Fly Speed/                     <-- Minecraft 26.2 Anchor
│   ├── build.gradle
│   ├── gradle.properties                  (minecraft_version=26.1-snapshot-11)
│   └── src/main/java/net/vanillaoutsider/vo_creative_fly_speed/
├── Creative Fly Speed v26.3/
│   └── Creative Fly Speed 26.3/            <-- Minecraft 26.3 Anchor
│       ├── build.gradle
│       ├── gradle.properties              (minecraft_version=26.3-snapshot-6)
│       └── src/main/java/net/vanillaoutsider/vo_creative_fly_speed/
├── Archive Jar of all versions/            <-- Release JAR preservation
└── Wiki/                                   <-- Master GitHub Wiki Documentation
```

---

## ⚡ Building the Projects

Navigate to either subproject directory and run the Gradle wrapper:

### 1. Building the Minecraft 26.3 Anchor
```powershell
cd "Creative Fly Speed v26.3\Creative Fly Speed 26.3"
./gradlew build --no-daemon
```

### 2. Building the Minecraft 26.2 Anchor
```powershell
cd "Creative Fly Speed"
./gradlew build --no-daemon
```

### 3. Build Output Artifacts
Successful builds produce the remapped mod JAR inside `build/libs/`:
- `creative-fly-speed-1.0.0+26.3.jar`
- `creative-fly-speed-1.0.0+26.1.jar`

---

## 🧩 Gradle Properties Reference

### Minecraft 26.3 Configuration (`gradle.properties`)
```properties
org.gradle.parallel=false
mod_name=Creative Fly Speed
mod_version=1.0.0+26.3
maven_group=net.vanillaoutsider
archives_base_name=creative-fly-speed

minecraft_version=26.3-snapshot-6
parchment_minecraft_version=26.3-snapshot-6
parchment_version=2026.01.22

fabric_version=0.156.1+26.3
fabric_loader_version=0.19.3

fabric.loom.suppressJavaCompatibilityChecks=true
loom.suppressJavaCompatibilityChecks=true

dasik_library_version=1.8.36
```

### Minecraft 26.2 Configuration (`gradle.properties`)
```properties
org.gradle.parallel=false
mod_name=Creative Fly Speed
mod_version=1.0.0+26.1
maven_group=net.vanillaoutsider
archives_base_name=creative-fly-speed

minecraft_version=26.1-snapshot-11
yarn_mappings=26.1-snapshot-11+build.1
parchment_minecraft_version=26.1-snapshot-11
parchment_version=2026.01.22

fabric_version=0.142.1+26.1
fabric_loader_version=0.16.10

fabric.loom.suppressJavaCompatibilityChecks=true
loom.suppressJavaCompatibilityChecks=true

dasik_library_version=1.6.9+build.14
```

---

## 🔗 Related Version References

- [[MC 26.3 Developer Setup Guide|26.3-Developer-Setup-and-Building]]
- [[MC 26.2 Developer Setup Guide|26.2-Developer-Setup-and-Building]]
- [[Architecture & Mixins Breakdown|26.3-Architecture-and-Mixins]]
- [[Return to Home Portal|Home]]
