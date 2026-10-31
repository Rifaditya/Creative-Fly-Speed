# Release History

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
