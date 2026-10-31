# 🛠️ Developer Setup & Building (Minecraft 1.20.1)

> 📌 **代码仓库源码免责声明**：本维基文档反映了**仓库当前的源代码状态**，可能包含领先于 CurseForge 与 Modrinth 上公开发布版本的最新开发提交或未发布功能。

---

## 1. Official-Style Infobox

| Property | Technical Details |
| :--- | :--- |
| **Subproject Directory** | `Creative Fly Speed v1.20.1` |
| **Minecraft Version** | `1.20.1` |
| **Mod Version** | `1.0.0+1.20.1` |
| **Java Requirement** | Java 17 |
| **Loom Version** | `1.10` |
| **Fabric Loader** | `>=0.15.11` |
| **Primary Build Command** | `./gradlew build remapJar --no-daemon` |

---

## 2. Compiling the Artifact

Open your terminal, navigate to this subproject directory, and run the Gradle build:

```powershell
cd "Vanilla Outsider Collections/Creative Fly Speed mod/Creative Fly Speed v1.20.1"
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

[[⬅️ Back to MC 1.20.1 Portal|zh_cn-1.20.1-Home]]
