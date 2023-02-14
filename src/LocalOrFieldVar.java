import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import java.util.List;
import java.util.Map;

public class LocalOrFieldVar extends Expression {

    String name;

    public LocalOrFieldVar(String name) {
        this.name = name;
    }

    @Override
    public void codeGen(MethodVisitor method, Clazz clazz, List<LocalVarDecl> localVars) {
        List<LocalVarDecl> local = localVars.stream().filter(localVarDecl -> localVarDecl.name.equals(name)).toList();
        List<Field> field = clazz.fieldDecl.stream().filter(field1 -> field1.name.equals(name)).toList();
        if (!local.isEmpty()) {
            int localIndex = localVars.indexOf(local.get(0));
            method.visitVarInsn(Opcodes.ILOAD, localIndex);
        } else if (!field.isEmpty()) {
            System.out.println("getfield with" +Opcodes.GETFIELD + " " + clazz.name.type + " " + name + " " + field.get(0).type.getTypeLiteral());
            method.visitVarInsn(Opcodes.ALOAD, 0);
            method.visitFieldInsn(Opcodes.GETFIELD, clazz.name.type, name, field.get(0).type.getTypeLiteral());
        }
    }

    @Override
    public Type typeCheck(Map<String, Type> localVars, Clazz clazz) {
        type = localVars.get(name);
        if (type == null) {
            List<Field> fieldVars = clazz.fieldDecl.stream().filter(item -> item.name.equals(name)).toList();
            if (fieldVars.isEmpty()) {
                throw new TypeMismatchException("Fieldvar is not found");
            } else {
                //Typ von ersten gefundenen Variablen
                return type = fieldVars.stream().findFirst().get().type;
            }
        } else {
            return type;
        }
    }

    @Override
    public String toString() {
        return "LocalOrFieldVar{" +
                "name='" + name + '\'' +
                '}';
    }
}
