package compiler;

import java.util.Map;

public class JNull extends Expression {

    @Override
    public void codeGen() {

    }

    @Override
    public Type typeCheck(Map<String, Type> localVars, Clazz clazz) {
        type = Type.NULL;
        return type;
    }
}
