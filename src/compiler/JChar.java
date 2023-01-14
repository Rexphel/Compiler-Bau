package compiler;

import java.util.Map;
import java.util.Vector;

public class JChar extends Expression {
    
    char c;


    public JChar(char c) {
        super(null);
        this.c = c;
    }

    @Override
    public Type typeCheck(Map<String, Type> localVars, Vector<Clazz> classes) {
        return new Type("char");
    }
}
