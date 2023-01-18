package compiler;

import java.util.Map;
import java.util.Vector;

public class StmtExprStmt  implements TypedParserObject {
    
    StmtExpr statementExpression;

    public StmtExprStmt(StmtExpr StatementExpression) {
        this.statementExpression = StatementExpression;
    }


    @Override
    public void codeGen() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Type typeCheck(Map<String, Type> localVars, Vector<Clazz> classes) {
        return new Type("void");
    }



}
