# 💻 アーキテクチャと Mixin 解析 (Minecraft 26.3)

🌐 **Languages**: [[🇺🇸 English|Home]] | [[🇨🇳 简体中文|zh_cn-Home]] | [[🇭🇰 繁體中文|zh_tw-Home]] | [[🇷🇺 Русский|ru_ru-Home]] | [[🇪🇸 Español|es_es-Home]] | [[🇩🇪 Deutsch|de_de-Home]] | [[🇫🇷 Français|fr_fr-Home]] | [[🇧🇷 Português|pt_br-Home]] | [[🇯🇵 日本語|ja_jp-Home]] | [[🇮🇩 Bahasa Indonesia|id_id-Home]] | [[🇰🇷 한국어|ko_kr-Home]]

> 📌 **リポジトリソースコードに関する免責事項**: この Wiki のドキュメントは**リポジトリ内の現在のソースコードの状態**を反映しており、CurseForge および Modrinth での公開リリースビルドに先駆けた最新の未リリースコミットや開発中の機能が含まれている場合があります。

---

## 📋 Architectural Infobox

| Component | Technical Details |
| :--- | :--- |
| **Package Root** | `net.vanillaoutsider.creativeflyspeed` |
| **Main Mod Initializer** | [`CreativeFlySpeedFabric.java`](file:///Creative%20Fly%20Speed%20v26.3/Creative%20Fly%20Speed%2026.3/src/main/java/net/vanillaoutsider/creativeflyspeed/CreativeFlySpeedFabric.java) |
| **GameRule Registry** | [`CreativeFlySpeedRules.java`](file:///Creative%20Fly%20Speed%20v26.3/Creative%20Fly%20Speed%2026.3/src/main/java/net/vanillaoutsider/creativeflyspeed/CreativeFlySpeedRules.java) |
| **Mixin Target Class** | `net.minecraft.server.level.ServerPlayer` |
| **Bytecode Injector** | `@Inject(method = "tick", at = @At("HEAD"))` |
| **Library Dependency** | `net.dasik:dasik-library:1.8.36` |

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
- [[MC 26.3 Flight Speed Kinematics|ja_jp-26.3-Flight-Speed-Kinematics]]
- [[MC 26.3 Configuration & Dynamic GameRules|ja_jp-26.3-Configuration-and-GameRules]]
- [[MC 26.3 Developer Setup Guide|ja_jp-26.3-Developer-Setup-and-Building]]
- [[Return to MC 26.3 Portal|ja_jp-26.3-Home]]
