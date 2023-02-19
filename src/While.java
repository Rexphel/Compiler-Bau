import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import java.util.List;
import java.util.Map;

public class While extends Statement {

    Expression expression;
    Statement statement;


    public While(Expression expression, Statement statement) {
        this.expression = expression;
        this.statement = statement;
    }

    @Override
    public void codeGen(MethodVisitor method, Clazz clazz, List<LocalVarDecl> localVars) {
        Label startLabel = new Label();
        Label endLabel = new Label();
        method.visitLabel(startLabel);
        expression.codeGen(method, clazz, localVars);
        method.visitJumpInsn(Opcodes.IFEQ,endLabel);
        statement.codeGen(method, clazz, localVars);
        method.visitJumpInsn(Opcodes.GOTO, startLabel);
        method.visitLabel(endLabel);
    }

    @Override
    public Type typeCheck(Map<String, Type> localVars, Clazz clazz) {
        if (expression.typeCheck(localVars, clazz).equals(Type.BOOLEAN)) {
            type = statement.typeCheck(localVars, clazz);
            return type;
        } else {
            throw new TypeMismatchException("expression Type does not match boolean");
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