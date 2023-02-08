package compiler;

import compiler.exception.TypeMismatchException;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

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
        if (name.equals("-")){
            method.visitInsn(Opcodes.INEG);
        }
        else if (name.equals("!")){
            //TODO: we may have to do something with visitFrame here, because of the jump
            Label endLabel = new Label();
            Label falseLabel = new Label();
            method.visitJumpInsn(Opcodes.IFNE, falseLabel);
            method.visitInsn(Opcodes.ICONST_1);
            method.visitLabel(falseLabel);
            method.visitInsn(Opcodes.ICONST_0);
            method.visitLabel(endLabel);
        }
        //unary operation
    }

    @Override
    public Type typeCheck(Map<String, Type> localVars, Clazz clazz) {
        //TODO: look into this again
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

    @Override
    public String toString() {
        return "Unary{" +
                "\nname='" + name + '\'' +
                ",\n expression=" + expression +
                "\n}";
    }
}
