# ❓ Troubleshooting & Technical FAQ

> 📌 **Отказ от ответственности за исходный код репозитория**: Документация в этой Вики отражает **текущее состояние исходного кода в репозитории**, которое может включать недавние невыпущенные коммиты или разрабатываемые функции, опережающие общедоступные сборки на CurseForge и Modrinth.

---

## 1. Flight Speed & Jitter Diagnostics

### Q: Why do I experience flight stutter or rubberbanding on a server?
**A**: Ensure your server tick rate is stable ($20.0\text{ TPS}$). If flight speed is set to extremely high values (e.g. $>20000‰$ / $20.0\times$), players will traverse chunks faster than the server can generate or stream them. Consider pre-generating world chunks or keeping speeds around $2000‰$–$5000‰$ ($2.0\times$–$5.0\times$) for general creative building.

### Q: Does this mod send network packets on every server tick?
**A**: **No.** Creative Fly Speed implements a strict IEEE 754 Floating-Point Epsilon Guard ($|\Delta| > 10^{-6}\text{ F}$). In steady-state flight, `applyFlySpeedToPlayer()` evaluates in $O(1)$ time with **0 heap allocations** and **0 network packets**. Packets (`ClientboundPlayerAbilitiesPacket`) are dispatched exclusively when the GameRule permille value changes or when a player switches game modes.

---

## 2. Configuration & GameRules Questions

### Q: How do I change the speed in-game?
**A**: You can use either the dedicated command suite or standard GameRules:
- Using Brigadier: `/cfs set creative 2500` (sets Creative speed to $2.5\times$)
- Using GameRule: `/gamerule vo_creative_fly_speed:creative_fly_speed 2500`

### Q: Why do I get a permission error when running `/cfs set`?
**A**: Modifying flight speed rules requires **Permission Level 2** (Server Operator or Cheats Enabled in Singleplayer). Regular players can view current speeds via `/cfs status` or `/cfs get <mode>` without operator rights.

### Q: Where is my speed configuration saved?
**A**: All speed settings are stored directly in your world save's `level.dat` file under `Data.GameRules`. No external JSON or config files are created. When copying world saves between servers or singleplayer, your fly speed settings travel with the world seamlessly.

---

## 3. Survival & Game Mode Transitions

### Q: Will this mod break survival flight (Elytra)?
**A**: **No.** Creative Fly Speed explicitly inspects `player.gameMode.getGameModeForPlayer()`. If the game mode is `SURVIVAL` or `ADVENTURE`, the mod immediately resets the player's flying speed to vanilla standard ($0.05\text{F}$) and returns early. Elytra flight mechanics, rockets, and falling physics are 100% untouched.

### Q: What happens if I uninstall the mod?
**A**: Thanks to `DynamicGameRuleManager`, dynamic mod GameRules are cleanly unmounted from memory on server stop. When loading the world without the mod, Minecraft ignores unmapped GameRules in `level.dat` without world corruption or crash. Player abilities revert to default vanilla $0.05\text{F}$ on next login.
