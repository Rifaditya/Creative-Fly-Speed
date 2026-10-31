# 🛠️ Developer Setup & Building (Minecraft 1.21.11)

> 📌 **저장소 소스 코드 면책 조항**: 이 위키의 문서는 CurseForge 및 Modrinth의 공개 릴리스 빌드보다 앞선 최신 미출시 커밋 또는 개발 기능을 포함할 수 있는 **저장소의 현재 소스 코드 상태**를 반영합니다.

---

## 1. Official-Style Infobox

| Property | Technical Details |
| :--- | :--- |
| **Subproject Directory** | `Creative Fly Speed v1.21.11` |
| **Minecraft Version** | `1.21.11` |
| **Mod Version** | `1.0.0+1.21.11` |
| **Java Requirement** | Java 21 |
| **Loom Version** | `1.10` |
| **Fabric Loader** | `>=0.16.5` |
| **Primary Build Command** | `./gradlew build remapJar --no-daemon` |

---

## 2. Compiling the Artifact

Open your terminal, navigate to this subproject directory, and run the Gradle build:

```powershell
cd "Vanilla Outsider Collections/Creative Fly Speed mod/Creative Fly Speed v1.21.11"
./gradlew build remapJar --no-daemon --console=plain
```

Compiled JARs will be generated in `build/libs/`.

---

## 3. Running Headless Tests

Execute the automated 5-Pillar test suite:

```powershell
./gradlew test --no-daemon --console=plain
```

---

[[⬅️ Back to MC 1.21.11 Portal|ko_kr-1.21.11-Home]]
