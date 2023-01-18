package compiler;

import java.util.Map;
import java.util.Vector;

public class JString extends Expression {
    
    String str;


    public JString(String str) {
        super(null);
        this.str = str;
    }

    @Override
    public Type typeCheck(Map<String, Type> localVars, Vector<Clazz> classes) {
        return Type.STRING;
    }
}
