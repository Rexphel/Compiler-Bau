package compiler;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import java.util.Map;

public class JNull extends Expression {

    @Override
    public void codeGen(MethodVisitor method) {
        method.visitInsn(Opcodes.ACONST_NULL);
    }

    @Override
    public Type typeCheck(Map<String, Type> localVars, Clazz clazz) {
        type = Type.NULL;
        return type;
    }
}
