import java.util.Map;
import java.util.Vector;

public class StmtExprStmt  implements TypedParserObject {
    
    StmtExpr StatementExpression;

    public StmtExprStmt(StmtExpr StatementExpression) {
        this.StatementExpression = StatementExpression;
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
