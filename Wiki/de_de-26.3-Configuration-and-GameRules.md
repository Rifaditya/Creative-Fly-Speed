# ⚙️ Konfiguration & Regeln (Minecraft 26.3)

🌐 **Languages**: [[🇺🇸 English|Home]] | [[🇨🇳 简体中文|zh_cn-Home]] | [[🇭🇰 繁體中文|zh_tw-Home]] | [[🇷🇺 Русский|ru_ru-Home]] | [[🇪🇸 Español|es_es-Home]] | [[🇩🇪 Deutsch|de_de-Home]] | [[🇫🇷 Français|fr_fr-Home]] | [[🇧🇷 Português|pt_br-Home]] | [[🇯🇵 日本語|ja_jp-Home]] | [[🇮🇩 Bahasa Indonesia|id_id-Home]] | [[🇰🇷 한국어|ko_kr-Home]]

> 📌 **Haftungsausschluss zum Repository-Quellcode**: Die Dokumentation in diesem Wiki spiegelt den **aktuellen Quellcode-Zustand im Repository** wider, der neuere unveröffentlichte Commits oder Entwicklungsfunktionen vor den öffentlichen Builds auf CurseForge und Modrinth enthalten kann.

---

## 📋 Technical Infobox

| Specification | Technical Details |
| :--- | :--- |
| **System Architecture** | Dynamic Namespaced GameRules (powered by DasikLibrary) |
| **GameRule Category** | `creative_fly_speed:rules` ("Creative Fly Speed") |
| **Primary GameRules** | `vo_creative_fly_speed`, `vo_spectator_fly_speed` |
| **Valid Range** | `1` to `100000` (Permille scale: $0.001\times$ to $100.0\times$) |
| **Default Settings** | `1000` ($1.0\times$ vanilla parity) |
| **Target Minecraft Version** | `26.3` |

---

## 🎮 Server Administration Workflow

Server operators can modify flight speed dynamically in real-time with immediate effect without server restarts:

```mcfunction
# Check current creative flight speed
/gamerule vo_creative_fly_speed

# Set creative flight speed to 3.0x (3000 permille)
/gamerule vo_creative_fly_speed 3000

# Set spectator flight speed to 5.0x (5000 permille)
/gamerule vo_spectator_fly_speed 5000

# Reset creative flight speed to vanilla default (1.0x)
/gamerule vo_creative_fly_speed 1000
```

---

## 🛡️ Player Agency & Anti-Nanny Invariant

In accordance with our core engineering philosophy:
- **Upper Freedom**: Speed limit extends up to `100000` ($100\times$), granting builders and administrators absolute velocity freedom.
- **Lower Bound Safety**: Restricted strictly at $\ge 1$ permille to prevent engine divide-by-zero or frozen flight glitches.

---

## 🔗 Related Documentation
- [[MC 26.3 Flight Speed Kinematics|de_de-26.3-Flight-Speed-Kinematics]]
- [[MC 26.3 Architecture & Mixins Breakdown|de_de-26.3-Architecture-and-Mixins]]
- [[MC 26.3 Developer Setup Guide|de_de-26.3-Developer-Setup-and-Building]]
- [[Return to MC 26.3 Portal|de_de-26.3-Home]]
