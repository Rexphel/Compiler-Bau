import org.objectweb.asm.MethodVisitor;

import java.util.List;
import java.util.Map;

public class StmtExprStmt extends Statement {

    StmtExpr statementExpression;
    Type type;

    public StmtExprStmt(StmtExpr StatementExpression) {
        this.statementExpression = StatementExpression;
    }


    @Override
    public void codeGen(MethodVisitor method, Clazz clazz, List<LocalVarDecl> localVars) {
        statementExpression.codeGen(method, clazz, localVars);
    }

    @Override
    public Type typeCheck(Map<String, Type> localVars, Clazz clazz) {
        statementExpression.typeCheck(localVars, clazz);
        type = Type.VOID;
        return type;
    }

    @Override
    public String toString() {
        return "StmtExprStmt{" +
                "\nstatementExpression=" + statementExpression +
                ",\n type=" + type +
                "\n}";
    }
}
