# 🛠️ MC 26.3 개발자 환경 설정 및 빌드 가이드

🌐 **Languages**: [[🇺🇸 English|Home]] | [[🇨🇳 简体中文|zh_cn-Home]] | [[🇭🇰 繁體中文|zh_tw-Home]] | [[🇷🇺 Русский|ru_ru-Home]] | [[🇪🇸 Español|es_es-Home]] | [[🇩🇪 Deutsch|de_de-Home]] | [[🇫🇷 Français|fr_fr-Home]] | [[🇧🇷 Português|pt_br-Home]] | [[🇯🇵 日本語|ja_jp-Home]] | [[🇮🇩 Bahasa Indonesia|id_id-Home]] | [[🇰🇷 한국어|ko_kr-Home]]

> 📌 **저장소 소스 코드 면책 조항**: 이 위키의 문서는 CurseForge 및 Modrinth의 공개 릴리스 빌드보다 앞선 최근 미출시 커밋 또는 개발 기능을 포함할 수 있는 **저장소의 현재 소스 코드 상태**를 반영합니다.

---

## 💻 26.3 Toolchain & Build Specifications

| Tool / Dependency | Version / Requirement | Notes |
| :--- | :--- | :--- |
| **Target Minecraft** | `26.3` | Official Mojang release anchor |
| **Java Development Kit** | **JDK 25** (`>=25`) | Temurin / OpenJDK 25 HotSpot |
| **Gradle Wrapper** | **Gradle 9.3.1** | Native wrapper scripts included |
| **Fabric Loader** | `0.19.3` | Loom Fabric loader runtime |
| **Fabric API** | `0.156.1+26.3` | Snapshot event bus & networking |
| **DasikLibrary** | `1.8.36` | Dynamic GameRule API provider |

---

## 🏗️ Step-by-Step Build Instructions

### 1. Navigate to the 26.3 Subproject
```powershell
cd "Creative Fly Speed v26.3/Creative Fly Speed 26.3"
```

### 2. Execute Headless Gradle Build
```powershell
./gradlew clean build --no-daemon
```

### 3. Output Location
```
Creative Fly Speed v26.3/Creative Fly Speed 26.3/build/libs/
├── creative-fly-speed-1.0.0+26.3.jar            <-- Production Mod JAR
└── creative-fly-speed-1.0.0+26.3-sources.jar
```

---

## 🔗 Related Documentation
- [[MC 26.3 Flight Speed Kinematics|ko_kr-26.3-Flight-Speed-Kinematics]]
- [[MC 26.3 Configuration & Dynamic GameRules|ko_kr-26.3-Configuration-and-GameRules]]
- [[MC 26.3 Architecture & Mixins Breakdown|ko_kr-26.3-Architecture-and-Mixins]]
- [[Return to MC 26.3 Portal|ko_kr-26.3-Home]]
