package compiler;

import compiler.exception.TypeMismatchException;
import org.objectweb.asm.MethodVisitor;

import java.util.Map;

public class Unary extends Expression {

    String name;
    Expression expression;


    public Unary(String name, Expression expression) {
        this.name = name;
        this.expression = expression;
    }

    @Override
    public void codeGen(MethodVisitor method) {
        expression.codeGen(method);
        //unary operation
    }

    @Override
    public Type typeCheck(Map<String, Type> localVars, Clazz clazz) {
        if (expression.typeCheck(localVars, clazz).equals(Type.INTEGER)
                && "+*".contains(name)) {
            type = expression.typeCheck(localVars, clazz);
            return type;
        } else if (name.equals("!")
                && expression.typeCheck(localVars, clazz).equals(Type.BOOLEAN)) {
            type = expression.typeCheck(localVars, clazz);
            return type;
        } else {
            throw new TypeMismatchException("Expression Type does not match name Type");
        }
    }
}
