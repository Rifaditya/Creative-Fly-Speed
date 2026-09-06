# ✈️ Vanilla Outsider: Creative Fly Speed 公式Wiki

🌐 **Languages**: [[🇺🇸 English|Home]] | [[🇨🇳 简体中文|zh_cn-Home]] | [[🇭🇰 繁體中文|zh_tw-Home]] | [[🇷🇺 Русский|ru_ru-Home]] | [[🇪🇸 Español|es_es-Home]] | [[🇩🇪 Deutsch|de_de-Home]] | [[🇫🇷 Français|fr_fr-Home]] | [[🇧🇷 Português|pt_br-Home]] | [[🇯🇵 日本語|ja_jp-Home]] | [[🇮🇩 Bahasa Indonesia|id_id-Home]] | [[🇰🇷 한국어|ko_kr-Home]]

> 📌 **リポジトリソースコードに関する免責事項**: このWikiのドキュメントは**リポジトリ内の現在のソースコード状態**を反映しており、CurseForgeおよびModrinthでの公開リリースビルドに先立つ最新の開発コミットや未リリース機能が含まれている場合があります。

---

## 🎯 公式ドキュメントへようこそ

**Creative Fly Speed** は、**Vanilla Outsider Collection** に属する、**Dasik (Rifaditya)** によって開発された高性能かつ軽量な飛行速度調整MODです。サーバー同期されたMinecraft標準のゲームルール (GameRules) を介して、クリエイティブモードおよびスペクテイターモードでの飛行速度をシームレスかつネイティブに制御できます。

**プレイヤーの主権と自由（Player Agency & Anti-Nanny Invariant）** の原則に基づき、人為的な速度上限は一切設けられていません。広大なワールドの高速移動のために通常速度の最大 $100\times$ まで加速することも、ミリ単位の緻密な建築のために $0.1\times$ まで減速することも可能です。

---

## 🧭 バージョン選択ポータル

対象のMinecraftバージョンを選択して、専用ドキュメントツリーにアクセスしてください：

| 対象バージョン | リリース識別子 | ツールチェーン | ステータス | 直接リンク |
| :--- | :--- | :--- | :---: | :--- |
| **Minecraft 26.3** | `1.0.0+26.3` | Fabric Loader `>=0.19.3` / Java 25 | 🟢 現在のメイン | [[👉 MC 26.3 Wiki ポータルへ|26.3-Home]] |
| **Minecraft 26.2** | `1.0.0+26.2` | Fabric Loader `>=0.16.10` / Java 25 | 🟡 パリティ版 | [[👉 MC 26.2 Wiki ポータルへ|26.2-Home]] |

> [!NOTE]
> 本MODの **1 Jar 1 Version Policy** に基づき、各バージョンブランチは独立した依存関係マッピングを持つ完全なアーティファクトとして個別にビルドされます。

---

## 🌟 コアサブシステム概要

- **[[飛行速度キネマティクス|26.3-Flight-Speed-Kinematics]]**:
  - パーミル（千分率）計算式：$S_{\text{fly}} = 0.05 \times \frac{P}{1000}$ ブロック/Tick。
  - ダッシュ飛行による $1.4\times$ 加速を完全サポート。
  - 浮動小数点ドリフト防止（$10^{-6}\text{ F}$）により、無駄なパケット送信をゼロ化。
  - サバイバルおよびアドベンチャーモードには一切干渉しない安全設計。
- **[[設定とゲームルール|26.3-Configuration-and-GameRules]]**:
  - DasikLibrary による動的カテゴリ登録 `vo_creative_fly_speed:fly_speed`。
  - `vo_creative_fly_speed`: クリエイティブモード飛行倍率（デフォルト: `1000` = $1.0\times$）。
  - `vo_spectator_fly_speed`: スペクテイターモード飛行倍率（デフォルト: `1000` = $1.0\times$）。
  - 設定範囲 `1` 〜 `100000`、ワールドデータ `level.dat` に自動保存。
- **[[アーキテクチャとMixin|26.3-Architecture-and-Mixins]]**:
  - `ServerPlayer.tick()` の `@At("HEAD")` への最小限のバイトコード注入。
  - Mixin内にビジネスロジックを保持せず、静的ヘルパー `FlySpeedLogic` に全委譲。
  - 計算量 $O(1)$、ヒープメモリ割り当てゼロの極限最適化。

---

## 📚 開発者向けガイド＆FAQ

- [[バージョン互換性マトリクス|Version-Compatibility]]: Loom、Fabric Loader、Java 25 の要件。
- [[トラブルシューティングとFAQ|Troubleshooting-and-FAQ]]: パケット同期、ドリフト、ワールド保存の解説。
- [[開発環境セットアップ＆ビルドガイド|Developer-Setup-and-Building]]: Gradle 9.3+ によるビルド手順。

---

## 📜 クレジットとライセンス

- **制作者・開発者**: **Dasik (Rifaditya)**
- **ライセンス**: **GNU General Public License v3.0 (GPLv3)**
- **ソースコード**: [GitHub Repository](https://github.com/Rifaditya/Creative-Fly-Speed)
