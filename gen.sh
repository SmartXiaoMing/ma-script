#!/bin/bash
# curl -O https://www.antlr.org/download/antlr-4.7.1-complete.jar
currentDir=$PWD

antlr4='java -Xmx500M -cp ".:./antlr-4.7.1-complete.jar:$CLASSPATH" org.antlr.v4.Tool'
grun='java -cp $CLASSPATH:. org.antlr.v4.gui.TestRig'

inputFile="$currentDir/src/main/resources/MaScriptLexer.g4 $currentDir/src/main/resources/MaScriptParser.g4"
outputDir=$currentDir/src/main/java/com/xiaoming/script/gen/

rm -rf $outputDir/*.interp \
  $outputDir/*.tokens \
  $outputDir/MaScriptLexer.java \
  $outputDir/MaScriptParser.java

package=com.xiaoming.script.gen

# -no-listener
$antlr4 $inputFile -package $package -o $outputDir