package compiler;

import compiler.exception.TypeMismatchException;
import org.objectweb.asm.MethodVisitor;

import java.util.Map;

public class Binary extends Expression {

    String name;
    Expression expression1;
    Expression expression2;


    public Binary(String name, Expression expression1, Expression expression2) {
        this.name = name;
        this.expression1 = expression1;
        this.expression2 = expression2;
    }

    @Override
    public void codeGen(MethodVisitor method) {
        // the binary can be the condition of an if block, if so we have to implement a jump here
        // else 2 xLOADS and the respective binary operation
    }

    @Override
    public Type typeCheck(Map<String, Type> localVars, Clazz clazz) {

        if (
                expression1.typeCheck(localVars, clazz).equals(expression2.typeCheck(localVars, clazz))
        ) {
            if (name.equals("+") &&
                    (expression1.typeCheck(localVars, clazz).equals(Type.INTEGER) ||
                            expression1.typeCheck(localVars, clazz).equals(Type.STRING))
            ) {
                type = expression1.typeCheck(localVars, clazz);
                return type;
            } else if ("-*%".contains(name) &&
                    expression1.typeCheck(localVars, clazz).equals(Type.INTEGER)) {
                type = expression1.typeCheck(localVars, clazz);
                return type;
            } else if (
                    (name.equals("&&") || name.equals("||")) &&
                            expression1.typeCheck(localVars, clazz).equals(Type.BOOLEAN)
            ) {
                type = expression1.typeCheck(localVars, clazz);
                return type;
            } else {
                throw new TypeMismatchException("Name does not match or expressions are from wrong Type");
            }
        } else {
            throw new TypeMismatchException("Binary Expression Types does not match");
        }

    }
}