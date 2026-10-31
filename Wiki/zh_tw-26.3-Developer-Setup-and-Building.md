# 🛠️ Developer Setup & Building (Minecraft 26.3)

> 📌 **程式碼庫源碼免責聲明**：本維基文件反映了**倉庫當前的源代碼狀態**，可能包含領先於 CurseForge 與 Modrinth 上公開發布版本的最新開發提交或未發布功能。

---

## 1. Official-Style Infobox

| Property | Technical Details |
| :--- | :--- |
| **Subproject Directory** | `Creative Fly Speed v26.3` |
| **Minecraft Version** | `26.3` |
| **Mod Version** | `1.0.0+26.3` |
| **Java Requirement** | Java 25 |
| **Loom Version** | `1.11` |
| **Fabric Loader** | `>=0.19.5` |
| **Primary Build Command** | `./gradlew build --no-daemon` |

---

## 2. Compiling the Artifact

Open your terminal, navigate to this subproject directory, and run the Gradle build:

```powershell
cd "Vanilla Outsider Collections/Creative Fly Speed mod/Creative Fly Speed v26.3"
./gradlew build --no-daemon --console=plain
```

Compiled JARs will be generated in `build/libs/`.

---

## 3. Running Headless Tests

Execute the automated 5-Pillar test suite:

```powershell
./gradlew test --no-daemon --console=plain
```

---

[[⬅️ Back to MC 26.3 Portal|zh_tw-26.3-Home]]
