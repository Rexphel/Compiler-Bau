import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import java.util.List;
import java.util.Map;

public class Unary extends Expression {

    String name;
    Expression expression;


    public Unary(String name, Expression expression) {
        this.name = name;
        this.expression = expression;
    }

    @Override
    public void codeGen(MethodVisitor method, Clazz clazz, List<LocalVarDecl> localVars) {
        expression.codeGen(method, clazz, localVars);
        if (name.equals("-")){
            method.visitInsn(Opcodes.INEG);
        }
        else if (name.equals("!")){
            Label endLabel = new Label();
            Label falseLabel = new Label();
            method.visitJumpInsn(Opcodes.IFNE, falseLabel);
            method.visitFrame(Opcodes.F_SAME, 0, null, 0, null);
            method.visitInsn(Opcodes.ICONST_1);
            method.visitJumpInsn(Opcodes.GOTO, endLabel);
            method.visitLabel(falseLabel);
            method.visitFrame(Opcodes.F_SAME, 0, null, 0, null);
            method.visitInsn(Opcodes.ICONST_0);
            method.visitLabel(endLabel);
            method.visitFrame(Opcodes.F_SAME, 0, null, 1, new Object[] {Opcodes.INTEGER});
        }
    }

    @Override
    public Type typeCheck(Map<String, Type> localVars, Clazz clazz) {
        if (expression.typeCheck(localVars, clazz).equals(Type.INTEGER)
                && "+-".contains(name)) {
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
