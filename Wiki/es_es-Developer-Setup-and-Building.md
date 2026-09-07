# 🛠️ Guía de configuración y compilación para desarrolladores

🌐 **Languages**: [[🇺🇸 English|Home]] | [[🇨🇳 简体中文|zh_cn-Home]] | [[🇭🇰 繁體中文|zh_tw-Home]] | [[🇷🇺 Русский|ru_ru-Home]] | [[🇪🇸 Español|es_es-Home]] | [[🇩🇪 Deutsch|de_de-Home]] | [[🇫🇷 Français|fr_fr-Home]] | [[🇧🇷 Português|pt_br-Home]] | [[🇯🇵 日本語|ja_jp-Home]] | [[🇮🇩 Bahasa Indonesia|id_id-Home]] | [[🇰🇷 한국어|ko_kr-Home]]

> 📌 **Descargo de responsabilidad del código fuente del repositorio**: La documentación de esta Wiki refleja el **estado actual del código fuente en el repositorio**, que puede incluir confirmaciones recientes no publicadas o características en desarrollo antes de las compilaciones públicas en CurseForge y Modrinth.

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
- [[Version Compatibility|es_es-Version-Compatibility]]
- [[MC 26.3 Developer Setup|es_es-26.3-Developer-Setup-and-Building]]
- [[MC 26.2 Developer Setup|es_es-26.2-Developer-Setup-and-Building]]
- [[Return to Home Portal|es_es-Home]]
