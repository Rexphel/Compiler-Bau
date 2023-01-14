package compiler;

import java.util.Map;
import java.util.Vector;

public class Bool extends Expression {
    
    boolean bool;


    public Bool(boolean bool) {
        super(null);
        this.bool = bool;
    }

    @Override
    public Type typeCheck(Map<String, Type> localVars, Vector<Clazz> classes) {
        return new Type("boolean");
    }
}
