# 💻 架構與 Mixin 解析 (Minecraft 26.2)

🌐 **Languages**: [[🇺🇸 English|Home]] | [[🇨🇳 简体中文|zh_cn-Home]] | [[🇭🇰 繁體中文|zh_tw-Home]] | [[🇷🇺 Русский|ru_ru-Home]] | [[🇪🇸 Español|es_es-Home]] | [[🇩🇪 Deutsch|de_de-Home]] | [[🇫🇷 Français|fr_fr-Home]] | [[🇧🇷 Português|pt_br-Home]] | [[🇯🇵 日本語|ja_jp-Home]] | [[🇮🇩 Bahasa Indonesia|id_id-Home]] | [[🇰🇷 한국어|ko_kr-Home]]

> 📌 **存放庫原始碼免責聲明**：本 Wiki 中的文件反映了**存放庫中的當前原始碼狀態**，可能包含領先於 CurseForge 與 Modrinth 上公開版本的近期未發布提交或開發特性。

---

## 📋 Architectural Infobox

| Component | Technical Details |
| :--- | :--- |
| **Package Root** | `net.vanillaoutsider.creativeflyspeed` |
| **Main Mod Initializer** | [`CreativeFlySpeedFabric.java`](file:///Creative%20Fly%20Speed/src/main/java/net/vanillaoutsider/creativeflyspeed/CreativeFlySpeedFabric.java) |
| **GameRule Registry** | [`CreativeFlySpeedRules.java`](file:///Creative%20Fly%20Speed/src/main/java/net/vanillaoutsider/creativeflyspeed/CreativeFlySpeedRules.java) |
| **Mixin Target Class** | `net.minecraft.server.level.ServerPlayer` |
| **Bytecode Injector** | `@Inject(method = "tick", at = @At("HEAD"))` |
| **Library Dependency** | `net.dasik:dasik-library:1.6.9+build.14` |

---

## 🏗️ Architectural Flow & Package Hierarchy

```
net.vanillaoutsider.creativeflyspeed/
├── CreativeFlySpeedFabric.java        # Mod initialization & GameRule registration
├── CreativeFlySpeedFabricClient.java  # Client-side lifecycle stub
├── CreativeFlySpeedRules.java         # Dynamic GameRule constants and registration
└── mixin/
    └── ServerPlayerMixin.java         # Per-tick abilities evaluation & epsilon sync
```

### Flow Diagram
```
[ ServerPlayer.tick() ]
           │
           ▼
[ ServerPlayerMixin.onTick() ]
           │
           ├── Check gameMode (CREATIVE / SPECTATOR)
           ├── Compute targetSpeed = 0.05f * (permille / 1000f)
           │
           ▼
[ Epsilon Guard: |current - target| > 1e-6f ? ]
           ├── NO  ──> (Zero packets sent, return immediately)
           └── YES ──> abilities.setFlyingSpeed(targetSpeed)
                       player.onUpdateAbilities() (Dispatches sync packet)
```

---

## 🔗 Related Documentation
- [[MC 26.2 Flight Speed Kinematics|zh_tw-26.2-Flight-Speed-Kinematics]]
- [[MC 26.2 Configuration & Dynamic GameRules|zh_tw-26.2-Configuration-and-GameRules]]
- [[MC 26.2 Developer Setup Guide|zh_tw-26.2-Developer-Setup-and-Building]]
- [[Return to MC 26.2 Portal|zh_tw-26.2-Home]]
