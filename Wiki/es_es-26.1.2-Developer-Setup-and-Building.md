# 🛠️ Developer Setup & Building (Minecraft 26.1.2)

> 📌 **Descargo de responsabilidad del código fuente del repositorio**: La documentación de esta Wiki refleja el **estado actual del código fuente en el repositorio**, que puede incluir confirmaciones recientes no publicadas o características en desarrollo antes de las compilaciones públicas en CurseForge y Modrinth.

---

## 1. Official-Style Infobox

| Property | Technical Details |
| :--- | :--- |
| **Subproject Directory** | `Creative Fly Speed v26.1.2` |
| **Minecraft Version** | `26.1.2` |
| **Mod Version** | `1.0.0+26.1.2` |
| **Java Requirement** | Java 25 |
| **Loom Version** | `1.11` |
| **Fabric Loader** | `>=0.19.3` |
| **Primary Build Command** | `./gradlew build --no-daemon` |

---

## 2. Compiling the Artifact

Open your terminal, navigate to this subproject directory, and run the Gradle build:

```powershell
cd "Vanilla Outsider Collections/Creative Fly Speed mod/Creative Fly Speed v26.1.2"
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

[[⬅️ Back to MC 26.1.2 Portal|es_es-26.1.2-Home]]
