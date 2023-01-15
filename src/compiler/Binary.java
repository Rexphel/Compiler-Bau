package compiler;

import compiler.exception.TypeMismatchException;

import java.util.Map;
import java.util.Vector;

public class Binary extends Expression {

    String name;
    Expression expression1;
    Expression expression2;


    public Binary(String name, Expression expression1, Expression expression2) {
        super(null);
        this.name = name;
        this.expression1 = expression1;
        this.expression2 = expression2;
    }

    @Override
    public Type typeCheck(Map<String, Type> localVars, Vector<Clazz> classes) {

        if (
                expression1.typeCheck(localVars, classes).equals(expression2.typeCheck(localVars, classes))
        ) {
            if (name.equals("+") &&
                    (expression1.typeCheck(localVars, classes).equals(Type.INTEGER) ||
                            expression1.typeCheck(localVars, classes).equals(Type.STRING))
            ) {
                Type type = expression1.typeCheck(localVars, classes);
                return type;
            } else if ("-*%".contains(name) &&
                    expression1.typeCheck(localVars, classes).equals(Type.INTEGER)) {
                Type type = expression1.typeCheck(localVars, classes);
                return type;
            } else if (
                    (name.equals("&&")||name.equals("||")) &&
                            expression1.typeCheck(localVars, classes).equals(Type.BOOLEAN)
            ) {
                Type type = expression1.typeCheck(localVars, classes);
                return type;
            } else {
                throw new TypeMismatchException("Name does not match or expressions are from wrong Type");
            }
        } else {throw new TypeMismatchException("Binary Expression Types does not match");}

    }
}