package compiler;

import org.objectweb.asm.MethodVisitor;

public abstract class Statement implements TypedParserObject {

    String statement;
    Type type;

    public abstract void codeGen(MethodVisitor method);
}