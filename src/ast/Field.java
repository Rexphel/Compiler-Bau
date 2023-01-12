package ast;

import java.util.Map;
import java.util.Vector;

public class Field implements TypedParserObject {
    
    String name;
    Type type;


    public Field(String name, Type type) {
        this.name = name;
        this.type = type;
    }


    @Override
    public void codeGen() {
        // TODO Auto-generated method stub
        
    }


    @Override
    public Type typeCheck(Map<String, Type> localVars, Vector<Class> classes) {
        // TODO Auto-generated method stub
        return null;
    }

    

}
