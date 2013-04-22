# makefile for Graphtool Java program
Graphtool.jar: bin/Graphtool.class bin/AdjacencyList.class
	jar -cfm Graphtool.jar manifest.txt -C bin/ .

bin/Graphtool.class: src/Graphtool.java
	javac -d bin src/Graphtool.java

bin/AdjacencyList.class: src/AdjacencyList.java
	javac -d bin src/AdjacencyList.java
	
clean:
	rm *.jar
	rm bin/*.class
