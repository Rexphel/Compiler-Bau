package compiler;

public class StmtExprExpr extends Expression {

    StmtExpr stmtExpr;

    public StmtExprExpr(StmtExpr stmtExpr) {
        super(null);
        this.stmtExpr = stmtExpr;
    }

}
