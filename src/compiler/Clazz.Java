package compiler;

import java.util.List;
import java.util.Map;

public class Clazz extends Statement{
    
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

    @Override
    public Type typeCheck(Map<String, Type> localVars, Clazz clazz) {
        clazz = this;
        for (var field : fieldDecl){
            field.typeCheck(localVars, clazz);
        }
        for (var methode : methodDecl){
            methode.typeCheck(localVars, clazz);
        }
        type = Type.VOID;
        return type;
    }
}