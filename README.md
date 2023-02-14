# MiniJava


## Usage

1. Make sure you use Java JDK version 17 or higher (Theoretically it should work with version 12+ but it's not tested.)

2. Make sure that you're in the root directory of the project

3. Run `make`. This compiles the program and creates necessary files.

4. Run `java -cp "asm-9.2.jar:./build" Main < YOUR_FILE_HERE.java` in order to run a custom Java class

## Known issues 

1. If you get an error from jaooy that either it is not a command or not permitted to execute, you may be running the wrong jaooy executable. Make sure you have the right jaooy defined in the Makefile. We also experienced that downloading the jaooy from git somehow destructs the executable, causing the mentioned error. To fix that, you may want to add your own jaooy build from the given source code or use the working jaooy from the remote computer.

2. It may appear that you get an error like : "mkdir: cannot create directory ‘build’: File exists". This should be fixed already. However, if you still run into this,  just remove the incorrectly generated build file and make a new directory called build in the main root. 

## Contributors

- Bernhard Busse
- Maik Franke
- David Schilling
- Lilly Ferrau
- Jan-Luca Wolf
- Philip Rexroth
- Sean Schwarz
- Rafael Simon
- Matthias Fürstenau
