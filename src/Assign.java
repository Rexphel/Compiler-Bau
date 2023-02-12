import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import java.util.Map;

public class Assign extends StmtExpr {

    String varName; // ?TODO: Remove
    LocalOrFieldVar var; // TODO Make this an expression
    Expression expression;

    public Assign(LocalOrFieldVar var, Expression expression) {
        this.var = var;
        this.expression = expression;
    }

    @Override
    public void codeGen(MethodVisitor method) {
        //either way a PutField on this or a VarInsn(xSTORE)
        //TODO: we need the localvars and the current Clazz for this.

        if (true /*isLocalVar*/){
            int localIndex = 1; // TODO: 1 is minimum, 0 is this (get from localvars List)
            expression.codeGen(method);
            method.visitVarInsn(Opcodes.ISTORE, localIndex);
        } else if (true /*isField*/){
            method.visitVarInsn(Opcodes.ALOAD, 0);
            expression.codeGen(method);
            method.visitFieldInsn(Opcodes.PUTFIELD, ""/*TODO: classname here*/, varName, expression.type.getTypeLiteral());
        }
    }

    @Override
    public Type typeCheck(Map<String, Type> localVars, Clazz clazz) {
        if (var.typeCheck(localVars, clazz).equals(expression.typeCheck(localVars, clazz))) {
            type = expression.typeCheck(localVars, clazz);
            return type;
        } else {
            throw new RuntimeException("VarType and expression Type mismatch");
        }
    }

    @Override
    public String toString() {
        return "Assign{" +
                "varName='" + varName + "'" +
                ",\n expression=" + expression + "\n}";
    }
}
