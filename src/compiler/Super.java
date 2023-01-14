package compiler;

import java.util.Map;
import java.util.Vector;

public class Super extends Expression {
    

    public Super() {
        super(null);
    }

    @Override
    public Type typeCheck(Map<String, Type> localVars, Vector<Clazz> classes) {
        return super.typeCheck(localVars, classes); //Todo: Typecheck implementieren
    }
}
