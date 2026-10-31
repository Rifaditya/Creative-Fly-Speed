# 🛠️ Developer Setup & Building Guide

> 📌 **저장소 소스 코드 면책 조항**: 이 위키의 문서는 CurseForge 및 Modrinth의 공개 릴리스 빌드보다 앞선 최신 미출시 커밋 또는 개발 기능을 포함할 수 있는 **저장소의 현재 소스 코드 상태**를 반영합니다.

---

## 1. Multi-Anchor Workspace Architecture

The Creative Fly Speed repository employs a multi-anchor structure adhering to the **1 Jar 1 Version Policy**:

```
Creative Fly Speed mod/
├── Creative Fly Speed v1.20.1/     # Legacy Master Anchor (Java 17, Loom 1.10)
├── Creative Fly Speed v1.21.1/     # Modern Legacy Anchor (Java 21, Loom 1.10)
├── Creative Fly Speed v1.21.11/    # Transitional Anchor (Java 21, Loom 1.10)
├── Creative Fly Speed v26.1.2/     # Sovereign Anchor (Java 25, Loom 1.11)
├── Creative Fly Speed v26.2/       # Sovereign Anchor (Java 25, Loom 1.11)
├── Creative Fly Speed v26.3/       # Modern Lead Anchor (Java 25, Loom 1.11)
├── Archive Jar of all versions/    # Compiled release distribution archives
└── .wiki/                          # GitHub Wiki documentation tree
```

---

## 2. Environment Prerequisites

- **Java Development Kit (JDK)**:
  - JDK 25: For compiling `26.1.2`, `26.2`, `26.3`
  - JDK 21: For compiling `1.21.1`, `1.21.11`
  - JDK 17: For compiling `1.20.1`
- **Git** with PowerShell or Bash.

---

## 3. Building an Anchor

Navigate to the targeted subproject directory and run the Gradle wrapper:

### For Modern Sovereign Anchors (26.x):
```powershell
cd "Creative Fly Speed v26.3"
./gradlew build --no-daemon --console=plain
```

### For Legacy / Transitional Anchors (1.20 - 1.21):
```powershell
cd "Creative Fly Speed v1.20.1"
./gradlew build remapJar --no-daemon --console=plain
```

---

## 4. Running Automated 5-Pillar Headless Tests

Every subproject includes complete 5-Pillar test suites:
- `CreativeFlySpeedCommandTest`: Tests Brigadier command trees, parsing, bounds, and permissions.
- `CreativeFlySpeedConcurrencyLoadTest`: Simulates multi-threaded player tick updates.
- `CreativeFlySpeedGameTest`: Validates world interactions and game mode switches.
- `CreativeFlySpeedSidednessContractTest`: Enforces zero client class references in common code.
- `CreativeFlySpeedStressFuzzTest`: Fuzz tests permille inputs, extreme values ($1..100000$), and negative bounds.
- `FlySpeedLogicTest`: Unit tests mathematical speed calculations and epsilon thresholds.

Execute tests via:
```powershell
./gradlew test --no-daemon --console=plain
```
