# ❓ 문제 해결 및 자주 묻는 질문 (FAQ)

🌐 **Languages**: [[🇺🇸 English|Home]] | [[🇨🇳 简体中文|zh_cn-Home]] | [[🇭🇰 繁體中文|zh_tw-Home]] | [[🇷🇺 Русский|ru_ru-Home]] | [[🇪🇸 Español|es_es-Home]] | [[🇩🇪 Deutsch|de_de-Home]] | [[🇫🇷 Français|fr_fr-Home]] | [[🇧🇷 Português|pt_br-Home]] | [[🇯🇵 日本語|ja_jp-Home]] | [[🇮🇩 Bahasa Indonesia|id_id-Home]] | [[🇰🇷 한국어|ko_kr-Home]]

> 📌 **저장소 소스 코드 면책 조항**: 이 위키의 문서는 CurseForge 및 Modrinth의 공개 릴리스 빌드보다 앞선 최근 미출시 커밋 또는 개발 기능을 포함할 수 있는 **저장소의 현재 소스 코드 상태**를 반영합니다.

---

## 🔍 Frequently Asked Questions

### Q1: Why does my flight speed feel vanilla even after installing the mod?
**A**: By default, Creative Fly Speed initializes both GameRules to `1000` (permille), which equals exactly $1.0\times$ (vanilla flight speed: $0.05\text{ blocks/tick}$). To adjust speed:
```mcfunction
/gamerule vo_creative_fly_speed 2500
```
This instantly increases Creative flight speed to $2.5\times$ ($0.125\text{ blocks/tick}$).

---

### Q2: Does changing the GameRule affect players in Survival or Adventure mode?
**A**: No. The engine contains an explicit early-return guard:
```java
final float targetSpeed = switch (gameType) {
    case CREATIVE -> calculateSpeed(rules.get(CreativeFlySpeedRules.CREATIVE_FLY_SPEED));
    case SPECTATOR -> calculateSpeed(rules.get(CreativeFlySpeedRules.SPECTATOR_FLY_SPEED));
    default -> -1.0F; // Survival / Adventure bypassed
};
if (targetSpeed < 0) return;
```
Players in Survival or Adventure modes are never modified and retain their vanilla movement physics.

---

### Q3: How does the mod prevent network lag and packet spam?
**A**: Vanilla Minecraft transmits `ClientboundPlayerAbilitiesPacket` every time `player.onUpdateAbilities()` is executed. If a mod unconditionally sends this packet every server tick (20 times per second per player), bandwidth saturates and clients experience movement stutter.

Creative Fly Speed implements a strict **Floating-Point Epsilon Drift Guard**:
$$\Delta = |\text{abilities.getFlyingSpeed}() - \text{targetSpeed}|$$
Only when $\Delta > 10^{-6}\text{ F}$ does the server mutate the player's abilities and issue a network sync packet:
```java
if (Math.abs(abilities.getFlyingSpeed() - targetSpeed) > 1e-6F) {
    abilities.setFlyingSpeed(targetSpeed);
    player.onUpdateAbilities();
}
```
Under normal flight, once the speed is set, the delta is $0$, resulting in **0 network packets dispatched** during steady-state ticks.

---

### Q4: Are GameRule settings saved across server restarts and world reloads?
**A**: Yes. Because the mod registers standard Minecraft `GameRule<Integer>` instances via DasikLibrary's `DynamicGameRuleManager`, all values are serialized directly into the world's `level.dat` NBT structure under `GameRules`. No third-party configuration files can desynchronize from the save data.

---

### Q5: What happens if I set the GameRule to extreme values like 50,000 or 100,000?
**A**: In accordance with the **Player Agency & Anti-Nanny Invariant**, Creative Fly Speed sets the upper rule bound to `100000` ($100\times$ speed, or $5.0\text{ blocks/tick} = 100\text{ blocks/second}$).
- At extreme speeds ($>20,000$), chunks may fail to load fast enough on slower storage or servers with low tick rates.
- Server movement checks in `server.properties` may flag players if anti-cheat is active. Ensure `server.properties` allows high movement speeds or configure anti-cheat plugins accordingly.

---

## 🛠️ Diagnostic & Troubleshooting Matrix

| Symptom | Probable Cause | Diagnostic Command / Check | Resolution |
| :--- | :--- | :--- | :--- |
| **Speed resets when switching gamemodes** | Intended design | Check current gamemode with `/gamemode` | Switching from Creative to Spectator automatically transitions from `vo_creative_fly_speed` to `vo_spectator_fly_speed`. |
| **Commands do not show autocomplete** | Permission level insufficient | Verify operator level (`>=2`) | Run `/op <player>` or verify server permission levels. Dynamic GameRules require level 2 permission. |
| **Speed changes on server but client feels jittery** | Packet drop or high client latency | Press `F3` to observe client TPS and ping | Verify that `player.onUpdateAbilities()` packet is received; check for conflicting client movement mods. |
| **GameRule value rejected when typing negative number** | Minimum bound validation | Check rule bounds `[1, 100000]` | Permille values must be $\ge 1$. Negative speeds or $0$ are rejected by the registration range guard to prevent engine divide-by-zero or backward flight reversal glitches. |

---

## 🔗 Related Documentation
- [[Flight Speed Kinematics|ko_kr-26.3-Flight-Speed-Kinematics]]
- [[Configuration & Dynamic GameRules|ko_kr-26.3-Configuration-and-GameRules]]
- [[Architecture & Mixins Breakdown|ko_kr-26.3-Architecture-and-Mixins]]
- [[Return to Home Portal|ko_kr-Home]]
