# panduan penggunaan — pbo

## syarat

JDK 17 atau lebih baru. cara cek:

```bash
javac -version
```

kalau belum ada: unduh Temurin 21 dari
https://adoptium.net/temurin/releases/ (pilih JDK 21, sesuai OS-mu).

## compile & jalankan

dari root repo:

```bash
javac -d out Circle.java CylinderS.java Main.java
java -cp out Main
```

atau sekali jalan:

```bash
./run.sh
```

hasil compile masuk folder `out/` — folder ini sudah di-`.gitignore`, jadi
tidak akan ikut ter-commit. file `*.class` yang muncul di komputermu setelah
compile adalah artefak lokal yang normal.

## output yang diharapkan

```
=== Silinder 1 (Default) ===
Radius : 1.0
Tinggi : 10.0
Volume : 31.41592653589793

=== Silinder 2 (Custom) ===
Radius : 7.0
Tinggi : 15.0
Volume : 2309.070600388498
```

kalau angkanya persis seperti di atas, programmu jalan dengan benar.
rumusnya: volume = π × r² × h.

## coba sendiri

ubah angka di `Main.java`, misal `new CylinderS(3.0, 5.0)`, lalu compile +
jalankan lagi. volume yang benar: π × 9 × 5 = 141,3716694115407.

## kalau compile gagal

- `javac: command not found` → JDK belum terpasang atau belum masuk PATH.
- `error: file not found: Circle.java` → pastikan perintah dijalankan dari
  root repo (folder yang berisi `Circle.java`).
- error lain → baca pesan `javac` baris pertama, biasanya nama file +
  nomor baris sudah menunjuk letak masalahnya.
