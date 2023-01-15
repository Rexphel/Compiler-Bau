package compiler;

import java.util.Map;
import java.util.Vector;

public class StmtExpr implements TypedParserObject {
    
    Expression expression;
    Statement statement;


    public StmtExpr(Expression expression, Statement statement) {
        this.expression = expression;
        this.statement = statement;
    }


    @Override
    public void codeGen() {
        // TODO Auto-generated method stub
        
    }


    @Override
    public Type typeCheck(Map<String, Type> localVars, Vector<Clazz> classes) {
        System.out.println("This should not happen. (Tried to typecheck StmtExp object)");
        return null;
    }


}
