# ✈️ Vanilla Outsider: Creative Fly Speed Offizielles Wiki

🌐 **Languages**: [[🇺🇸 English|Home]] | [[🇨🇳 简体中文|zh_cn-Home]] | [[🇭🇰 繁體中文|zh_tw-Home]] | [[🇷🇺 Русский|ru_ru-Home]] | [[🇪🇸 Español|es_es-Home]] | [[🇩🇪 Deutsch|de_de-Home]] | [[🇫🇷 Français|fr_fr-Home]] | [[🇧🇷 Português|pt_br-Home]] | [[🇯🇵 日本語|ja_jp-Home]] | [[🇮🇩 Bahasa Indonesia|id_id-Home]] | [[🇰🇷 한국어|ko_kr-Home]]

> 📌 **Haftungsausschluss für Quellcode**: Die Dokumentation in diesem Wiki spiegelt den **aktuellen Stand des Quellcodes im Repository** wider, der neuere, noch nicht veröffentlichte Commits oder Entwicklungsfunktionen vor den öffentlichen Builds auf CurseForge und Modrinth enthalten kann.

---

## 🎯 Willkommen zur offiziellen Dokumentation

**Creative Fly Speed** ist eine leichtgewichtige Hochleistungs-Flugkinematik-Mod der **Vanilla Outsider Collection**, entwickelt von **Dasik (Rifaditya)**. Sie bietet Buildern, Kartenerstellern, Server-Operatoren und Kameraleuten eine native und nahtlose Kontrolle über die Fluggeschwindigkeit im Kreativ- und Zuschauermodus über serverseitig synchronisierte GameRules.

Getreu dem Prinzip der **Spielerautonomie (Player Agency & Anti-Nanny Invariant)** gibt es keine künstlichen Obergrenzen: Geschwindigkeiten können bis auf das $100\times$ der Standardgeschwindigkeit für schnelles Reisen gesteigert oder auf $0.1\times$ für feinste Bauarbeiten gedrosselt werden.

---

## 🧭 Versionsauswahl-Portal

Wählen Sie Ihre Ziel-Minecraft-Version aus, um auf die entsprechende Dokumentation zuzugreifen:

| Zielversion | Versions-Release | Toolchain | Status | Direkter Link |
| :--- | :--- | :--- | :---: | :--- |
| **Minecraft 26.3** | `1.0.0+26.3` | Fabric Loader `>=0.19.3` / Java 25 | 🟢 Aktuell | [[👉 Zum MC 26.3 Wiki|de_de-26.3-Home]] |
| **Minecraft 26.2** | `1.0.0+26.2` | Fabric Loader `>=0.16.10` / Java 25 | 🟡 Parität | [[👉 Zum MC 26.2 Wiki|de_de-26.2-Home]] |

> [!NOTE]
> Gemäß der **1 Jar 1 Version Policy** wird jeder Versionszweig als unabhängiges, eigenständiges Artefakt mit separaten Abhängigkeitsmappings gebaut.

---

## 🌟 Übersicht der Kernsysteme

- **[[Fluggeschwindigkeits-Kinematik|de_de-26.3-Flight-Speed-Kinematics]]**:
  - Promille-Geschwindigkeitsformel: $S_{\text{fly}} = 0.05 \times \frac{P}{1000}$ Blöcke/Tick.
  - Sprint-Multiplikator: Zusätzlicher $1.4\times$ Schub im Sprintflug.
  - Epsilon-Driftschutz ($10^{-6}\text{ F}$), der redundante Netzwerkpakete verhindert.
  - Modus-Sicherheit: Überlebens- und Abenteuermodi bleiben vollständig unberührt.
- **[[Konfiguration & Regeln|de_de-26.3-Configuration-and-GameRules]]**:
  - Dynamische Registrierung unter `vo_creative_fly_speed:fly_speed` via DasikLibrary.
  - `vo_creative_fly_speed`: Flugmultiplikator im Kreativmodus (Standard: `1000` = $1.0\times$).
  - `vo_spectator_fly_speed`: Flugmultiplikator im Zuschauermodus (Standard: `1000` = $1.0\times$).
  - Wertebereich von `1` bis `100000`, native Speicherung in `level.dat`.
- **[[Architektur & Mixins|de_de-26.3-Architecture-and-Mixins]]**:
  - Saubere Injektion in `ServerPlayer.tick()` bei `@At("HEAD")`.
  - Keine Geschäftslogik im Mixin: Volle Delegation an `FlySpeedLogic`.
  - $O(1)$ Zeitkomplexität ohne Heap-Allokationen.

---

## 📚 Entwicklerdokumentation & Fehlerbehebung

- [[Versionskompatibilitäts-Matrix|de_de-Version-Compatibility]]: Toolchain, Fabric Loader und Java 25.
- [[Fehlerbehebung & FAQ|de_de-Troubleshooting-and-FAQ]]: Häufig gestellte Fragen, Drift-Diagnose und Speicherung.
- [[Entwickler-Setup & Bauanleitung|de_de-Developer-Setup-and-Building]]: Kompilieren mit Gradle 9.3+.

---

## 📜 Credits & Lizenz

- **Autor & Entwickler**: **Dasik (Rifaditya)**
- **Lizenz**: **GNU General Public License v3.0 (GPLv3)**
- **Quellcode**: [GitHub Repository](https://github.com/Rifaditya/Creative-Fly-Speed)
