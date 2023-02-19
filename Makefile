jaooyExe = ./jaooy.linux-gnu
file = TestSuite

./build/Main.class: ./build/Scanner.class
	cp Main.java ./build; cd ./build; javac -cp "../asm-9.2.jar:." Main.java

./build/Scanner.class: ./build/javaparser.class ./build/Scanner.java 
	javac ./build/Scanner.java

./build/Scanner.java: Scanner
	mkdir -p ./build
	java -cp JLex2.jar JLex2.Main Scanner; mv Scanner.java ./build

./build/javaparser.java: javaparser.jay skeleton.jaooy movefiles
	$(jaooyExe) -v javaparser.jay < ./skeleton.jaooy > javaparser.java; mv javaparser.java ./build

./build/javaparser.class: ./build/javaparser.java
	cd ./build; javac javaparser.java

./build/Scanner.class: ./build/Scanner.java
	cd ./build; javac Scanner.java

javafiles.txt:
	cd ./src; /usr/bin/find . -name "*.java" > ../javafiles.txt

javafiles: javafiles.txt
	cd ./src; javac -encoding iso-8859-1 -cp ../asm-9.2.jar @../javafiles.txt

movefiles: javafiles
	mkdir -p build
	mv ./src/*.class ./build

rebuild:
	make clean && make

clean:
	rm ./build/* javafiles.txt

runTest:
	java -cp "asm-9.2.jar:./build" Main < ${file}.java
	echo ------------------
	jar uf junit-platform-console-standalone-1.9.2.jar ${file}.class
	javac -cp junit-platform-console-standalone-1.9.2.jar CompilerTest.java
	echo ------------------
	java -jar junit-platform-console-standalone-1.9.2.jar -cp . -c CompilerTest

