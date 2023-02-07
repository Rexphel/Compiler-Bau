package compiler;

import java.util.Map;
import java.util.Vector;

public class Clazz extends Statement{
    
    Type name;
    Field[] fieldDecl;
    Method[] methodDecl;

    public Clazz(String statement, Type name, Field[] fieldDecl, Method[] methodDecl) {
        super(statement);   //TOdo: Statement?
        this.name = name;
        this.fieldDecl = fieldDecl;
        this.methodDecl = methodDecl;
    }


    @Override
    public Type typeCheck(Map<String, Type> localVars, Vector<Clazz> classes) {
        classes.add(this);
        for (var field : fieldDecl){
            field.typeCheck(localVars, classes);
        }
        for (var methode : methodDecl){
            methode.typeCheck(localVars, classes);
        }
        type = Type.VOID;
        return type;
    }
}