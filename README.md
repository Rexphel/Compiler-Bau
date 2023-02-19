# MiniJava


## Usage

1. Make sure you use Java JDK version 17 or higher (Theoretically it should work with version 12+ but it's not tested.)

2. Make sure you have a working `jaooy` installation in the root path and selected its path in the variable in the makefile. 

3. Make sure that you're in the root directory of the project

4. Run `make`. This compiles the program and creates necessary files.

5. Run `java -cp "asm-9.2.jar:./build" Main < YOUR_FILE_HERE.java` in order to run a custom Java class


### Testing

1. Ensure 1. to 3. above

2. Run `make runTest`. This automatically compiles the TestSuite our Compiler and prepares and runs the JUnit TestSuite

## Known issues 

1. If you get an error from jaooy that either it is not a command or not permitted to execute, you may be running the wrong jaooy executable. Make sure you have the right jaooy defined in the Makefile. We also experienced that downloading the jaooy from git somehow destructs the executable, causing the mentioned error. To fix that, you may want to add your own jaooy build from the given source code or use the working jaooy from the remote computer.

2. It may appear that you get an error like : "mkdir: cannot create directory ‘build’: File exists". This should be fixed already. However, if you still run into this,  just remove the incorrectly generated build file and make a new directory called build in the main root. 

## Contributors

 - Scannen: Lilly Ferreau
 - Parsen:
   - Grammatik/Jay-File: Matthias Fürstenau, Sean Schwarz
   - Abstrakte Syntax (UML): Rafael Simon
 - Semantische Analyse: Maik Franke, Jan-Luca Wolf
- Codeerzeugung: Bernhard Busse, David Schilling
- Tester: Philip Rexroth

## UML diagram
[Klassendiagramm](https://user-images.githubusercontent.com/95235774/218823205-194647d5-a67d-4379-bcf1-bba9955b7be8.jpg)

