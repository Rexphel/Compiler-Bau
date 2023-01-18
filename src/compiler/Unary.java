package compiler;

import compiler.exception.TypeMismatchException;

import java.util.Map;
import java.util.Vector;

public class Unary extends Expression {
    
    String name;
    Expression expression;


    public Unary(String name, Expression expression) {
        super(null);
        this.name = name;
        this.expression = expression;
    }

    @Override
    public Type typeCheck(Map<String, Type> localVars, Vector<Clazz> classes) {
        if(expression.typeCheck(localVars,classes).equals(Type.INTEGER)
        && "+*".contains(name)){
            return expression.typeCheck(localVars, classes);
        } else if (name.equals("!")
                && expression.typeCheck(localVars, classes).equals(Type.BOOLEAN)) {
            return expression.typeCheck(localVars, classes);
        } else {
            throw new TypeMismatchException("Expression Type does not match name Type");
        }
    }
}
