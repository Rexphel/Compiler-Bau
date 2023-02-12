import org.objectweb.asm.MethodVisitor;

import java.util.List;
import java.util.Map;

public class JString extends Expression {

    String str;

    public JString(String str) {
        this.str = str;
    }

    @Override
    public void codeGen(MethodVisitor method, Clazz clazz, List<LocalVarDecl> localVars) {

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
