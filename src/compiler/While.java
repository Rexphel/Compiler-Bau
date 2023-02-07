package compiler;

import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;

import java.util.Map;

public class While extends Statement {

    Expression expression;
    Statement statement;


    public While(Expression expression, Statement statement) {
        this.expression = expression;
        this.statement = statement;
    }

    @Override
    public void codeGen(MethodVisitor method) {
        Label startLabel = new Label();
        // expression has to load true/false with that we can jump or not by comparing the result to true
    }

    @Override
    public Type typeCheck(Map<String, Type> localVars, Clazz clazz) {
        if (expression.typeCheck(localVars, clazz).equals(Type.BOOLEAN)) {
            type = statement.typeCheck(localVars, clazz);
            return type;
        } else {
            throw new RuntimeException("expression Type does not match boolean");
        }

    }
}