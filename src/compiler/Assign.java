package compiler;

import java.util.Map;
import java.util.Vector;

public class Assign extends StmtExpr {

    String varName; // ?
    Expression expression;

    public Assign(String varName, Expression expression) {
        super(null, null);
        this.varName = varName;
        this.expression = expression;
    }

    @Override
    public Type typeCheck(Map<String, Type> localVars, Vector<Clazz> classes) {
        return Type.VOID; // Da muss noch mehr hin
    }
}
