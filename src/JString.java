import org.objectweb.asm.MethodVisitor;

import java.util.List;
import java.util.Map;

public class JString extends Expression {

    String str;

    public JString(String str) {
        this.str = str; // TODO: we may want to runcate the ""
    }

    @Override
    public void codeGen(MethodVisitor method, Clazz clazz, List<LocalVarDecl> localVars) {
        method.visitLdcInsn(str);
    }

    @Override
    public Type typeCheck(Map<String, Type> localVars, Clazz clazz) {
        type = Type.STRING;
        return type;
    }

    @Override
    public String toString() {
        return "JString{" +
                "\nstr='" + str + '\'' +
                "\n}";
    }
}
