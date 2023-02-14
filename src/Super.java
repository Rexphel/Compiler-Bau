import org.objectweb.asm.MethodVisitor;

import java.util.List;
import java.util.Map;

public class Super extends Expression {

    // hiermit sollte in unserem Fall ausschließlich auf Object zugegriffen werde, da weitere Vererbung nicht implementiert wird.

    @Override
    public void codeGen(MethodVisitor method, Clazz clazz, List<LocalVarDecl> localVars) {
        //aload java/lang/Object

    }

    @Override
    public Type typeCheck(Map<String, Type> localVars, Clazz clazz) {
        type = new Type("Object");
        return type;
    }

    @Override
    public String toString() {
        return "Super()";
    }
}
