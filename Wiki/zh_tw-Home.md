# ✈️ Vanilla Outsider: 創造模式飛行速度 (Creative Fly Speed) 官方維基

🌐 **Languages**: [[🇺🇸 English|Home]] | [[🇨🇳 简体中文|zh_cn-Home]] | [[🇭🇰 繁體中文|zh_tw-Home]] | [[🇷🇺 Русский|ru_ru-Home]] | [[🇪🇸 Español|es_es-Home]] | [[🇩🇪 Deutsch|de_de-Home]] | [[🇫🇷 Français|fr_fr-Home]] | [[🇧🇷 Português|pt_br-Home]] | [[🇯🇵 日本語|ja_jp-Home]] | [[🇮🇩 Bahasa Indonesia|id_id-Home]] | [[🇰🇷 한국어|ko_kr-Home]]

> 📌 **程式碼儲存庫原始碼免責聲明**：本維基文件反映了**儲存庫當前的原始碼狀態**，可能包含領先於 CurseForge 與 Modrinth 上公開發布版本的最新開發提交或未發布功能。

---

## 🎯 歡迎來到官方文件

**Creative Fly Speed** 是 **Vanilla Outsider 系列** 中的一款高效能、輕量級飛行速度動力學模組，由 **Dasik (Rifaditya)** 打造。它為建築師、地圖創作者、伺服器管理員與全景攝影師提供了原生、流暢的飛行速度控制方案，直接透過伺服端同步的原生遊戲規則 (GameRules) 調控創造模式與旁觀模式的飛行速度。

本模組遵循**玩家自主權與反保姆原則 (Player Agency & Anti-Nanny Invariant)**，不設任何人工限制：玩家最高可將飛行速度調整至原版的 $100\times$，實現廣闊世界的瞬間穿梭，亦可精細降低至 $0.1\times$ 以進行毫米級微觀方塊搭建。

---

## 🧭 活動版本選擇傳送門

請選擇你的目標 Minecraft 版本以進入對應獨立文件樹：

| 目標 Minecraft 版本 | 模組發行定位 | 執行時期工具鏈 | 狀態 | 文件傳送入口 |
| :--- | :--- | :--- | :---: | :--- |
| **Minecraft 26.3** | `1.0.0+26.3` | Fabric Loader `>=0.19.3` / Java 25 | 🟢 當前主版本 | [[👉 進入 MC 26.3 維基|zh_tw-26.3-Home]] |
| **Minecraft 26.2** | `1.0.0+26.2` | Fabric Loader `>=0.16.10` / Java 25 | 🟡 對齊版本 | [[👉 進入 MC 26.2 維基|zh_tw-26.2-Home]] |

> [!NOTE]
> 遵循模組的 **單版本單 Jar 策略 (1 Jar 1 Version Policy)**，每個版本分支均作為具有獨立依賴項映射的完備製品進行建置。

---

## 🌟 核心子系統概覽

- **[[飛行速度動力學|zh_tw-26.3-Flight-Speed-Kinematics]]**：
  - 基於千分比公式計算速度：$S_{\text{fly}} = 0.05 \times \frac{P}{1000}$ 方塊/刻。
  - 疾跑加速乘算支援：飛行疾跑提供原版 $1.4\times$ 複合加速。
  - 浮點漂移守護門（$10^{-6}\text{ F}$），避免冗餘封包，穩態下 0 發包。
  - 僅對創造與旁觀模式生效，生存與冒險模式零干擾安全回退。
- **[[設定與遊戲規則|zh_tw-26.3-Configuration-and-GameRules]]**：
  - 基於 DasikLibrary 動態註冊的遊戲規則類別 `vo_creative_fly_speed:fly_speed`。
  - `vo_creative_fly_speed`：創造模式飛行速度倍率（預設 `1000` = $1.0\times$）。
  - `vo_spectator_fly_speed`：旁觀模式飛行速度倍率（預設 `1000` = $1.0\times$）。
  - 範圍限制開放至 `[1, 100000]`（最高 $100\times$ 原版速度），原生儲存於 `level.dat`。
- **[[架構與 Mixin 剖析|zh_tw-26.3-Architecture-and-Mixins]]**：
  - 純粹的 Mixin 注入於 `ServerPlayer.tick()` 的 `@At("HEAD")`。
  - 零業務邏輯污染，全邏輯委託給無狀態靜態助手 `FlySpeedLogic`。
  - $O(1)$ 常數時間複雜度與 0 堆積記憶體配置開銷。

---

## 📚 通用開發指南與疑難解答

- [[版本相容性矩陣|zh_tw-Version-Compatibility]]：Loom、Fabric Loader、Parchment 映射以及 Java 25 規範。
- [[疑難排解與常見問題解答 (FAQ)|zh_tw-Troubleshooting-and-FAQ]]：解決漂移、抖動、網路封包同步與多世界保存問題。
- [[開發者環境配置與建置指南|zh_tw-Developer-Setup-and-Building]]：Gradle 9.3+ 獨立編譯步驟與配置。

---

## 📜 製作署名與授權協議

- **作者與維護者**: **Dasik (Rifaditya)**
- **授權協議**: **GNU General Public License v3.0 (GPLv3)**
- **程式碼儲存庫**: [GitHub Repository](https://github.com/Rifaditya/Creative-Fly-Speed)
