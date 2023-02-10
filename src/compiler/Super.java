package compiler;

import java.util.Map;

public class Super extends Expression {

    @Override
    public void codeGen() {

    }

    @Override
    public Type typeCheck(Map<String, Type> localVars, Clazz clazz) {
        type = Type.VOID;
        return type; //Todo implementieren? kein plan was hier machen
    }
}
