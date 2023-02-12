import org.objectweb.asm.MethodVisitor;

import java.util.List;
import java.util.Map;

public class New extends StmtExpr {

    //Is this even needed?
    Type type;
    List<Expression> expressionList;

    public New(Type type, List<Expression> expressionList) {
        this.type = type;
        this.expressionList = expressionList;
    }

    @Override
    public void codeGen(MethodVisitor method) {

    }

    @Override
    public Type typeCheck(Map<String, Type> localVars, Clazz clazz) {
        //TODO: where does the expressionList come from?
        /*if (super.expression != null && super.statement != null) {
            throw new RuntimeException("StmtExpr is both a statement and an expression!");
        }

        if (super.expression == null) {
            type = Type.VOID;
            return type;
        } else {
            type = super.expression.typeCheck(localVars, clazz);
            return type;
        }*/
        return null;
    }

    @Override
    public String toString() {
        return "New{" +
                "type=" + type +
                ",\n expressionList=" + expressionList +
                "\n}";
    }
}
