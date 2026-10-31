# 🛠️ Developer Setup & Building (Minecraft 1.20.1)

> 📌 **Pernyataan Sumber Kode Repositori**: Dokumentasi dalam Wiki ini mencerminkan **kondisi kode sumber terkini dalam repositori**, yang mungkin memuat commit pengembangan terbaru yang belum dirilis publik di CurseForge maupun Modrinth.

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

[[⬅️ Back to MC 1.20.1 Portal|id_id-1.20.1-Home]]
