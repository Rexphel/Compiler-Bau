package compiler;

import java.util.Map;
import java.util.Vector;

public class Statement implements TypedParserObject {

    String statement;
    Type type;

    public Statement(String statement) {
        this.statement = statement;
    }

    @Override
    public void codeGen() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Type typeCheck(Map<String, Type> localVars, Vector<Clazz> classes) {
//        System.out.println("This should not happen. (Tried to typecheck Statement object)");
        throw new RuntimeException("This should not happen. (Tried to typecheck Statement object)");
//        return null;
    }


}