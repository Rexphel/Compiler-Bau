package compiler;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import java.util.Map;

public class Return extends Statement {

    Expression expression;


    public Return(Expression expression) {
        this.expression = expression;
    }

    @Override
    public Type typeCheck(Map<String, Type> localVars, Clazz clazz) {
        type = expression.typeCheck(localVars, clazz);
        return type;
    }

    @Override
    public void codeGen(MethodVisitor method) {

        int returnCode = switch (type.getTypeLiteral()) {
            case "Z", "C", "I" -> Opcodes.IRETURN;
            case "V" -> Opcodes.RETURN;
            default -> Opcodes.ARETURN;
        };
        method.visitInsn(returnCode);
    }

    @Override
    public String toString() {
        return "Return{" +
                "\nexpression=" + expression +
                "\n}";
    }
}
