.PHONY: build clean run

build: tema4

run:
	java -Xmx1G -jar Tema4AA.jar
	
tema4:
	javac *.java
	jar cfe Tema4AA.jar Tema4AA *.class

clean:
	rm -rf *.class