# 📋 버전 호환성 및 툴체인 매트릭스

🌐 **Languages**: [[🇺🇸 English|Home]] | [[🇨🇳 简体中文|zh_cn-Home]] | [[🇭🇰 繁體中文|zh_tw-Home]] | [[🇷🇺 Русский|ru_ru-Home]] | [[🇪🇸 Español|es_es-Home]] | [[🇩🇪 Deutsch|de_de-Home]] | [[🇫🇷 Français|fr_fr-Home]] | [[🇧🇷 Português|pt_br-Home]] | [[🇯🇵 日本語|ja_jp-Home]] | [[🇮🇩 Bahasa Indonesia|id_id-Home]] | [[🇰🇷 한국어|ko_kr-Home]]

> 📌 **저장소 소스 코드 면책 조항**: 이 위키의 문서는 CurseForge 및 Modrinth의 공개 릴리스 빌드보다 앞선 최근 미출시 커밋 또는 개발 기능을 포함할 수 있는 **저장소의 현재 소스 코드 상태**를 반영합니다.

---

## 🏛️ "1 Jar 1 Version" 정책

**Creative Fly Speed**는 **1 Jar 1 Version 정책**을 엄격히 준수합니다:
- **누더기 범용 JAR 배제**: 취약한 리플렉션 대신 각 마인크래프트 앵커를 독립적인 결정론적 하위 프로젝트로 개발 및 컴파일합니다.
- **전용 하위 프로젝트**:
  - `Creative Fly Speed/` (마인크래프트 26.2 앵커)
  - `Creative Fly Speed v26.3/Creative Fly Speed 26.3/` (마인크래프트 26.3 앵커)
- **범용 라이브러리 예외**: 다중 버전을 아우르는 유일한 모듈은 `DasikLibrary`뿐입니다.

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
