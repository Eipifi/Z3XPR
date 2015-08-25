#!/usr/bin/env bash

cd /Users/eipifi/Sources/z3fol/src/main/java/z3fol/xpr
java -Xmx500M -cp "/usr/local/lib/antlr-4.5.1-complete.jar:$CLASSPATH" org.antlr.v4.Tool XPR.g4