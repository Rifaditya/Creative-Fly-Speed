# Getting Started

## Requirements

- **JDK**: Java 25
- **Minecraft**: 26.1 Snapshot 8
- **Fabric Loader**: 0.16.10+
- **DasikLibrary**: 1.6.9+build.5+

## Build Setup

### 1. Clone & Setup

```bash
git clone https://github.com/Rifaditya/Vanilla-Outsider-Creative-Fly-Speed
cd Creative\ Fly\ Speed
```

### 2. Build

```bash
./gradlew build
```

The output JAR will be in `build/libs/`.

### 3. Run Client

```bash
./gradlew runClient
```

## Project Structure

```
src/main/java/net/vanillaoutsider/vo_creative_fly_speed/
├── CreativeFlySpeedFabric.java        ← Main entrypoint
├── CreativeFlySpeedFabricClient.java  ← Client entrypoint (stub)
├── CreativeFlySpeedRules.java         ← GameRule registration
├── FlySpeedLogic.java                 ← Stateless logic helper
└── mixin/
    └── ServerPlayerMixin.java         ← Tick hook

src/main/resources/
├── fabric.mod.json                    ← Mod metadata
└── creative-fly-speed.mixins.json     ← Mixin config
```

## Dependencies

The mod uses **DasikLibrary** for GameRule registration (`DynamicGameRuleManager`). This is required because `GameRules.registerInteger()` is `private static` in MC 26.1.

DasikLibrary is resolved from `mavenLocal()` — ensure it is installed locally via `gradlew publishToMavenLocal` in the DasikLibrary project.
