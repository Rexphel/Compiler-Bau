package compiler;

import java.util.Map;

public class JString extends Expression {

    String str;

    public JString(String str) {
        this.str = str;
    }

    @Override
    public void codeGen() {

    }

    @Override
    public Type typeCheck(Map<String, Type> localVars, Clazz clazz) {
        type = Type.STRING;
        return type;
    }
}
