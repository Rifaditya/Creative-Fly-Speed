# 🛠️ 開発環境構築およびビルドガイド

🌐 **Languages**: [[🇺🇸 English|Home]] | [[🇨🇳 简体中文|zh_cn-Home]] | [[🇭🇰 繁體中文|zh_tw-Home]] | [[🇷🇺 Русский|ru_ru-Home]] | [[🇪🇸 Español|es_es-Home]] | [[🇩🇪 Deutsch|de_de-Home]] | [[🇫🇷 Français|fr_fr-Home]] | [[🇧🇷 Português|pt_br-Home]] | [[🇯🇵 日本語|ja_jp-Home]] | [[🇮🇩 Bahasa Indonesia|id_id-Home]] | [[🇰🇷 한국어|ko_kr-Home]]

> 📌 **リポジトリソースコードに関する免責事項**: この Wiki のドキュメントは**リポジトリ内の現在のソースコードの状態**を反映しており、CurseForge および Modrinth での公開リリースビルドに先駆けた最新の未リリースコミットや開発中の機能が含まれている場合があります。

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
- [[Version Compatibility|ja_jp-Version-Compatibility]]
- [[MC 26.3 Developer Setup|ja_jp-26.3-Developer-Setup-and-Building]]
- [[MC 26.2 Developer Setup|ja_jp-26.2-Developer-Setup-and-Building]]
- [[Return to Home Portal|ja_jp-Home]]
