package compiler;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Clazz extends Statement {

    Type name;
    //Field[] fieldDecl;
    //Method[] methodDecl;
    List<Field> fieldDecl;
    List<Method> methodDecl;


    public Clazz(String statement, Type name, List<Field> fieldDecl, List<Method> methodDecl) {
        this.name = name;
        this.fieldDecl = fieldDecl;
        this.methodDecl = methodDecl;
    }


    @Override
    public void codeGen() {

    }

    // TODO: Set clazz in general main of compiler, not here.
    @Override
    public Type typeCheck(Map<String, Type> localVars, Clazz clazz) {
        List<TypedParserObject> l = new ArrayList<>(fieldDecl);
        l.addAll(methodDecl);
        l.forEach(obj -> obj.typeCheck(localVars, clazz));
        type = Type.VOID;
        return type;
    }
}