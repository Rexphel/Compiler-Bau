package compiler;

import java.util.Map;
import java.util.Vector;

public class JInteger extends Expression {
    
    Integer i;


    public JInteger(Integer i) {
        super(null);
        this.i = i;
    }

    @Override
    public Type typeCheck(Map<String, Type> localVars, Vector<Clazz> classes) {
        type = Type.INTEGER;
        return type;
    }
}
