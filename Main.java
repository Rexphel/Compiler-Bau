import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import org.objectweb.asm.*;

class Main {

    public static void main(String args[]) throws java.io.IOException {
        javascanner scanner = new javascanner(new java.io.InputStreamReader(System.in));
        MiniJavaParser parser = new MiniJavaParser();

        try {
            Clazz clazz = (Clazz) parser.yyparse(scanner);
            System.out.println(clazz.toString());
            clazz.typeCheck();
            byte[] bytecode = clazz.codeGen();
            writeClassfile(bytecode);
            // TODO write to file
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void writeClassfile(byte[] bytecode)throws IOException{
        String className = new ClassReader(bytecode).getClassName();
        System.out.println("Writing file to ./" + className + ".class");
        File outputFile = new File("./", className + ".class");
        FileOutputStream output = new FileOutputStream(outputFile);
        output.write(bytecode);
        output.close();
    }
}