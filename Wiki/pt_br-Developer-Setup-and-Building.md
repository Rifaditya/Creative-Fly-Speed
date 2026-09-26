# 🛠️ Guia de Configuração e Compilação para Desenvolvedores

🌐 **Languages**: [[🇺🇸 English|Home]] | [[🇨🇳 简体中文|zh_cn-Home]] | [[🇭🇰 繁體中文|zh_tw-Home]] | [[🇷🇺 Русский|ru_ru-Home]] | [[🇪🇸 Español|es_es-Home]] | [[🇩🇪 Deutsch|de_de-Home]] | [[🇫🇷 Français|fr_fr-Home]] | [[🇧🇷 Português|pt_br-Home]] | [[🇯🇵 日本語|ja_jp-Home]] | [[🇮🇩 Bahasa Indonesia|id_id-Home]] | [[🇰🇷 한국어|ko_kr-Home]]

> 📌 **Isenção de Responsabilidade do Código-Fonte do Repositório**: A documentação nesta Wiki reflete o **estado atual do código-fonte no repositório**, que pode incluir commits recentes não lançados ou recursos de desenvolvimento à frente das versões públicas no CurseForge e Modrinth.

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
- [[Version Compatibility|pt_br-Version-Compatibility]]
- [[MC 26.3 Developer Setup|pt_br-26.3-Developer-Setup-and-Building]]
- [[MC 26.2 Developer Setup|pt_br-26.2-Developer-Setup-and-Building]]
- [[Return to Home Portal|pt_br-Home]]
