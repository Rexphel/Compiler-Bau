import org.objectweb.asm.MethodVisitor;

import java.util.List;
import java.util.Map;

public class Parameters extends Expression{
    List<LocalVarDecl> parameters;

    public Parameters(List<LocalVarDecl> parameters) {
        this.parameters = parameters;
    }

    @Override
    public void codeGen(MethodVisitor method) {

    }

    @Override
    public Type typeCheck(Map<String, Type> localVars, Clazz clazz) {
        return null;
    }
}
