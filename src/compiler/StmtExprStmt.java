package compiler;

import java.util.Map;

//public class StmtExprStmt  implements TypedParserObject { // TODO: Which is right?
public class StmtExprStmt extends Statement {
    
    StmtExpr statementExpression;
    Type type;

    public StmtExprStmt(StmtExpr StatementExpression) {
        this.statementExpression = StatementExpression;
    }


    @Override
    public void codeGen() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Type typeCheck(Map<String, Type> localVars, Clazz clazz) {
        type = Type.VOID;
        return type;
    }



}
