package compiler;

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
