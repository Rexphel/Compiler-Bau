import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import java.util.List;
import java.util.Map;

public class If extends Statement {

    Expression condition;
    Statement statement; // IF
    Statement maybeStatement; // Nicht in UML

    public If(Expression condition, Statement statement, Statement mayStatement) {
        this.condition = condition;
        this.statement = statement;
        this.maybeStatement = mayStatement;
    }

    @Override
    public void codeGen(MethodVisitor method, Clazz clazz, List<LocalVarDecl> localVars) {
        Label elseLabel = new Label();
        Label endLabel = new Label();
        condition.codeGen(method, clazz, localVars);
        // ifblock
        method.visitJumpInsn(Opcodes.IFEQ, elseLabel);
        statement.codeGen(method, clazz, localVars);
        method.visitJumpInsn(Opcodes.GOTO, endLabel);
        // else block
        method.visitLabel(elseLabel);
        if (maybeStatement != null)
            maybeStatement.codeGen(method, clazz, localVars);
        method.visitLabel(endLabel);

    }

    @Override
    public Type typeCheck(Map<String, Type> localVars, Clazz clazz) {
        if (condition.typeCheck(localVars, clazz).equals(Type.BOOLEAN)){
            if( maybeStatement == null || statement.typeCheck(localVars, clazz).equals(maybeStatement.typeCheck(localVars, clazz)))
            {
                type = statement.typeCheck(localVars, clazz);
                return type;
            }else throw new TypeMismatchException("If Statement types do not match");
        }else {
            throw new TypeMismatchException("condition is not a boolean");
        }
    }

    @Override
    public String toString() {
        return "If{\n" +
                "condition=" + condition +
                ",\n statement=" + statement +
                ",\n maybeStatement=" + maybeStatement +
                "\n}";
    }
}