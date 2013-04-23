# makefile for Graphtool Java program
Graphtool.jar: src/Graphtool.class src/AdjacencyList.class
	jar -cfm Graphtool.jar manifest.txt -C src/ .

src/Graphtool.class: src/Graphtool.java
	javac src/AdjacencyList.java src/Graphtool.java
src/AdjacencyList.class: src/AdjacencyList.java
	javac src/AdjacencyList.java src/Graphtool.java
	
clean:
	rm *.jar
	rm src/*.class
