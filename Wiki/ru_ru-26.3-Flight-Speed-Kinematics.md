# ✈️ Кинематика скорости полета (Minecraft 26.3)

🌐 **Languages**: [[🇺🇸 English|Home]] | [[🇨🇳 简体中文|zh_cn-Home]] | [[🇭🇰 繁體中文|zh_tw-Home]] | [[🇷🇺 Русский|ru_ru-Home]] | [[🇪🇸 Español|es_es-Home]] | [[🇩🇪 Deutsch|de_de-Home]] | [[🇫🇷 Français|fr_fr-Home]] | [[🇧🇷 Português|pt_br-Home]] | [[🇯🇵 日本語|ja_jp-Home]] | [[🇮🇩 Bahasa Indonesia|id_id-Home]] | [[🇰🇷 한국어|ko_kr-Home]]

> 📌 **Отказ от ответственности за исходный код репозитория**: Документация в этой Wiki отражает **текущее состояние исходного кода в репозитории**, которое может включать недавние невыпущенные коммиты или разрабатываемые функции, опережающие общедоступные сборки на CurseForge и Modrinth.

---

## 📋 Technical Infobox

| Specification | Technical Details |
| :--- | :--- |
| **System Architecture** | Server-Authoritative Abilities Pipeline + Permille Multiplier |
| **Vanilla Baseline Speed** | $0.05\text{ blocks/tick}$ ($1.0\text{ blocks/second}$ base flying speed) |
| **Controlling GameRules** | `vo_creative_fly_speed`, `vo_spectator_fly_speed` |
| **Unit Scale** | Permille ($1000 = 1.0\times$ vanilla, $2500 = 2.5\times$, $10000 = 10.0\times$) |
| **Epsilon Drift Guard** | $\Delta \le 10^{-6}\text{ F}$ (Prevents packet spam on steady ticks) |
| **Target Minecraft Version** | `26.3` |

---

## 📐 Mathematical Formulation

### 1. Flying Speed Multiplier Equation
The target flight speed $V_{\text{fly}}$ is derived from the configured permille value $P$:

$$V_{\text{fly}} = 0.05 \times \frac{P}{1000.0}$$

Where:
- $P = 1000 \implies V_{\text{fly}} = 0.05$ (Vanilla baseline: $1.0\times$)
- $P = 2000 \implies V_{\text{fly}} = 0.10$ ($2.0\times$ speed)
- $P = 5000 \implies V_{\text{fly}} = 0.25$ ($5.0\times$ speed)
- $P = 20000 \implies V_{\text{fly}} = 1.00$ ($20.0\times$ speed)

### 2. Zero-Packet Network Epsilon Guard
To eliminate network packet spam and bandwidth waste during flight:
$$\Delta = |V_{\text{current}} - V_{\text{fly}}|$$
Network synchronization packet `ClientboundPlayerAbilitiesPacket` is dispatched if and only if:
$$\Delta > 10^{-6}\text{ F}$$

```java
if (Math.abs(abilities.getFlyingSpeed() - targetSpeed) > 1e-6F) {
    abilities.setFlyingSpeed(targetSpeed);
    player.onUpdateAbilities();
}
```

---

## 🎮 Gamemode State Separation

| Gamemode | Controlling GameRule | Default Value | Notes |
| :--- | :--- | :---: | :--- |
| **Creative Mode** | `vo_creative_fly_speed` | `1000` | Applied strictly when `gameMode.isCreative()` is true. |
| **Spectator Mode** | `vo_spectator_fly_speed` | `1000` | Applied strictly when `gameMode.isSpectator()` is true. |
| **Survival / Adventure** | *None* | N/A | Untouched; retains vanilla gravity and movement constraints. |

---

## 🔗 Related Documentation
- [[MC 26.3 Configuration & Dynamic GameRules|ru_ru-26.3-Configuration-and-GameRules]]
- [[MC 26.3 Architecture & Mixins Breakdown|ru_ru-26.3-Architecture-and-Mixins]]
- [[MC 26.3 Developer Setup Guide|ru_ru-26.3-Developer-Setup-and-Building]]
- [[Return to MC 26.3 Portal|ru_ru-26.3-Home]]
