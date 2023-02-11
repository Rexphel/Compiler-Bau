import org.objectweb.asm.MethodVisitor;

import java.util.Map;

public class Super extends Expression {

    // TODO: hiermit sollte in unserem Fall ausschließlich auf Object zugegriffen werde, da weitere Vererbung nicht implementiert wird.

    @Override
    public void codeGen(MethodVisitor method) {
        //aload java/lang/Object

    }

    @Override
    public Type typeCheck(Map<String, Type> localVars, Clazz clazz) {
        type = Type.VOID;
        return type; //Todo implementieren? kein plan was hier machen
    }

    @Override
    public String toString() {
        return "Super()";
    }
}
