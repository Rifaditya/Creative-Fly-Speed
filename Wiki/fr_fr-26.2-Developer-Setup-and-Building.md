# 🛠️ Developer Setup & Building (Minecraft 26.2)

> 📌 **Avertissement sur le code source du référentiel** : La documentation de ce wiki reflète **l'état actuel du code source dans le référentiel**, qui peut inclure des commits de développement récents non publiés ou des fonctionnalités en cours d'élaboration avant les versions publiques sur CurseForge et Modrinth.

---

## 1. Official-Style Infobox

| Property | Technical Details |
| :--- | :--- |
| **Subproject Directory** | `Creative Fly Speed v26.2` |
| **Minecraft Version** | `26.2` |
| **Mod Version** | `1.0.0+26.2` |
| **Java Requirement** | Java 25 |
| **Loom Version** | `1.11` |
| **Fabric Loader** | `>=0.19.4` |
| **Primary Build Command** | `./gradlew build --no-daemon` |

---

## 2. Compiling the Artifact

Open your terminal, navigate to this subproject directory, and run the Gradle build:

```powershell
cd "Vanilla Outsider Collections/Creative Fly Speed mod/Creative Fly Speed v26.2"
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

[[⬅️ Back to MC 26.2 Portal|fr_fr-26.2-Home]]
