# 🛠️ Guía de configuración de desarrollo y compilación de MC 26.2

🌐 **Languages**: [[🇺🇸 English|Home]] | [[🇨🇳 简体中文|zh_cn-Home]] | [[🇭🇰 繁體中文|zh_tw-Home]] | [[🇷🇺 Русский|ru_ru-Home]] | [[🇪🇸 Español|es_es-Home]] | [[🇩🇪 Deutsch|de_de-Home]] | [[🇫🇷 Français|fr_fr-Home]] | [[🇧🇷 Português|pt_br-Home]] | [[🇯🇵 日本語|ja_jp-Home]] | [[🇮🇩 Bahasa Indonesia|id_id-Home]] | [[🇰🇷 한국어|ko_kr-Home]]

> 📌 **Descargo de responsabilidad del código fuente del repositorio**: La documentación de esta Wiki refleja el **estado actual del código fuente en el repositorio**, que puede incluir confirmaciones recientes no publicadas o características en desarrollo antes de las compilaciones públicas en CurseForge y Modrinth.

---

## 💻 26.2 Toolchain & Build Specifications

| Tool / Dependency | Version / Requirement | Notes |
| :--- | :--- | :--- |
| **Target Minecraft** | `26.2` | Official Mojang release anchor |
| **Java Development Kit** | **JDK 25** (`>=25`) | Temurin / OpenJDK 25 HotSpot |
| **Gradle Wrapper** | **Gradle 9.3.1** | Native wrapper scripts included |
| **Fabric Loader** | `0.16.10` | Loom Fabric loader runtime |
| **Fabric API** | `0.142.1+26.1` | Snapshot event bus & networking |
| **DasikLibrary** | `1.6.9+build.14` | Dynamic GameRule API provider |

---

## 🏗️ Step-by-Step Build Instructions

### 1. Navigate to the 26.2 Subproject
```powershell
cd "Creative Fly Speed"
```

### 2. Execute Headless Gradle Build
```powershell
./gradlew clean build --no-daemon
```

### 3. Output Location
```
Creative Fly Speed/build/libs/
├── creative-fly-speed-1.0.0+26.2.jar            <-- Production Mod JAR
└── creative-fly-speed-1.0.0+26.2-sources.jar
```

---

## 🔗 Related Documentation
- [[MC 26.2 Flight Speed Kinematics|es_es-26.2-Flight-Speed-Kinematics]]
- [[MC 26.2 Configuration & Dynamic GameRules|es_es-26.2-Configuration-and-GameRules]]
- [[MC 26.2 Architecture & Mixins Breakdown|es_es-26.2-Architecture-and-Mixins]]
- [[Return to MC 26.2 Portal|es_es-26.2-Home]]
