jaooyExe = linux-gnu

Main.class: Scanner.class
	cp Main.java ./build; cd ./build; javac Main.java

Scanner.class: Scanner.java javaparser.class
	javac ./build/Scanner.java

Scanner.java: Scanner
	java -cp JLex2.jar JLex2.Main Scanner; mv Scanner.java ./build

javaparser.java: javaparser.jay skeleton.jaooy movefiles
	./jaooy.$(jaooyExe) -v javaparser.jay < ./skeleton.jaooy > javaparser.java; mv javaparser.java ./build

javaparser.class: javaparser.java
	cd ./build; javac javaparser.java

Scanner.class: Scanner.java
	cd ./build; javac Scanner.java

javafiles.txt:
	cd ./src; /usr/bin/find . -name "*.java" > ../javafiles.txt

javafiles: javafiles.txt
	cd ./src; javac -cp ../asm-9.2.jar @../javafiles.txt

movefiles: javafiles
	mkdir -p build
	mv ./src/*.class ./build


clean:
	rm ./build/*