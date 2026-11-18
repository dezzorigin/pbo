#!/bin/sh
# Compile & jalankan demo PBO. Butuh JDK 17+ (teruji di Temurin 21).
set -e
cd "$(dirname "$0")"
mkdir -p out
javac -d out Circle.java CylinderS.java Main.java
java -cp out Main
