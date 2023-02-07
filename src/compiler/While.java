package compiler;

import java.util.Map;
import java.util.Vector;

public class While extends Statement {

    Expression expression;
    Statement statement;


    public While(Expression expression, Statement statement) {
        super(null);
        this.expression = expression;
        this.statement = statement;
    }

    @Override
    public Type typeCheck(Map<String, Type> localVars, Vector<Clazz> classes) {
        if (expression.typeCheck(localVars, classes).equals(Type.BOOLEAN)) {
            type = statement.typeCheck(localVars, classes);
            return type;
        } else {
            throw new RuntimeException("expression Type does not match boolean");
        }

    }
}