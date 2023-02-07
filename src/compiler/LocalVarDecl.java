package compiler;

import java.util.Map;

public class LocalVarDecl extends Statement {

    Type type;
    String name;

    public LocalVarDecl(Type type, String name) {
        this.type = type;
        this.name = name;
    }

    @Override
    public void codeGen() {

    }

    @Override
    public Type typeCheck(Map<String, Type> localVars, Clazz clazz) {
        localVars.put(name, type);
        return type;
    }

}
