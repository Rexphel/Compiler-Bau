package compiler;

import java.util.Map;
import java.util.Vector;

public class Return extends Statement {
    
    Expression expression;


    public Return(Expression expression) {
        super(null);
        this.expression = expression;
    }

    @Override
    public Type typeCheck(Map<String, Type> localVars, Vector<Clazz> classes) {
        return expression.typeCheck(localVars, classes);
    }
}
