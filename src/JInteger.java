import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import java.util.List;
import java.util.Map;

public class JInteger extends Expression {

    int i;

    public JInteger(int i) {
        this.i = i;
    }

    @Override
    public void codeGen(MethodVisitor method, Clazz clazz, List<LocalVarDecl> localVars) {
        if (i >= -1 && i <= 5) {
            // Use the ICONST instruction for values between -1 and 5
            method.visitInsn(Opcodes.ICONST_0 + i);
        } else if (i >= -128 && i <= 127) {
            // Use the BIPUSH instruction for values between -128 and 127
            method.visitIntInsn(Opcodes.BIPUSH, i);
        } else if (i >= -32768 && i <= 32767) {
            // Use the SIPUSH instruction for values between -32768 and 32767
            method.visitIntInsn(Opcodes.SIPUSH, i);
        } else {
            // Use the LDC instruction for values outside the range of BIPUSH and SIPUSH
            method.visitLdcInsn(i);
        }
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
