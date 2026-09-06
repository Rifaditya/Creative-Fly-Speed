# ✈️ Vanilla Outsider: 创造模式飞行速度 (Creative Fly Speed) 官方维基

🌐 **Languages**: [[🇺🇸 English|Home]] | [[🇨🇳 简体中文|zh_cn-Home]] | [[🇭🇰 繁體中文|zh_tw-Home]] | [[🇷🇺 Русский|ru_ru-Home]] | [[🇪🇸 Español|es_es-Home]] | [[🇩🇪 Deutsch|de_de-Home]] | [[🇫🇷 Français|fr_fr-Home]] | [[🇧🇷 Português|pt_br-Home]] | [[🇯🇵 日本語|ja_jp-Home]] | [[🇮🇩 Bahasa Indonesia|id_id-Home]] | [[🇰🇷 한국어|ko_kr-Home]]

> 📌 **代码仓库源码免责声明**：本维基文档反映了**仓库当前的源代码状态**，可能包含领先于 CurseForge 与 Modrinth 上公开发布版本的最新开发提交或未发布功能。

---

## 🎯 欢迎来到官方文档

**Creative Fly Speed** 是 **Vanilla Outsider 系列** 中的一款高性能、轻量级飞行速度动力学模组，由 **Dasik (Rifaditya)** 打造。它为建筑师、地图创作者、服务器管理员与全景摄影师提供了原生、流畅的飞行速度控制方案，直接通过服务端同步的原生游戏规则 (GameRules) 调控创造模式与旁观模式的飞行速度。

本模组遵循**玩家自主权与反保姆原则 (Player Agency & Anti-Nanny Invariant)**，不设任何人为限制：玩家最高可将飞行速度调整至原版的 $100\times$，实现广袤世界的瞬间穿梭，亦可精细降低至 $0.1\times$ 以进行毫米级微观方块搭建。

---

## 🧭 活动版本选择传送门

请选择你的目标 Minecraft 版本以进入对应独立文档树：

| 目标 Minecraft 版本 | 模组发行定位 | 运行时工具链 | 状态 | 文档传送入口 |
| :--- | :--- | :--- | :---: | :--- |
| **Minecraft 26.3** | `1.0.0+26.3` | Fabric Loader `>=0.19.3` / Java 25 | 🟢 当前主版本 | [[👉 进入 MC 26.3 维基|26.3-Home]] |
| **Minecraft 26.2** | `1.0.0+26.2` | Fabric Loader `>=0.16.10` / Java 25 | 🟡 对齐版本 | [[👉 进入 MC 26.2 维基|26.2-Home]] |

> [!NOTE]
> 遵循模组的 **单版本单 Jar 策略 (1 Jar 1 Version Policy)**，每个版本分支均作为具有独立依赖项映射的完备制品进行构建。

---

## 🌟 核心子系统概览

- **[[飞行速度动力学|26.3-Flight-Speed-Kinematics]]**：
  - 基于千分比公式计算速度：$S_{\text{fly}} = 0.05 \times \frac{P}{1000}$ 方块/刻。
  - 疾跑加速乘算支持：飞行疾跑提供原版 $1.4\times$ 复合加速。
  - 浮点漂移守护门（$10^{-6}\text{ F}$），避免冗余数据包，稳态下 0 发包。
  - 仅对创造与旁观模式生效，生存与冒险模式零干扰安全回退。
- **[[配置与游戏规则|26.3-Configuration-and-GameRules]]**：
  - 基于 DasikLibrary 动态注册的游戏规则类别 `vo_creative_fly_speed:fly_speed`。
  - `vo_creative_fly_speed`：创造模式飞行速度倍率（默认 `1000` = $1.0\times$）。
  - `vo_spectator_fly_speed`：旁观模式飞行速度倍率（默认 `1000` = $1.0\times$）。
  - 范围限制开放至 `[1, 100000]`（最高 $100\times$ 原版速度），原生存储于 `level.dat`。
- **[[架构与 Mixin 剖析|26.3-Architecture-and-Mixins]]**：
  - 纯粹的 Mixin 注入于 `ServerPlayer.tick()` 的 `@At("HEAD")`。
  - 零业务逻辑污染，全逻辑委托给无状态静态助手 `FlySpeedLogic`。
  - $O(1)$ 常数时间复杂度与 0 堆内存分配开销。

---

## 📚 通用开发指南与疑难解答

- [[版本兼容性矩阵|Version-Compatibility]]：Loom、Fabric Loader、Parchment 映射以及 Java 25 规范。
- [[故障排除与常见问题解答 (FAQ)|Troubleshooting-and-FAQ]]：解决漂移、抖动、网络包同步与多世界保存问题。
- [[开发者环境配置与构建指南|Developer-Setup-and-Building]]：Gradle 9.3+ 独立编译步骤与配置。

---

## 📜 制作署名与许可协议

- **作者与维护者**: **Dasik (Rifaditya)**
- **许可协议**: **GNU General Public License v3.0 (GPLv3)**
- **代码仓库**: [GitHub Repository](https://github.com/Rifaditya/Creative-Fly-Speed)
