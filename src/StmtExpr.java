import org.objectweb.asm.MethodVisitor;

import java.util.List;

public abstract class StmtExpr implements TypedParserObject {

    Type type;


    public abstract void codeGen(MethodVisitor method, Clazz clazz, List<LocalVarDecl> localVars);
}
