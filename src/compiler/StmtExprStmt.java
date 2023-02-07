package compiler;

import org.objectweb.asm.MethodVisitor;

import java.util.Map;

public class StmtExprStmt extends Statement {

    StmtExpr statementExpression;
    Type type;

    public StmtExprStmt(StmtExpr StatementExpression) {
        this.statementExpression = StatementExpression;
    }


    @Override
    public void codeGen(MethodVisitor method) {
        statementExpression.codeGen(method);
    }

    @Override
    public Type typeCheck(Map<String, Type> localVars, Clazz clazz) {
        type = Type.VOID;
        return type;
    }


}
