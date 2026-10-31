# Changelog — Creative Fly Speed (MC 1.21.11)

## [1.1.0+1.21.11] — 2026-10-31

### Added
- Initial backport to Minecraft 1.21.11 using Java 21 toolchain and Fabric Loom Remap on Mojang mappings.
- Ergonomic in-game Brigadier command suite: `/cfs` and `/creativeflyspeed` supporting `status`, `get <creative|spectator>`, `set <creative|spectator> <permille>` (Level 2), and `reset` (Level 2).
- Dynamic GameRules under `vo_creative_fly_speed:creative_fly_speed` and `vo_creative_fly_speed:spectator_fly_speed` via DasikLibrary with clean world reload unregistration on server stop.
- Comprehensive 5-Pillar Autonomous Verification Harness: property fuzzing (50k iterations), concurrency load stress (50 threads), Brigadier AST testing, gamemode transition state simulation, and bytecode sidedness contracts.

### Fixed
- Fixed lingering flight speed bug: switching from Creative/Spectator to Survival/Adventure mode cleanly resets flight speed to vanilla default (0.05F).
- Fast-path optimized flight checking to eliminate redundant network synchronization packets for non-flying players.
