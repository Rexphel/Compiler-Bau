import org.objectweb.asm.MethodVisitor;

import java.util.List;
import java.util.Map;

public class StmtExprExpr extends Expression {

    StmtExpr stmtExpr;

    public StmtExprExpr(StmtExpr stmtExpr) {
        this.stmtExpr = stmtExpr;
    }

    @Override
    public void codeGen(MethodVisitor method, Clazz clazz, List<LocalVarDecl> localVars) {
        stmtExpr.codeGen(method, clazz, localVars);
    }

    @Override
    public Type typeCheck(Map<String, Type> localVars, Clazz clazz) {
        type = stmtExpr.typeCheck(localVars, clazz);
        return type;
    }

    @Override
    public String toString() {
        return "StmtExprExpr{" +
                "\nstmtExpr=" + stmtExpr +
                "\n}";
    }
}
