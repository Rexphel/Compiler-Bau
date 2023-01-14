package compiler;

public class If extends Statement {

    Expression condition;
    Statement statement;
    Statement maybeStatement; // Nich in UML

    public If(Expression condition, Statement statement, Statement mayStatement) {
        super(null);
        this.condition = condition;
        this.statement = statement;
        this.maybeStatement = mayStatement;
    }


}