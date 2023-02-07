package compiler;

import java.util.Map;
import java.util.Vector;

public abstract class StmtExpr implements TypedParserObject {
    
    Expression expression;
    Statement statement;
    Type type;

    // TODO: Constructor(s) HERE needed?
    public StmtExpr(Expression expression) {
        this.expression = expression;
    }

    public StmtExpr(Statement statement) {
        this.statement = statement;
    }

}
