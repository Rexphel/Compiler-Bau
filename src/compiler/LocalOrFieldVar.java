package compiler;

import java.util.Map;
import java.util.Vector;

public class LocalOrFieldVar extends Expression {
    
    String name;

    public LocalOrFieldVar(String name) {
        super(null);
        this.name = name;
    }

    @Override
    public Type typeCheck(Map<String, Type> localVars, Vector<Clazz> classes) {
        return super.typeCheck(localVars, classes);//Todo: Typecheck implementieren
    }
}
