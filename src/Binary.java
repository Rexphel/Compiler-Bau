import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

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
        // TODO: we want another if branch before, where the different compare operations are handled

        // this should be the else branch then
        if (this.type.type.equals("int")) {
            expression1.codeGen(method);
            expression2.codeGen(method);
            switch (name) {
                case "+" -> method.visitInsn(Opcodes.IADD);
                case "-" -> method.visitInsn(Opcodes.ISUB);
                case "*" -> method.visitInsn(Opcodes.IMUL);
                case "%" -> method.visitInsn(Opcodes.IREM);
            }
        }
        if (this.type.type.equals("boolean")) {
            Label trueLabel = new Label();
            Label falseLabel = new Label();
            //load first
            switch (name) {
                case "&&" -> {
                    expression1.codeGen(method);
                    method.visitJumpInsn(Opcodes.IFEQ, falseLabel);
                    expression2.codeGen(method);
                    method.visitJumpInsn(Opcodes.IFEQ, falseLabel);
                    method.visitJumpInsn(Opcodes.GOTO, trueLabel);
                }
                case "||" -> {
                    expression1.codeGen(method);
                    method.visitJumpInsn(Opcodes.IFNE, trueLabel);
                    expression2.codeGen(method);
                    method.visitJumpInsn(Opcodes.IFNE, trueLabel);
                    method.visitJumpInsn(Opcodes.GOTO, falseLabel);
                }
            }
            Label endLabel = new Label();
            method.visitLabel(trueLabel);
            method.visitInsn(Opcodes.ICONST_1);

            method.visitJumpInsn(Opcodes.GOTO, endLabel);

            method.visitLabel(falseLabel);
            method.visitInsn(Opcodes.ICONST_0);

            method.visitLabel(endLabel);
        }
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
            } else if (name.equals("==") || name.equals("!=") || name.equals("<") || name.equals(">") || name.equals("<=") || name.equals(">=")) {
                if (expression1.typeCheck(localVars, clazz).equals(expression2.typeCheck(localVars, clazz))) {
                    type = expression1.typeCheck(localVars, clazz);
                    return type;
                } else {
                    throw new TypeMismatchException("Types of Expressions does not match");
                }

            } else {
                throw new TypeMismatchException("Name does not match or expressions are from wrong Type");
            }
        } else {
            throw new TypeMismatchException("Binary Expression Types does not match");
        }

    }

    @Override
    public String toString() {
        return "Binary{" +
                "name='" + name + '\'' +
                ",\n expression1=" + expression1 +
                ",\n expression2=" + expression2 +
                "\n}";
    }
}