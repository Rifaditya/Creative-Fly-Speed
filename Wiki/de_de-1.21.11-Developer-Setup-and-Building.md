# 🛠️ Developer Setup & Building (Minecraft 1.21.11)

> 📌 **Haftungsausschluss für Repository-Quellcode**: Die Dokumentation in diesem Wiki spiegelt den **aktuellen Quellcode-Zustand im Repository** wider, der aktuelle, unveröffentlichte Commits oder Entwicklungsfunktionen vor öffentlichen Builds auf CurseForge und Modrinth enthalten kann.

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

[[⬅️ Back to MC 1.21.11 Portal|de_de-1.21.11-Home]]
