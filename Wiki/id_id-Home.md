# ✈️ Vanilla Outsider: Creative Fly Speed Wiki Resmi

🌐 **Languages**: [[🇺🇸 English|Home]] | [[🇨🇳 简体中文|zh_cn-Home]] | [[🇭🇰 繁體中文|zh_tw-Home]] | [[🇷🇺 Русский|ru_ru-Home]] | [[🇪🇸 Español|es_es-Home]] | [[🇩🇪 Deutsch|de_de-Home]] | [[🇫🇷 Français|fr_fr-Home]] | [[🇧🇷 Português|pt_br-Home]] | [[🇯🇵 日本語|ja_jp-Home]] | [[🇮🇩 Bahasa Indonesia|id_id-Home]] | [[🇰🇷 한국어|ko_kr-Home]]

> 📌 **Pernyataan Sumber Kode Repositori**: Dokumentasi dalam Wiki ini mencerminkan **kondisi kode sumber terkini dalam repositori**, yang mungkin memuat commit pengembangan terbaru yang belum dirilis publik di CurseForge maupun Modrinth.

---

## 🎯 Selamat Datang di Dokumentasi Resmi

**Creative Fly Speed** adalah mod kinematika terbang berperforma tinggi dan ultra-ringan dari **Vanilla Outsider Collection**, yang dikembangkan oleh **Dasik (Rifaditya)**. Mod ini memberikan kendali penuh, mulus, dan murni alami atas kecepatan terbang pemain dalam mode Creative dan Spectator melalui GameRules bawaan Minecraft yang disinkronkan langsung oleh server.

Dirancang berdasarkan prinsip **Kedaulatan & Kebebasan Pemain (Player Agency & Anti-Nanny Invariant)**, mod ini tidak membatasi batas atas kecepatan: pemain bebas menaikkan kecepatan hingga $100\times$ kecepatan standar untuk menjelajahi dunia dalam sekejap, atau menurunkannya ke $0.1\times$ untuk penataan blok mikroskopis yang presisi.

---

## 🧭 Portal Pemilih Versi

Pilih versi target Minecraft Anda untuk mengakses dokumentasi terisolasi:

| Target Versi Minecraft | Versi Mod Rilis | Rantai Perkakas | Status | Pintu Masuk Langsung |
| :--- | :--- | :--- | :---: | :--- |
| **Minecraft 26.3** | `1.0.0+26.3` | Fabric Loader `>=0.19.3` / Java 25 | 🟢 Versi Utama Aktif | [[👉 Masuk ke Wiki MC 26.3|26.3-Home]] |
| **Minecraft 26.2** | `1.0.0+26.2` | Fabric Loader `>=0.16.10` / Java 25 | 🟡 Versi Paritas | [[👉 Masuk ke Wiki MC 26.2|26.2-Home]] |

> [!NOTE]
> Di bawah kebijakan **1 Jar 1 Version Policy**, setiap cabang versi dibangun sebagai artefak berdaulat independen dengan pemetaan dependensi masing-masing.

---

## 🌟 Ringkasan Subsistem Utama

- **[[Kinematika Kecepatan Terbang|26.3-Flight-Speed-Kinematics]]**:
  - Rumus kecepatan permille: $S_{\text{fly}} = 0.05 \times \frac{P}{1000}$ blok/tick.
  - Dukungan sprint terbang bertingkat ($1.4\times$ akselerasi).
  - Penjaga simpangan floating-point ($10^{-6}\text{ F}$) untuk mencegah luapan paket jaringan (0 paket pada kondisi stabil).
  - Keamanan total: Mode Survival dan Adventure sama sekali tidak diintervensi.
- **[[Konfigurasi & GameRules|26.3-Configuration-and-GameRules]]**:
  - Registrasi kategori dinamis `vo_creative_fly_speed:fly_speed` melalui DasikLibrary.
  - `vo_creative_fly_speed`: Pengali kecepatan terbang mode Creative (default: `1000` = $1.0\times$).
  - `vo_spectator_fly_speed`: Pengali kecepatan terbang mode Spectator (default: `1000` = $1.0\times$).
  - Rentang nilai dari `1` hingga `100000`, tersimpan secara alami di `level.dat`.
- **[[Arsitektur & Mixin|26.3-Architecture-and-Mixins]]**:
  - Injeksi presisi pada `ServerPlayer.tick()` di `@At("HEAD")`.
  - Mixin Purity: Bebas logika bisnis, seluruh eksekusi didelegasikan ke `FlySpeedLogic`.
  - Kompleksitas $O(1)$ tanpa alokasi memori heap (zero garbage collection churn).

---

## 📚 Panduan Pengembang & Pemecahan Masalah

- [[Matriks Kompatibilitas Versi|Version-Compatibility]]: Persyaratan Loom, Fabric Loader, dan Java 25.
- [[Pemecahan Masalah & FAQ|Troubleshooting-and-FAQ]]: Penanganan desinkronisasi paket dan penyimpanan dunia.
- [[Panduan Kompilasi Pengembang|Developer-Setup-and-Building]]: Langkah kompilasi dengan Gradle 9.3+.

---

## 📜 Kredit & Lisensi

- **Penulis & Pengembang**: **Dasik (Rifaditya)**
- **Lisensi**: **GNU General Public License v3.0 (GPLv3)**
- **Repositori Kode**: [GitHub Repository](https://github.com/Rifaditya/Creative-Fly-Speed)
