package compiler;

import compiler.exception.TypeMismatchException;

import java.util.Map;

public class If extends Statement {

    Expression condition;
    Statement statement; // IF
    Statement maybeStatement; // Nicht in UML

    public If(Expression condition, Statement statement, Statement mayStatement) {
        this.condition = condition;
        this.statement = statement;
        this.maybeStatement = mayStatement;
    }

    @Override
    public void codeGen() {

    }

    @Override
    public Type typeCheck(Map<String, Type> localVars, Clazz clazz) {
        if (condition.typeCheck(localVars, clazz).equals(Type.BOOLEAN)
                && statement.typeCheck(localVars, clazz).equals(maybeStatement.typeCheck(localVars, clazz))) {
            type = statement.typeCheck(localVars, clazz);
            return type;
        } else {
            throw new TypeMismatchException("If Statement types do not match");
        }
    }

}