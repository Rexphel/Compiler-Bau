package compiler;

import java.util.Map;

public class StmtExprExpr extends Expression {

    StmtExpr stmtExpr;

    public StmtExprExpr(StmtExpr stmtExpr) {
        this.stmtExpr = stmtExpr;
    }

    @Override
    public void codeGen() {

    }

    @Override
    public Type typeCheck(Map<String, Type> localVars, Clazz clazz) {
        type = stmtExpr.typeCheck(localVars, clazz);
        return type;
    }
}
