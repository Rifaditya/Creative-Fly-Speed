# ⚙️ Configuration & Dynamic GameRules (Minecraft 26.3)

> 📌 **Descargo de responsabilidad del código fuente del repositorio**: La documentación de esta Wiki refleja el **estado actual del código fuente en el repositorio**, que puede incluir confirmaciones recientes no publicadas o características en desarrollo antes de las compilaciones públicas en CurseForge y Modrinth.

---

## 1. Official-Style Infobox

| Property | Technical Details |
| :--- | :--- |
| **Target Minecraft Version** | `26.3` (`1.0.0+26.3`) |
| **Category Identifier** | `vo_creative_fly_speed:fly_speed` |
| **Registration Engine** | `DynamicGameRuleManager` (via DasikLibrary) |
| **Storage Architecture** | NBT persistence inside `level.dat` (`Data.GameRules`) |
| **Permission Level Required** | Level 2 (Server Operator / Dedicated Host) |
| **Permille Value Bounds** | Min: `1` ($0.001\times$) &#124; Max: `100000` ($100.0\times$) |
| **Hot-Reload Support** | Instantaneous; updates take effect on the next server tick |
| **Translation Keys** | `gamerule.category.vo_creative_fly_speed.fly_speed`<br>`gamerule.vo_creative_fly_speed.creative_fly_speed`<br>`gamerule.vo_creative_fly_speed.spectator_fly_speed` |

---

## 2. Step-by-Step Operator Workflow

### Changing Creative Flying Speed
1. Ensure operator privileges (Permission Level 2 or singleplayer cheats enabled).
2. Open chat (`T` or `/`).
3. Execute the command:
   ```mcfunction
   /gamerule vo_creative_fly_speed:creative_fly_speed 2500
   ```
   *(Or use the Brigadier shorthand: `/cfs set creative 2500`)*
4. All players currently in Creative mode immediately fly at $2.5\times$ speed.

### Changing Spectator Flying Speed
1. For slow, cinematic camera panning, execute:
   ```mcfunction
   /gamerule vo_creative_fly_speed:spectator_fly_speed 250
   ```
   *(Or use the Brigadier shorthand: `/cfs set spectator 250`)*
2. Spectators now navigate at $0.25\times$ speed ($0.0125\text{ blocks/tick}$), completely eliminating camera jerking.

### Restoring Defaults
```mcfunction
/gamerule vo_creative_fly_speed:creative_fly_speed 1000
/gamerule vo_creative_fly_speed:spectator_fly_speed 1000
```
*(Or simply: `/cfs reset`)*

---

## 3. Mathematical Range Constraints & Freedom Over Anti-Crash

In accordance with the **Freedom Over Anti-Crash Policy** and Studio Constitution, Creative Fly Speed never imposes arbitrary low velocity caps. The permissible bounds are:

$$P \in [1, 100000] \subset \mathbb{Z}^+$$

- **Lower Bound (`1`)**: Protects against IEEE 754 division-by-zero or negative vector inversions.
- **Upper Bound (`100000`)**: Delivers up to $100\times$ velocity ($5.0\text{ blocks/tick} = 360\text{ km/h}$) for massive world navigation.

---

## 4. Storage Schema: World Save `level.dat` NBT

Because the rules are registered directly with the Minecraft GameRules registry via `DynamicGameRuleManager`, they serialize naturally into standard vanilla world data:

```snbt
{
    "Data": {
        "GameRules": {
            "vo_creative_fly_speed:creative_fly_speed": "2500",
            "vo_creative_fly_speed:spectator_fly_speed": "1000",
            "doDaylightCycle": "true",
            "keepInventory": "false"
        },
        "LevelName": "Creative Sandbox",
        "version": 19133
    }
}
```

---

## 5. Exhaustive GameRules Reference Table

| Rule Identifier | Category | Type | Default | Bounds | Description |
| :--- | :--- | :---: | :---: | :---: | :--- |
| `vo_creative_fly_speed:creative_fly_speed` | `vo_creative_fly_speed:fly_speed` | `Integer` | `1000` | `1`..`100000` | Flight speed multiplier for Creative mode in permille ($1000 = 1.0\times$). |
| `vo_creative_fly_speed:spectator_fly_speed` | `vo_creative_fly_speed:fly_speed` | `Integer` | `1000` | `1`..`100000` | Flight speed multiplier for Spectator mode in permille ($1000 = 1.0\times$). |

---

## 6. Uninstallation & World Save Lifecycle

- **Server Shutdown Lifecycle**: When the server stops, `CreativeFlySpeedFabric` calls `DynamicGameRuleManager.unregisterModRules("vo_creative_fly_speed")`, safely unbinding rules from memory.
- **Safe Mod Removal**: If Creative Fly Speed is removed from the `mods/` directory, vanilla Minecraft safely ignores unmapped GameRules present in `level.dat`. No world corruption, entity loss, or crash will ever occur.
- **Abilities Recovery**: On subsequent logins without the mod, the player's abilities revert to standard vanilla $0.05\text{F}$ flying speed automatically.

---

[[⬅️ Back to MC 26.3 Portal|es_es-26.3-Home]]
