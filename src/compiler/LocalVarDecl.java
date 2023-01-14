package compiler;

import java.util.Map;
import java.util.Vector;

public class LocalVarDecl extends Statement {
    
    Type type;
    String name;


    public LocalVarDecl(Type type, String name) {
        super(null);
        this.type = type;
        this.name = name;
    }

    @Override
    public Type typeCheck(Map<String, Type> localVars, Vector<Clazz> classes) {
        return super.typeCheck(localVars, classes);//Todo: Typecheck implementieren
    }
}
