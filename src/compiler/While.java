package compiler;

public class While extends Statement {
    
    Expression expression;
    Statement statement;


    public While(Expression expression, Statement statement) {
        super(null);
        this.expression = expression;
        this.statement = statement;
    }


}
