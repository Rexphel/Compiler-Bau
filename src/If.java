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
        // TODO: this has to be tested! Can work like this. Problem: return inside the if-Block, few Labels could be unnecessary then.
        method.visitJumpInsn(Opcodes.IFEQ, elseLabel);
        statement.codeGen(method, clazz, localVars);
        method.visitJumpInsn(Opcodes.GOTO, endLabel);
        // else block
        method.visitLabel(elseLabel);
        maybeStatement.codeGen(method, clazz, localVars);
        method.visitLabel(endLabel);

    }

    @Override
    public Type typeCheck(Map<String, Type> localVars, Clazz clazz) {
        if (condition.typeCheck(localVars, clazz).equals(Type.BOOLEAN)){
            if(statement.typeCheck(localVars, clazz).equals(maybeStatement.typeCheck(localVars, clazz)) || maybeStatement == null)
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