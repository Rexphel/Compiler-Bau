package compiler;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import java.util.Map;

public class JInteger extends Expression {

    int i;

    public JInteger(Integer i) {
        this.i = i;
    }

    @Override
    public void codeGen(MethodVisitor method) {
        //TODO: we maybe can also use the ICONST Opcodes
        method.visitIntInsn(Opcodes.BIPUSH, i);
    }

    @Override
    public Type typeCheck(Map<String, Type> localVars, Clazz clazz) {
        type = Type.INTEGER;
        return type;
    }

    @Override
    public String toString() {
        return "JInteger{" +
                "\ni=" + i +
                "\n}";
    }
}
