import org.objectweb.asm.MethodVisitor;

public abstract class StmtExpr implements TypedParserObject {

    Type type;


    public abstract void codeGen(MethodVisitor method);
}
