#!/bin/bash

echo "Compiling!"

JARNAME="po-editor-core"

javac -Xdiags:verbose *.java exceptions/*.java
jar cvf "$JARNAME.jar" `find . -name \*.class -o -name \*.java`