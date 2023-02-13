import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import java.util.Map;

public class JChar extends Expression {

    char c;


    public JChar(char c) {
        this.c = c;
    }

    @Override
    public void codeGen(MethodVisitor method) {
        method.visitIntInsn(Opcodes.BIPUSH, this.c);
    }

    @Override
    public Type typeCheck(Map<String, Type> localVars, Clazz clazz) {
        type = Type.CHAR;
        return type;
    }

    @Override
    public String toString() {
        return "JChar{" +
                "\nc=" + c +
                "\n}";
    }
}
