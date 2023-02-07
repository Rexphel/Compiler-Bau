package compiler;

import java.util.Map;
import java.util.Vector;

public class This extends Expression {
    

    public This() {
        super(null);
    }

    @Override
    public Type typeCheck(Map<String, Type> localVars, Vector<Clazz> classes) {
        return classes.get(0).typeCheck(localVars, classes);
    }
}
