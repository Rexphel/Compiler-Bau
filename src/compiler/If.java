package compiler;

import compiler.exception.TypeMismatchException;

import java.util.Map;
import java.util.Vector;

public class If extends Statement {

    Expression condition;
    Statement statement; // IF
    Statement maybeStatement; // Nich in UML

    public If(Expression condition, Statement statement, Statement mayStatement) {
        super(null);
        this.condition = condition;
        this.statement = statement;
        this.maybeStatement = mayStatement;
    }

    @Override
    public Type typeCheck(Map<String, Type> localVars, Vector<Clazz> classes) {
        if (condition.typeCheck(localVars, classes).equals(Type.BOOLEAN)
                && statement.typeCheck(localVars, classes).equals(maybeStatement.typeCheck(localVars, classes))) {
            type = statement.typeCheck(localVars, classes);
            return type;
        } else {
            throw new TypeMismatchException("If Statement types do not match");
        }
    }

}