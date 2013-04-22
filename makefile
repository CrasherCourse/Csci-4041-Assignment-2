# makefile for Graphtool Java program
Graphtool.jar: bin/Graphtool.class
	jar -cfm Graphtool.jar manifest.txt -C bin/ .

bin/Graphtool.class: src/Graphtool.java
	javac -d bin src/Graphtool.java
	
clean:
	rm *.jar
	rm bin/*.class
