package compiler;

import java.util.Map;
import java.util.Vector;

public class StmtExpr implements TypedParserObject {
    
    Expression expression;
    Statement statement;
    Type type;

    public StmtExpr(Expression expression) {
        this.expression = expression;
    }

    public StmtExpr(Statement statement) {
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
