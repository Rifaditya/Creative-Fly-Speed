# 📋 Version Compatibility & Matrix

> 📌 **저장소 소스 코드 면책 조항**: 이 위키의 문서는 CurseForge 및 Modrinth의 공개 릴리스 빌드보다 앞선 최신 미출시 커밋 또는 개발 기능을 포함할 수 있는 **저장소의 현재 소스 코드 상태**를 반영합니다.

---

## 1. Supported Minecraft Version Anchors

Creative Fly Speed maintains strict parity across **6 version anchors** under the **1 Jar 1 Version Policy**. Each anchor is built, tested, and packaged independently:

| Minecraft Version | Release Tag | Fabric Loader | Java Requirement | Loom Toolchain | Branch / Subproject | Status |
| :--- | :--- | :--- | :--- | :--- | :--- | :---: |
| **MC 26.3** | `1.0.0+26.3` | `>=0.19.5` | Java 25 | Loom `1.11` | `Creative Fly Speed v26.3` | 🟢 Active Lead |
| **MC 26.2** | `1.0.0+26.2` | `>=0.19.4` | Java 25 | Loom `1.11` | `Creative Fly Speed v26.2` | 🟡 Parity Anchor |
| **MC 26.1.2** | `1.0.0+26.1.2` | `>=0.19.3` | Java 25 | Loom `1.11` | `Creative Fly Speed v26.1.2` | 🟡 Parity Anchor |
| **MC 1.21.11** | `1.0.0+1.21.11` | `>=0.16.5` | Java 21 | Loom `1.10` | `Creative Fly Speed v1.21.11` | 🔵 Transitional Anchor |
| **MC 1.21.1** | `1.0.0+1.21.1` | `>=0.16.0` | Java 21 | Loom `1.10` | `Creative Fly Speed v1.21.1` | 🟠 Legacy Anchor |
| **MC 1.20.1** | `1.0.0+1.20.1` | `>=0.15.11` | Java 17 | Loom `1.10` | `Creative Fly Speed v1.20.1` | 🟣 Master Legacy |

---

## 2. Java Runtime Compatibility

- **Java 25 (Modern Sovereign Anchors)**: Targeted by `26.1.2`, `26.2`, and `26.3`. Leverages modern JVM optimizations, compact records, and virtual thread ergonomics.
- **Java 21 (Transitional & Modern Legacy)**: Targeted by `1.21.1` and `1.21.11`.
- **Java 17 (Legacy Master Anchor)**: Targeted by `1.20.1` for maximum modpack backward compatibility.

---

## 3. Dependency Requirements

| Dependency | Required Version | Scope | Note |
| :--- | :--- | :--- | :--- |
| **Fabric Loader** | `>=0.15.11` to `>=0.19.5` | Required | Standard Fabric runtime loader |
| **Fabric API** | `*` (Era-appropriate) | Required | Provides command registration & lifecycle events |
| **DasikLibrary** | `>=1.9.0` | Required | Powers `DynamicGameRuleManager` and creator support links |
| **ModMenu** | Optional | Client-side | Adds configuration / support links in mod list |

---

## 4. Cross-Version Invariants

Across all supported versions:
- GameRule categories and keys are 100% identical: `vo_creative_fly_speed:fly_speed`, `vo_creative_fly_speed:creative_fly_speed`, `vo_creative_fly_speed:spectator_fly_speed`.
- Brigadier commands `/cfs` and `/creativeflyspeed` are registered identically.
- Zero configuration files are written to disk; world persistence is entirely inside `level.dat`.
- Mathematical velocity calculations and epsilon guards are identical across all anchors.
