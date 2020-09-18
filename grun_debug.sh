#!/bin/bash

mvn clean compile

targetDir=target/classes
libDir=antlr-4.7.1-complete.jar
rule=program
param="-gui"
if [[ $# -gt 0 ]]; then
  rule=$1
fi
if [[ $# -gt 1 ]]; then
  param=$2
fi

grun="java -cp $CLASSPATH:./$lib:./$targetDir org.antlr.v4.gui.TestRig com.xiaomi.ai.ma.script.gen.MaScript $rule $param"

echo $grun
echo "input the code then press CTRL+D"

$grun