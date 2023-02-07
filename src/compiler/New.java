package compiler;

import java.util.List;
import java.util.Map;
import java.util.Vector;

public class New extends StmtExpr {

    Type type;
    List<Expression> expressionList;

    public New(Type type, List<Expression> expressionList) {
        super((Expression) null);
        this.type = type;
        this.expressionList = expressionList;
    }

    @Override
    public Type typeCheck(Map<String, Type> localVars, Vector<Clazz> classes) {
        if (super.expression != null && super.statement != null) {
            throw new RuntimeException("StmtExpr is both a statement and an expression!");
        }

        if (super.expression == null) {
            type = Type.VOID;
            return type;
        } else {
            type = super.expression.typeCheck(localVars, classes);
            return type;
        }
    }
}
