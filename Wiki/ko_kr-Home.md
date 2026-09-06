# ✈️ Vanilla Outsider: 크리에이티브 비행 속도 (Creative Fly Speed) 공식 위키

🌐 **Languages**: [[🇺🇸 English|Home]] | [[🇨🇳 简体中文|zh_cn-Home]] | [[🇭🇰 繁體中文|zh_tw-Home]] | [[🇷🇺 Русский|ru_ru-Home]] | [[🇪🇸 Español|es_es-Home]] | [[🇩🇪 Deutsch|de_de-Home]] | [[🇫🇷 Français|fr_fr-Home]] | [[🇧🇷 Português|pt_br-Home]] | [[🇯🇵 日本語|ja_jp-Home]] | [[🇮🇩 Bahasa Indonesia|id_id-Home]] | [[🇰🇷 한국어|ko_kr-Home]]

> 📌 **저장소 소스 코드 면책 조항**: 본 위키 문서는 **저장소의 현재 소스 코드 상태**를 반영하며, CurseForge 및 Modrinth의 공개 릴리스 빌드보다 앞선 최신 개발 커밋이나 미출시 기능이 포함되어 있을 수 있습니다.

---

## 🎯 공식 문서에 오신 것을 환영합니다

**Creative Fly Speed**는 **Dasik (Rifaditya)** 가 개발한 **Vanilla Outsider Collection**의 고성능 초경량 비행 운동학 모드입니다. 서버와 동기화되는 마인크래프트 기본 게임룰(GameRules)을 통해 크리에이티브 및 관전 모드에서 플레이어의 비행 속도를 부드럽고 완벽하게 제어할 수 있습니다.

**플레이어 자율성 원칙 (Player Agency & Anti-Nanny Invariant)** 에 따라 인위적인 제한을 두지 않습니다. 넓은 월드를 신속하게 탐색하기 위해 기본 속도의 최대 $100\times$까지 가속하거나, 정밀한 블록 배치를 위해 $0.1\times$까지 감속할 수 있습니다.

---

## 🧭 버전 선택 포털

대상 마인크래프트 버전을 선택하여 독립된 문서 트리로 이동하세요:

| 대상 마인크래프트 버전 | 릴리스 앵커 | 도구 체인 | 상태 | 바로가기 |
| :--- | :--- | :--- | :---: | :--- |
| **Minecraft 26.3** | `1.0.0+26.3` | Fabric Loader `>=0.19.3` / Java 25 | 🟢 최신 메인 | [[👉 MC 26.3 위키 포털|26.3-Home]] |
| **Minecraft 26.2** | `1.0.0+26.2` | Fabric Loader `>=0.16.10` / Java 25 | 🟡 패리티 버전 | [[👉 MC 26.2 위키 포털|26.2-Home]] |

> [!NOTE]
> 본 모드의 **1 Jar 1 Version Policy**에 따라 각 버전 브랜치는 독립적인 의존성 매핑을 갖춘 완전한 독립 빌드로 제작됩니다.

---

## 🌟 핵심 하위 시스템 개요

- **[[비행 속도 역학|26.3-Flight-Speed-Kinematics]]**:
  - 퍼밀(천분율) 계산 공식: $S_{\text{fly}} = 0.05 \times \frac{P}{1000}$ 블록/틱.
  - 전력 질주 가속 지원: 비행 중 질주 시 바닐라 $1.4\times$ 복합 가속.
  - 부동소수점 드리프트 방지 ($10^{-6}\text{ F}$)로 불필요한 네트워크 패킷 전송을 방지합니다 (안정 상태 시 0패킷).
  - 서바이벌 및 어드벤처 모드는 절대 간섭하지 않고 즉시 안전하게 우회합니다.
- **[[설정 및 게임룰|26.3-Configuration-and-GameRules]]**:
  - DasikLibrary 기반 동적 카테고리 등록 `vo_creative_fly_speed:fly_speed`.
  - `vo_creative_fly_speed`: 크리에이티브 모드 비행 배율 (기본값: `1000` = $1.0\times$).
  - `vo_spectator_fly_speed`: 관전 모드 비행 배율 (기본값: `1000` = $1.0\times$).
  - `1` ~ `100000` 범위 지원, `level.dat`에 네이티브 자동 저장.
- **[[아키텍처 및 믹스인|26.3-Architecture-and-Mixins]]**:
  - `ServerPlayer.tick()`의 `@At("HEAD")`에 대한 정밀 바이트코드 주입.
  - 믹스인 순수성 준수: 믹스인 내부 비즈니스 로직을 배제하고 `FlySpeedLogic`에 전체 위임.
  - $O(1)$ 연산 효율 및 힙(Heap) 메모리 할당 0 바이트 달성.

---

## 📚 개발자 가이드 및 문제 해결

- [[버전 호환성 매트릭스|Version-Compatibility]]: Loom, Fabric Loader, Parchment 및 Java 25 사양.
- [[문제 해결 및 FAQ|Troubleshooting-and-FAQ]]: 드리프트 진단, 패킷 동기화 및 월드 저장 문제 해결.
- [[개발 환경 설정 및 빌드 가이드|Developer-Setup-and-Building]]: Gradle 9.3+ 빌드 지침.

---

## 📜 제작자 및 라이선스

- **제작 및 유지보수**: **Dasik (Rifaditya)**
- **라이선스**: **GNU General Public License v3.0 (GPLv3)**
- **소스 코드 저장소**: [GitHub Repository](https://github.com/Rifaditya/Creative-Fly-Speed)
