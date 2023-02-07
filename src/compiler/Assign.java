package compiler;

import java.util.Map;
import java.util.Vector;

public class Assign extends StmtExpr {

    String varName; // ?Todo frage für Prof muss das nicht ein expression sein
    Expression expression;

    public Assign(String varName, Expression expression) {
        super(null, null);
        this.varName = varName;
        this.expression = expression;
    }
    int i = 5;
    @Override
    public Type typeCheck(Map<String, Type> localVars, Vector<Clazz> classes) {
        if(localVars.get(varName).equals(expression.typeCheck(localVars, classes))){
            return expression.typeCheck(localVars, classes);
        } else{
            throw new RuntimeException("VarType and expression Type mismatch");
        }
    }
}
