
JAVADIR=/usr/share/java
JARNAME=po-editor-app

all:
	(cd src; javac -cp $(JAVADIR)/po-uuilib.jar:$(JAVADIR)/po-editor-core.jar -encoding UTF-8 `find . -name \*.java`)
	(cd src; jar cvf ../$(JARNAME).jar `find . -name \*.class -o -name \*.java` )

clean:
	$(RM) $(JARNAME).jar `find . -name \*.class`
