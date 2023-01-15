package compiler;

import compiler.exception.TypeMismatchException;

import java.util.Map;
import java.util.Vector;

public class Method implements TypedParserObject {
    
    String name;
    Type type;
    Map<String, Type> parameters;
    Statement block;


    public Method(String name, Type type, Map<String,Type> parameters, Statement block) {
        this.name = name;
        this.type = type;
        this.parameters = parameters;
        this.block = block;
    }


    @Override
    public void codeGen() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Type typeCheck(Map<String, Type> localVars, Vector<Clazz> classes) {
        if(block.typeCheck(localVars, classes).equals(type)){
            return type;
        }else {
            throw new TypeMismatchException("Blocktype and function type missmatch");
        }
    }


}
