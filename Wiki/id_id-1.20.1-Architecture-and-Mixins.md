# 💻 Architecture & Mixins Breakdown (Minecraft 1.20.1)

> 📌 **Pernyataan Sumber Kode Repositori**: Dokumentasi dalam Wiki ini mencerminkan **kondisi kode sumber terkini dalam repositori**, yang mungkin memuat commit pengembangan terbaru yang belum dirilis publik di CurseForge maupun Modrinth.

---

## 1. Official-Style Infobox

| Property | Technical Details |
| :--- | :--- |
| **Target Java Package** | `net.vanillaoutsider.vo_creative_fly_speed` |
| **Bytecode Target Class** | `net.minecraft.server.level.ServerPlayer` |
| **Mixin Class** | `net.vanillaoutsider.vo_creative_fly_speed.mixin.ServerPlayerMixin` |
| **Injection Point** | `public void tick()` at `@At("HEAD")` |
| **Mixin Method Prefix** | `creativeflyspeed$applyFlySpeed` |
| **Stateless Logic Facade** | `FlySpeedLogic.applyFlySpeedToPlayer(ServerPlayer)` |
| **Algorithmic Complexity** | $O(1)$ time complexity, $0\text{ bytes}$ heap allocation |
| **Mixin Configuration** | `creative-fly-speed.mixins.json` |
| **Target Minecraft Version** | `1.20.1` (`1.0.0+1.20.1`) |

---

## 2. Step-by-Step Architectural Pipeline

```
[ Minecraft Server Engine ]
            |
            | (Runs 20 times per second)
            v
[ ServerPlayer.tick() ] <================== INJECTION AT HEAD
            |
            +---> [ ServerPlayerMixin.creativeflyspeed$applyFlySpeed(CallbackInfo) ]
                        |
                        v
                  [ FlySpeedLogic.applyFlySpeedToPlayer(ServerPlayer) ]
                        |
                        +---> 1. Query player.gameMode.getGameModeForPlayer()
                        |
                        +---> 2. Query level().getGameRules().get(Rule)
                        |
                        +---> 3. Compute targetSpeed = 0.05F * (P / 1000.0F)
                        |
                        +---> 4. Compare Math.abs(abilities.getFlyingSpeed() - targetSpeed) > 1e-6F
                        |        |
                        |        +-- False -> Return immediately (0 allocations, 0 packets)
                        |        |
                        |        +-- True  -> Mutate abilities.setFlyingSpeed(targetSpeed)
                        |                     Invoke player.onUpdateAbilities()
                        v
[ Normal ServerPlayer Movement Execution ]
```

---

## 3. Mathematical Complexity & Performance Analysis

### The Mixin Purity Law
`ServerPlayerMixin` contains strictly **zero business logic**. It functions as a pure mechanical trampoline delegating directly to `FlySpeedLogic`.

### Algorithmic Complexity: $O(1)$
- **Arithmetic Evaluation**: The calculation consists of a single floating-point multiplication and division:
  $$\text{targetSpeed} = 0.05\text{F} \times \left(\frac{P}{1000.0\text{F}}\right)$$
- **Memory Footprint**: Executes using JVM registers (primitive floats and ints) with **zero object allocations** per tick.
- **Early Return Optimization**: In steady-state flight (when the GameRule has not changed), `Math.abs(abilities.getFlyingSpeed() - targetSpeed) <= 1e-6F` evaluates to false, resulting in an immediate return with zero side effects.

---

## 4. Visual ASCII Class Dependency Diagram

```
+-------------------------------------------------------------+
|                 CreativeFlySpeedFabric                      |
| (Mod Initializer: Bootstraps GameRules & Command Suite)     |
+-------------------------------------------------------------+
        |                                       |
        v                                       v
+--------------------------------+   +------------------------+
|     CreativeFlySpeedRules      |   | CreativeFlySpeedCommand|
|  - CATEGORY                    |   |  - /cfs                |
|  - CREATIVE_FLY_SPEED          |   |  - /creativeflyspeed   |
|  - SPECTATOR_FLY_SPEED         |   +------------------------+
+--------------------------------+
        ^
        | (Queries GameRule Keys)
+-------------------------------------------------------------+
|                      FlySpeedLogic                          |
|  - calculateSpeed(int permille) -> float                    |
|  - applyFlySpeedToPlayer(ServerPlayer player) -> void       |
+-------------------------------------------------------------+
        ^
        | (Invoked on @At("HEAD"))
+-------------------------------------------------------------+
|                    ServerPlayerMixin                        |
|  - Target: net.minecraft.server.level.ServerPlayer.tick()   |
+-------------------------------------------------------------+
```

---

## 5. Bytecode & Mixin Injection Descriptor Schema

```java
@Mixin(ServerPlayer.class)
public abstract class ServerPlayerMixin {
    @Inject(method = "tick", at = @At("HEAD"))
    private void creativeflyspeed$applyFlySpeed(final CallbackInfo ci) {
        FlySpeedLogic.applyFlySpeedToPlayer((ServerPlayer) (Object) this);
    }
}
```

---

[[⬅️ Back to MC 1.20.1 Portal|id_id-1.20.1-Home]]
