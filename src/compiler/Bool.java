package compiler;

import java.util.Map;

public class Bool extends Expression {
    
    boolean bool;


    public Bool(boolean bool) {
        this.bool = bool;
    }

    @Override
    public void codeGen() {

    }

    @Override
    public Type typeCheck(Map<String, Type> localVars, Clazz clazz) {
        type = Type.BOOLEAN;
        return type;
    }
}
