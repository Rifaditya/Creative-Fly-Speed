# Changelog — Creative Fly Speed

## [1.2.0+26.1.2] — 2026-11-01

### Added
- Optional client configuration GUI powered by YetAnotherConfigLib (YACL) v3 and ModMenu via `UniversalConfigScreen`.
- Side-safe common configuration model (`CreativeFlySpeedConfig`) with hermetic JSON persistence (`creative_fly_speed.json`).
- Dynamic singleplayer GameRule synchronization: adjusting flight speed sliders in the ModMenu config screen automatically updates in-game GameRules (`vo_creative_fly_speed:creative_fly_speed` and `vo_creative_fly_speed:spectator_fly_speed`).
- Integrated creator support buttons (Ko-fi and Discord) within the ModMenu configuration interface.
- 5-Pillar unit and contract test suite (`CreativeFlySpeedModMenuTest`) verifying annotation metadata, bytecode environment boundaries, hermetic file persistence, and reflection safety.

## [1.1.0+26.1.2] — 2026-10-31

### Added
- Ergonomic in-game Brigadier command suite: `/cfs` and `/creativeflyspeed` supporting `status`, `get <creative|spectator>`, `set <creative|spectator> <permille>` (Level 2), and `reset` (Level 2).
- Namespaced dynamic GameRules under `vo_creative_fly_speed:creative_fly_speed` and `vo_creative_fly_speed:spectator_fly_speed` with clean world reload unregistration on server stop.
- Comprehensive 5-Pillar Autonomous Verification Harness: property fuzzing (50k iterations), concurrency load stress (50 threads), Brigadier AST testing, gamemode transition state simulation, and bytecode sidedness contracts.
- Integrated `SocialLinks` and `CreativeFlySpeedSupport` creator support and community URIs.

### Fixed
- Fixed lingering flight speed bug: switching from Creative/Spectator to Survival/Adventure mode cleanly resets flight speed to vanilla default (0.05F).
- Fast-path optimized flight checking to eliminate redundant network synchronization packets for non-flying players.

## [1.0.0+build.3] — 2026-03-04

### Changed
- Updated DasikLibrary dependency to `1.6.9+build.14` to support dynamic, localized GameRule descriptions in the world settings menu.
- Added detailed `en_us` descriptions explaining the permille (1000 = 1.0x) scaling system for both Creative and Spectator flight speeds.

## [1.0.0+build.2] — 2026-03-04

### Fixed
- Addressed internal build configuration consistency to ensure Loom 1.15 compatibility.

## [1.0.0+build.1] — 2026-03-04

### Added
- **`creativeFlySpeed`** GameRule (Integer, permille, default 1000): Adjusts flight speed for Creative mode players. `/gamerule creativeFlySpeed 2500` = 2.5x speed.
- **`spectatorFlySpeed`** GameRule (Integer, permille, default 1000): Adjusts flight speed for Spectator mode players.
- Permille precision (1/1000th units) for smooth speed scaling without floating-point config values.
- Instant sync: speed applies every tick via `ServerPlayer.tick()` hook — no relog required.
- Persistent per-world: values saved with world's GameRule state (vanilla standard).

### Technical
- Java 25, Minecraft 26.1 Snapshot 8, Fabric Loader 0.16.10, DasikLibrary 1.6.9+build.5
- License: GNU GPL v3 (`GPL-3.0-or-later`)
- Zero allocation in hot path (O(1) tick). Epsilon-guarded client sync to avoid redundant packets.
