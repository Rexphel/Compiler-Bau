package codegen;

import ast.clazz;
import java.util.Arrays;

public class Main {
  public static void main(final String[] args) {
    final clazz clazz = null; // TODO
    final CodeGenerator codeGenerator = new AsmCodeGenerator(clazz);
    final byte[] bytes = codeGenerator.generateCode();
    System.out.println(Arrays.toString(bytes));
  }
}
