import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import java.util.Map;

public class Bool extends Expression {

    boolean bool;


    public Bool(boolean bool) {
        this.bool = bool;
    }

    @Override
    public void codeGen(MethodVisitor method) {
        if (bool){
            method.visitInsn(Opcodes.ICONST_1);
        } else {
            method.visitInsn(Opcodes.ICONST_0);
        }

    }

    @Override
    public Type typeCheck(Map<String, Type> localVars, Clazz clazz) {
        type = Type.BOOLEAN;
        return type;
    }

    @Override
    public String toString() {
        return "Bool{\n" +
                "bool=" + bool + "\n" +
                '}';
    }
}
