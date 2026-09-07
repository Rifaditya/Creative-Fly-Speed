# 🛠️ 개발자 환경 설정 및 빌드 가이드

🌐 **Languages**: [[🇺🇸 English|Home]] | [[🇨🇳 简体中文|zh_cn-Home]] | [[🇭🇰 繁體中文|zh_tw-Home]] | [[🇷🇺 Русский|ru_ru-Home]] | [[🇪🇸 Español|es_es-Home]] | [[🇩🇪 Deutsch|de_de-Home]] | [[🇫🇷 Français|fr_fr-Home]] | [[🇧🇷 Português|pt_br-Home]] | [[🇯🇵 日本語|ja_jp-Home]] | [[🇮🇩 Bahasa Indonesia|id_id-Home]] | [[🇰🇷 한국어|ko_kr-Home]]

> 📌 **저장소 소스 코드 면책 조항**: 이 위키의 문서는 CurseForge 및 Modrinth의 공개 릴리스 빌드보다 앞선 최근 미출시 커밋 또는 개발 기능을 포함할 수 있는 **저장소의 현재 소스 코드 상태**를 반영합니다.

---

## 💻 Prerequisites & Setup

- **Java Development Kit (JDK)**: **JDK 25** (`>=25`)
- **Gradle**: Wrapper included (`./gradlew`)
- **IDE**: IntelliJ IDEA 2025.3+ or Eclipse

```bash
git clone https://github.com/Rifaditya/Creative-Fly-Speed.git
cd Creative-Fly-Speed
```

## 🏗️ Multi-Version Subprojects

### Build for Minecraft 26.2:
```bash
cd "Creative Fly Speed"
./gradlew clean build --no-daemon
```

### Build for Minecraft 26.3:
```bash
cd "Creative Fly Speed v26.3/Creative Fly Speed 26.3"
./gradlew clean build --no-daemon
```

---

## 🔗 Related Documentation
- [[Version Compatibility|ko_kr-Version-Compatibility]]
- [[MC 26.3 Developer Setup|ko_kr-26.3-Developer-Setup-and-Building]]
- [[MC 26.2 Developer Setup|ko_kr-26.2-Developer-Setup-and-Building]]
- [[Return to Home Portal|ko_kr-Home]]
