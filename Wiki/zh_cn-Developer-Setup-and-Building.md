# 🛠️ 开发者环境配置与编译指南

🌐 **Languages**: [[🇺🇸 English|Home]] | [[🇨🇳 简体中文|zh_cn-Home]] | [[🇭🇰 繁體中文|zh_tw-Home]] | [[🇷🇺 Русский|ru_ru-Home]] | [[🇪🇸 Español|es_es-Home]] | [[🇩🇪 Deutsch|de_de-Home]] | [[🇫🇷 Français|fr_fr-Home]] | [[🇧🇷 Português|pt_br-Home]] | [[🇯🇵 日本語|ja_jp-Home]] | [[🇮🇩 Bahasa Indonesia|id_id-Home]] | [[🇰🇷 한국어|ko_kr-Home]]

> 📌 **仓库源码免责声明**：本 Wiki 中的文档反映了**仓库中的当前源代码状态**，可能包含领先于 CurseForge 和 Modrinth 上公开版本的近期未发布提交或开发特性。

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
- [[Version Compatibility|zh_cn-Version-Compatibility]]
- [[MC 26.3 Developer Setup|zh_cn-26.3-Developer-Setup-and-Building]]
- [[MC 26.2 Developer Setup|zh_cn-26.2-Developer-Setup-and-Building]]
- [[Return to Home Portal|zh_cn-Home]]
