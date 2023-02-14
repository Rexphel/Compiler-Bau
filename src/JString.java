import org.objectweb.asm.MethodVisitor;

import java.util.List;
import java.util.Map;

public class JString extends Expression {

    String str;

    public JString(String str) {
        // strip leading and trailing double quotes
        this.str = str.substring(1, str.length() - 1);
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
