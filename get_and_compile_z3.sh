#!/usr/bin/env bash

PDIR=$(pwd)
rm -r lib/*
rm -r other/*
mkdir -p lib
mkdir -p other
cd /tmp
git clone https://github.com/Z3Prover/z3 -b master
cd z3
git checkout z3-4.4.1
python scripts/mk_make.py --java
cd build
make all
cp com.microsoft.z3.jar $PDIR/lib
cp libz3* $PDIR/lib
cd ..
mkdir -p $PDIR/other/com/microsoft
cp -r src/api/java $PDIR/other/com/microsoft/z3
