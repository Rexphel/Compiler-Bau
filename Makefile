Main.class: javalexer.class Main.java
    javac Main.java
javalexer.class: javalexer.java
    javac javalexer.java
javalexer.java: javalexer
    java -cp JLex2.jar JLex2.Main javalexer
clean:
    rm *.class javalexer.java