package compiler;

import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

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
        Label endLabel = new Label();
        method.visitLabel(startLabel);
        expression.codeGen(method);
        // expression has to load true/false with that we can jump or not by comparing the result to true (we probably want to compare to some ICONST, Booleans are Objects...
        //InvokeVirtual Boolean "booleanValue" "()Z"
        method.visitJumpInsn(Opcodes.IFNE,endLabel);
        statement.codeGen(method);
        method.visitJumpInsn(Opcodes.GOTO, startLabel);
        method.visitLabel(endLabel);
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

    @Override
    public String toString() {
        return "While{" +
                "\nexpression=" + expression +
                ",\n statement=" + statement +
                "\n}";
    }
}