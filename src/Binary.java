import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import java.util.List;
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
    public void codeGen(MethodVisitor method, Clazz clazz, List<LocalVarDecl> localVars) {
        // TODO: we can not compare booleans with <,>,>=,<= also calculate Frames (visitFrame)

        int opcode = 0;

        switch (name) {
            case "==" -> opcode = Opcodes.IF_ICMPNE;
            case "!=" -> opcode = Opcodes.IF_ICMPEQ;
            case "<" -> opcode = Opcodes.IF_ICMPGE;
            case ">" -> opcode = Opcodes.IF_ICMPLE;
            case "<=" -> opcode = Opcodes.IF_ICMPGT;
            case ">=" -> opcode = Opcodes.IF_ICMPLT;
        }

        if (opcode != 0) {
            expression1.codeGen(method, clazz, localVars);
            expression2.codeGen(method, clazz, localVars);
            Label falseLabel = new Label();
            Label endLabel = new Label();
            method.visitJumpInsn(opcode, falseLabel);
            method.visitFrame(Opcodes.F_SAME, 0, null, 0, null);
            method.visitInsn(Opcodes.ICONST_1);

            method.visitJumpInsn(Opcodes.GOTO, endLabel);

            method.visitLabel(falseLabel);
            method.visitFrame(Opcodes.F_SAME, 0, null, 0, null);
            method.visitInsn(Opcodes.ICONST_0);

            method.visitLabel(endLabel);
        }

        switch (name) {
            case "&&" -> opcode = Opcodes.IFEQ;
            case "||" -> opcode = Opcodes.IFNE;
        }
        if (this.type.type.equals("boolean")) {
            Label trueLabel = new Label();
            Label falseLabel = new Label();
            //load first
            if (opcode == Opcodes.IFEQ) {
                expression1.codeGen(method, clazz, localVars);
                method.visitJumpInsn(Opcodes.IFEQ, falseLabel);
                expression2.codeGen(method, clazz, localVars);
                method.visitJumpInsn(Opcodes.IFEQ, falseLabel);
                method.visitJumpInsn(Opcodes.GOTO, trueLabel);
            } else {
                expression1.codeGen(method, clazz, localVars);
                method.visitJumpInsn(Opcodes.IFNE, trueLabel);
                expression2.codeGen(method, clazz, localVars);
                method.visitJumpInsn(Opcodes.IFNE, trueLabel);
                method.visitJumpInsn(Opcodes.GOTO, falseLabel);
            }
            Label endLabel = new Label();
            method.visitLabel(trueLabel);
            method.visitFrame(Opcodes.F_SAME, 0, null, 0, null);
            method.visitInsn(Opcodes.ICONST_1);

            method.visitJumpInsn(Opcodes.GOTO, endLabel);

            method.visitLabel(falseLabel);
            method.visitFrame(Opcodes.F_SAME, 0, null, 0, null);
            method.visitInsn(Opcodes.ICONST_0);

            method.visitLabel(endLabel);
        }

        if (this.type.type.equals("int")) {
            expression1.codeGen(method, clazz, localVars);
            expression2.codeGen(method, clazz, localVars);
            switch (name) {
                case "+" -> method.visitInsn(Opcodes.IADD);
                case "-" -> method.visitInsn(Opcodes.ISUB);
                case "*" -> method.visitInsn(Opcodes.IMUL);
                case "%" -> method.visitInsn(Opcodes.IREM);
            }
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
            } else if ("-*%/".contains(name) &&
                    expression1.typeCheck(localVars, clazz).equals(Type.INTEGER)) {
                type = expression1.typeCheck(localVars, clazz);
                return type;
            } else if (
                    (name.equals("&&") || name.equals("||")) &&
                            expression1.typeCheck(localVars, clazz).equals(Type.BOOLEAN)
            ) {
                type = expression1.typeCheck(localVars, clazz);
                return type;
            } else if (name.equals("==") || name.equals("!=")) {
                if (expression1.typeCheck(localVars, clazz).equals(expression2.typeCheck(localVars, clazz))) {
                    return Type.BOOLEAN;
                } else {
                    throw new TypeMismatchException("Types of Expressions does not match");
                }

            } else if (name.equals("<") || name.equals(">") || name.equals("<=") || name.equals(">=")) {
                if (expression1.typeCheck(localVars, clazz).equals(Type.BOOLEAN) || expression2.typeCheck(localVars, clazz).equals(Type.BOOLEAN)) {
                    throw new TypeMismatchException("can not use this binary with boolean");
                }
                if (expression1.typeCheck(localVars, clazz).equals(expression2.typeCheck(localVars, clazz))) {
                    return Type.BOOLEAN;
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