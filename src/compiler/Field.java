package compiler;

import java.util.Map;

public class Field extends Expression {
    
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
    public Type typeCheck(Map<String, Type> localVars, Clazz clazz) {
        boolean b = false;
        for ( int i = 0; i<localVars.size(); i++){
            if (localVars.keySet().toArray()[i].equals(name)) {
                b = true;
                break;
            }
        }
        if(b){
            throw new RuntimeException("Field already exists");
        }
        return type;
    }

    

}
