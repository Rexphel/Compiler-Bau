import java.lang.Thread.State;
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
    public Type typeCheck(Map<String, Type> localVars, Vector<Class> classes) {
        // TODO Auto-generated method stub
        return null;
    }


}
