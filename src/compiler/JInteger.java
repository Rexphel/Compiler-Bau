package compiler;

import java.util.Map;

public class JInteger extends Expression {
    
    Integer i;

    public JInteger(Integer i) {
        this.i = i;
    }

    @Override
    public void codeGen() {

    }

    @Override
    public Type typeCheck(Map<String, Type> localVars, Clazz clazz) {
        type = Type.INTEGER;
        return type;
    }
}
