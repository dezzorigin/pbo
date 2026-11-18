# arsitektur — pbo

proyek ini sengaja kecil: 3 file Java di root repo, tanpa framework, tanpa
build tool, tanpa dependensi. arsitekturnya adalah satu rantai inheritance.

```
Main ── memakai ──▶ CylinderS ── extends ──▶ Circle
```

## Circle — kelas induk

lingkaran. menyimpan `radius` (double) dan `color` (String) sebagai field
privat, diekspos lewat getter/setter. satu-satunya perilaku berhitung:
`getArea()` → `Math.PI * radius * radius`.

tiga konstruktor: default (radius 1.0, warna "red"), `Circle(r)`,
`Circle(r, warna)`.

## CylinderS — kelas anak

silinder = lingkaran + tinggi. `extends Circle`, jadi semua field dan method
`Circle` (radius, warna, `getArea()`) langsung tersedia tanpa ditulis ulang.
yang ditambah hanya field privat `height` + getter/setter + `getVolume()`.

poin PBO-nya ada di `getVolume()`:

```java
public double getVolume() {
    return super.getArea() * this.height;
}
```

volume dihitung dengan **memakai ulang** `getArea()` dari induk, bukan
menghitung π × r² sendiri. kalau rumus luas berubah, volume ikut benar.

dua konstruktor: default (`super()` → r=1.0, h=10.0) dan `CylinderS(r, h)`.

## Main — demo

bukan library, bukan server: program CLI yang membuat dua silinder dan
mencetak radius, tinggi, dan volumenya ke stdout.

- silinder 1: default → r=1.0, h=10.0 → volume π × 1² × 10 = 31,41592653589793
- silinder 2: `CylinderS(7.0, 15.0)` → volume π × 7² × 15 = 2309,070600388498

## kenapa tanpa Maven/Gradle

tiga file, nol dependensi — build tool hanya menambah kerumitan tanpa manfaat.
compile langsung `javac`, run langsung `java`. CI memakai perintah yang sama
persis seperti yang tertulis di README, jadi yang terverifikasi CI adalah yang
dijalankan pengguna.

## diagram kelas

[docs/class-diagram.html](class-diagram.html) — diagram SVG mandiri.
