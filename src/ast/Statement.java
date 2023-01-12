package ast;

import java.util.Map;
import java.util.Vector;

public class Statement implements TypedParserObject {

    String statement;

    public Statement(String statement) {
        this.statement = statement;
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