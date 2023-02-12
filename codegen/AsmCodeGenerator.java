package codegen;

public class AsmCodeGenerator implements CodeGenerator {

  private final Clazz clazz;

  public AsmCodeGenerator(final Clazz clazz) {
    this.clazz = clazz;
  }

  @Override
  public byte[] generateCode() {
    return new byte[0];
  }
}
