package compiler;

import java.util.Map;
import java.util.Vector;

public class JNull extends Expression {
    

    public JNull() {
        super(null);
    }

    @Override
    public Type typeCheck(Map<String, Type> localVars, Vector<Clazz> classes) {
        return Type.NULL;
    }
}
