# 🛠️ Developer Setup & Building (Minecraft 1.21.1)

> 📌 **Avertissement sur le code source du référentiel** : La documentation de ce wiki reflète **l'état actuel du code source dans le référentiel**, qui peut inclure des commits de développement récents non publiés ou des fonctionnalités en cours d'élaboration avant les versions publiques sur CurseForge et Modrinth.

---

## 1. Official-Style Infobox

| Property | Technical Details |
| :--- | :--- |
| **Subproject Directory** | `Creative Fly Speed v1.21.1` |
| **Minecraft Version** | `1.21.1` |
| **Mod Version** | `1.0.0+1.21.1` |
| **Java Requirement** | Java 21 |
| **Loom Version** | `1.10` |
| **Fabric Loader** | `>=0.16.0` |
| **Primary Build Command** | `./gradlew build remapJar --no-daemon` |

---

## 2. Compiling the Artifact

Open your terminal, navigate to this subproject directory, and run the Gradle build:

```powershell
cd "Vanilla Outsider Collections/Creative Fly Speed mod/Creative Fly Speed v1.21.1"
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

[[⬅️ Back to MC 1.21.1 Portal|fr_fr-1.21.1-Home]]
