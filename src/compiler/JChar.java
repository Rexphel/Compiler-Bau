package compiler;

import java.util.Map;

public class JChar extends Expression {
    
    char c;


    public JChar(char c) {
        this.c = c;
    }

    @Override
    public void codeGen() {

    }

    @Override
    public Type typeCheck(Map<String, Type> localVars, Clazz clazz) {
        type = Type.CHAR;
        return type;
    }
}
