package compiler;

import java.util.Map;

public class This extends Expression {

    @Override
    public void codeGen() {
        //aload 0
    }

    @Override
    public Type typeCheck(Map<String, Type> localVars, Clazz clazz) {
        //type = clazz.type;
        type = clazz.name;
        return type;
    }
}
