import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import java.util.List;
import java.util.Map;

public class This extends Expression {

    @Override
    public void codeGen(MethodVisitor method, Clazz clazz, List<LocalVarDecl> localVars) {
        method.visitVarInsn(Opcodes.ALOAD, 0);
    }

    @Override
    public Type typeCheck(Map<String, Type> localVars, Clazz clazz) {
        type = clazz.name;
        return type;
    }

    @Override
    public String toString() {
        return "this()";
    }
}
