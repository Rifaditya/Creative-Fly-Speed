# Release History

## [1.2.0+26.3] — 2026-11-01

Lead anchor feature release implementing optional client configuration GUI via YetAnotherConfigLib (YACL) v3 and ModMenu integration under the Lead Anchor Development Cadence.

### Highlights
- **Optional Client Configuration GUI**: Implemented server-safe client configuration screen powered by `UniversalConfigScreen` from `dasik-library` (v1.12.0) and YACL v3.
- **Side-Safe Common Configuration**: Authored `CreativeFlySpeedConfig` in `net.vanillaoutsider.vo_creative_fly_speed.config` exposing `@ConfigOption` fields with 0 client imports, eliminating Knot ClassLoader server crashes (`ERR-HEADLESS-SIDEDNESS`).
- **Client ModMenu Entrypoint**: Authored `CreativeFlySpeedModMenu` in `net.vanillaoutsider.vo_creative_fly_speed.client` annotated with `@Environment(EnvType.CLIENT)`, registered in `fabric.mod.json` alongside `"suggests"` block.
- **Dual-Context Live Sync**: In singleplayer worlds, slider updates automatically synchronize with `vo_creative_fly_speed:creative_fly_speed` and `vo_creative_fly_speed:spectator_fly_speed` GameRules via `DynamicGameRuleConfigSync`.
- **5-Pillar Verification Harness**: Authored `CreativeFlySpeedModMenuTest` asserting reflection factory generation, fallback null screen safety in headless environments, hermetic JSON persistence, and zero client imports in common code. All 26 tests passed green.
- **Universal 5-Point Distribution**: Release JAR deployed across local archive, release hub archive, external vault (`D:\`), and active Modrinth test profiles.

---

## [1.1.0+26.3] — 2026-10-31

### Added
- Namespaced dynamic GameRules under `vo_creative_fly_speed:creative_fly_speed` and `vo_creative_fly_speed:spectator_fly_speed` with clean world reload unregistration on server stopping lifecycle (`DynamicGameRuleManager.unregisterModRules`).
- Ergonomic in-game Brigadier command suite: `/cfs` and `/creativeflyspeed` (`status`, `get <creative|spectator>`, `set <creative|spectator> <permille>` [permission level 2], `reset` [permission level 2]).
- 5-Pillar Autonomous Verification Harness (`src/test/java/net/vanillaoutsider/vo_creative_fly_speed/`):
  - `CreativeFlySpeedStressFuzzTest`: Chaos property fuzzing (50,000 iterations).
  - `CreativeFlySpeedConcurrencyLoadTest`: Concurrency stress testing (50 virtual worker threads).
  - `CreativeFlySpeedCommandTest`: Headless Brigadier AST syntax and permission node verification.
  - `CreativeFlySpeedGameTest`: Headless in-engine gamemode transition and speed update assertions.
  - `CreativeFlySpeedSidednessContractTest`: Sidedness contract (0 client imports in common) and GPLv3 header verification.

### Fixed
- Fixed lingering flight speed bug: switching from Creative/Spectator to Survival/Adventure cleanly resets flight speed to vanilla default (`0.05F`).
- Fast-path optimized flight checking to eliminate redundant network synchronization packets for non-flying players.

### Technical
- Java 25, Minecraft 26.3, Fabric Loader 0.19.3, Fabric API 0.156.1+26.3, DasikLibrary 1.9.2.
- 100% green test execution across all 5 pillars via JUnit 5 (`./gradlew test --no-daemon`).
- License: GNU GPL v3 (`GPL-3.0-or-later`).

## [1.0.0+build.1] — 2026-03-04

### Added
- `creativeFlySpeed` GameRule (Integer, permille, default 1000): Adjusts Creative flight speed.
- `spectatorFlySpeed` GameRule (Integer, permille, default 1000): Adjusts Spectator flight speed.
- Instant per-tick speed application via `ServerPlayer.tick()` Mixin hook.
- Epsilon-guarded client sync — no redundant `ClientboundPlayerAbilitiesPacket` spamming.
- DasikLibrary integration for GameRule registration (`DynamicGameRuleManager`).

### Technical
- Java 25, Minecraft 26.1 Snapshot 8, Fabric Loader 0.16.10, DasikLibrary 1.6.9+build.5.
- License: GNU GPL v3 (`GPL-3.0-or-later`).
