# 🛠️ Developer Setup & Building (Minecraft 1.20.1)

> 📌 **Isenção de responsabilidade do código-fonte do repositório**: A documentação nesta Wiki reflete o **estado atual do código-fonte no repositório**, que pode incluir commits recentes não lançados ou recursos de desenvolvimento anteriores às versões públicas no CurseForge e Modrinth.

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

[[⬅️ Back to MC 1.20.1 Portal|pt_br-1.20.1-Home]]
