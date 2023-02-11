import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import java.util.Map;

public class This extends Expression {

    @Override
    public void codeGen(MethodVisitor method) {
        method.visitVarInsn(Opcodes.ALOAD, 0);
    }

    @Override
    public Type typeCheck(Map<String, Type> localVars, Clazz clazz) {
        //type = clazz.type;
        type = clazz.name;
        return type;
    }

    @Override
    public String toString() {
        return "this()";
    }
}
