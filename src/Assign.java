import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import java.util.List;
import java.util.Map;

public class Assign extends StmtExpr {

    LocalOrFieldVar var;
    Expression expression;

    public Assign(LocalOrFieldVar var, Expression expression) {
        this.var = var;
        this.expression = expression;
    }

    @Override
    public void codeGen(MethodVisitor method, Clazz clazz, List<LocalVarDecl> localVars) {
        //either way a PutField on this or a VarInsn(xSTORE)
        List<LocalVarDecl> local = localVars.stream().filter(localVarDecl -> localVarDecl.name.equals(var.name)).toList();
        List<Field> field = clazz.fieldDecl.stream().filter(field1 -> field1.name.equals(var.name)).toList();
        if (!local.isEmpty()){
            int localIndex = localVars.indexOf(local.get(0));
            localVars.indexOf(local.stream().findFirst().get());
            expression.codeGen(method, clazz, localVars);
            if (expression.type.isObjectType()){
                method.visitVarInsn(Opcodes.ASTORE, localIndex);
            } else {
                method.visitVarInsn(Opcodes.ISTORE, localIndex);
            } 
        } else if (!field.isEmpty()){
            method.visitVarInsn(Opcodes.ALOAD, 0);
            expression.codeGen(method, clazz, localVars);
            method.visitFieldInsn(Opcodes.PUTFIELD, clazz.name.type, var.name, expression.type.getTypeLiteral());
        }
    }

    @Override
    public Type typeCheck(Map<String, Type> localVars, Clazz clazz) {
        if (var.typeCheck(localVars, clazz).equals(expression.typeCheck(localVars, clazz))) {
            type = expression.typeCheck(localVars, clazz);
            return type;
        } else {
            throw new TypeMismatchException("VarType and expression Type mismatch");
        }
    }

    @Override
    public String toString() {
        return "Assign{" +
                "varName='" + var.name + "'" +
                ",\n expression=" + expression + "\n}";
    }
}
