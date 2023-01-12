package codegen;

import ast.clazz;

public class AsmCodeGenerator implements CodeGenerator {

  private final clazz clazz;

  public AsmCodeGenerator(final ast.clazz clazz) {
    this.clazz = clazz;
  }

  @Override
  public byte[] generateCode() {
    return new byte[0];
  }
}
