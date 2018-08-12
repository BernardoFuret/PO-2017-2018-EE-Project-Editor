#!/bin/bash

echo "Compiling!"

JAVADIR=/usr/share/java
JARNAME="po-editor-core"

javac -Xdiags:verbose -cp /usr/share/java/po-uuilib.jar:/usr/share/java/po-editor-core.jar -encoding UTF-8 *.java editor/*.java document/*.java chapter/*.java section/*.java paragraph/*.java sentence/*.java