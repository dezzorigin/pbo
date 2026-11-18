# PRD — pbo

## 1. Informasi proyek

| field | nilai |
|---|---|
| nama proyek | pbo |
| bahasa | Java (tanpa framework, tanpa dependensi) |
| JDK | 17+ (teruji Temurin 21.0.13) |
| status | selesai — demo inheritance yang jalan |
| penanggung jawab | Nabil Aulia Dika |
| versi dokumen | 2.0 (ditulis ulang 2026-11-18) |
| tanggal | 2026-11-18 |

> catatan jujur: PRD v1.0 (2026-11-05) adalah template generik hasil
> bulk-push — mengklaim proyek ini "Static Web" dengan `npm install`.
> dokumen ini menggantikannya sepenuhnya dengan isi yang sesuai repo.

## 2. Latar belakang

tugas kuliah Pemrograman Berorientasi Objek (PBO): mendemonstrasikan
**inheritance** — satu kelas anak yang memakai ulang (reuse) field dan method
kelas induk, lalu menambah perilakunya sendiri. contoh yang dipakai adalah
geometri yang sudah dikenal semua orang: lingkaran → silinder.

## 3. Masalah yang diselesaikan

mahasiswa PBO butuh contoh inheritance yang kecil, bisa dibaca dalam sekali
duduk, dan benar-benar bisa di-compile + dijalankan — bukan potongan kode di
slide. repo ini contoh itu: 3 file, 0 dependensi, output terverifikasi.

## 4. Tujuan & sasaran

- `Circle` mendefinisikan lingkaran: radius, warna, luas.
- `CylinderS` mewarisi `Circle` dan menambah tinggi + volume.
- `Main` mendemonstrasikan keduanya dengan output yang bisa dicek angkanya.
- repo bersih: tanpa artefak compile (`.class`) yang ter-commit.

## 5. Ruang lingkup

### in scope
- 3 kelas Java: `Circle`, `CylinderS`, `Main`.
- compile + run dengan `javac`/`java` standar, tanpa build tool.
- CI yang meng-compile, menjalankan demo, dan memverifikasi angka output.
- dokumentasi (README, arsitektur, diagram kelas, panduan) + landing page.

### out of scope
- build tool (Maven/Gradle) — sengaja tidak dipakai, programnya terlalu kecil.
- unit test framework — verifikasi dilakukan CI lewat output `Main` itu sendiri.
- fitur baru (input interaktif, GUI, dsb.) — ini contoh tugas, bukan produk.

## 6. Fitur & persyaratan fungsional

### Circle (kelas induk)
- field privat: `radius` (double), `color` (String).
- konstruktor: default (r=1.0, "red"), `Circle(r)`, `Circle(r, c)`.
- getter/setter radius & warna.
- `getArea()` → π × r².

### CylinderS extends Circle (kelas anak)
- field privat tambahan: `height` (double).
- konstruktor: default (r=1.0, h=10.0 via `super()`), `CylinderS(r, h)`.
- getter/setter tinggi.
- `getVolume()` → `super.getArea()` × height (reuse method induk, bukan
  hitung ulang π × r² sendiri).

### Main (demo)
- silinder 1: default → r=1.0, h=10.0, volume 31.41592653589793.
- silinder 2: `CylinderS(7.0, 15.0)` → volume 2309.070600388498.
- mencetak radius, tinggi, dan volume masing-masing silinder.

## 7. Persyaratan non-fungsional

- **portabilitas:** jalan di Linux/macOS/Windows selama ada JDK 17+.
- **tanpa dependensi:** tidak ada library, tidak ada network saat run.
- **kebersihan repo:** `*.class`, `out/`, dan artefak IDE tidak boleh ter-commit
  (dijaga `.gitignore` + step CI yang gagal kalau ada `.class` terlacak).
- **keterbacaan:** kode + komentar secukupnya, penamaan mengikuti konvensi Java.

## 8. Arsitektur & tech stack

Java murni, 3 file di root repo. `Main` → memakai `CylinderS` → mewarisi
`Circle`. detail: [docs/architecture.md](docs/architecture.md), diagram:
[docs/class-diagram.html](docs/class-diagram.html).

## 9. Milestone

| fase | status |
|---|---|
| versi awal (3 kelas + README/PRD template) | ✅ 2026-11-05 |
| proper v1.1.0: bug `z` diperbaiki, `.class` dibersihkan, CI, docs, landing | ✅ 2026-11-18 |

## 10. Risiko & mitigasi

| risiko | mitigasi |
|---|---|
| artefak compile (`.class`) ke-commit lagi | `.gitignore` `*.class` + step CI yang memblokir |
| JDK tidak ada di mesin pengguna | README menyebut JDK 17+ eksplisit; CI memakai Temurin 21 |
| angka output berubah diam-diam | CI memverifikasi dua angka volume secara eksak |

## 11. Kriteria keberhasilan

- `javac` sukses tanpa error, `java -cp out Main` keluar 0.
- output berisi volume 31.41592653589793 dan 2309.070600388498.
- tidak ada file `.class` di tree repo.
- CI hijau di main.

## 12. Lampiran

- struktur: lihat README.md
- lisensi: MIT (LICENSE)
