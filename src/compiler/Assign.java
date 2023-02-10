package compiler;

import java.util.Map;

public class Assign extends StmtExpr {

    String varName; // ?Todo frage für Prof muss das nicht ein expression sein
    Expression expression;

    public Assign(String varName, Expression expression) {
        super((Expression) null);
        this.varName = varName;
        this.expression = expression;
    }

    @Override
    public void codeGen() {

    }

    @Override
    public Type typeCheck(Map<String, Type> localVars, Clazz clazz) {
        if (localVars.get(varName).equals(expression.typeCheck(localVars, clazz))) {
            type = expression.typeCheck(localVars, clazz);
            return type;
        } else {
            throw new RuntimeException("VarType and expression Type mismatch");
        }
    }
}
