package compiler;

import java.util.Map;
import java.util.Vector;

public class StmtExprExpr extends Expression {

    StmtExpr stmtExpr;

    public StmtExprExpr(StmtExpr stmtExpr) {
        super(null);
        this.stmtExpr = stmtExpr;
    }

    @Override
    public Type typeCheck(Map<String, Type> localVars, Vector<Clazz> classes) {
        type = stmtExpr.typeCheck(localVars, classes);
        return type;
    }
}
