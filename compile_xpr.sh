#!/usr/bin/env bash

cd src/main/java/z3fol/antlr
java -Xmx500M -cp "/usr/local/lib/antlr-4.5.1-complete.jar:$CLASSPATH" org.antlr.v4.Tool XPR.g4