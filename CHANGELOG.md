# Changelog

Semua perubahan penting proyek ini dicatat di file ini.

Format mengikuti [Keep a Changelog](https://keepachangelog.com/en/1.0.0/),
proyek ini mengikuti [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

> catatan: CHANGELOG lama (2026-11-05) adalah template fiktif — mengklaim
> "Next.js project setup", "budget tracking", dan "Supabase RLS". Semua
> klaim itu salah untuk repo Java ini dan sudah dibuang.

## [1.1.0] - 2026-11-18

### Fixed
- Huruf `z` nyasar di `Circle.java` baris 10 yang membuat `javac` gagal
  (`error: <identifier> expected`) — dihapus, program sekarang compile.
- File `.class` yang ter-commit (`Circle.class`, `CylinderS.class`,
  `Main.class`) dihapus dari tree.

### Added
- CI (`.github/workflows/ci.yml`): setup JDK 21 Temurin, compile dengan
  `javac`, jalankan demo, verifikasi angka volume, dan gagal kalau ada
  file `.class` yang terlacak.
- `run.sh` — compile + jalankan sekali jalan.
- `docs/`: arsitektur, diagram kelas (HTML+SVG), panduan penggunaan.
- `site/`: landing page dokumentasi, deploy ke Cloudflare Pages.

### Changed
- README & PRD ditulis ulang total sesuai isi repo sebenarnya (sebelumnya
  template fiktif: klaim "Static Web" + `npm install`).
- `.gitignore` diperkuat untuk Java: `*.class`, `*.jar`, `out/`, `target/`,
  artefak IDE.

## [1.0.0] - 2026-11-05

### Added
- Versi awal: `Circle.java`, `CylinderS.java`, `Main.java` — demo
  inheritance lingkaran → silinder.
- README, PRD, LICENSE MIT.
