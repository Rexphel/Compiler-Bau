import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import java.util.List;
import java.util.Map;

public class InstVar extends Expression {

    Expression expression;
    String name;


    public InstVar(Expression expression, String name) {
        this.expression = expression;
        this.name = name;
    }

    @Override
    public void codeGen(MethodVisitor method, Clazz clazz, List<LocalVarDecl> localVars) {
        if (expression instanceof This){
            List<Field> fields = clazz.fieldDecl.stream().filter(field -> field.name.equals(name)).toList();
            method.visitVarInsn(Opcodes.ALOAD, 0);
            method.visitFieldInsn(Opcodes.GETFIELD, clazz.name.type, name, fields.get(0).type.getTypeLiteral());
        } else if (expression instanceof LocalOrFieldVar){
            List<Field> fields = clazz.fieldDecl.stream().filter(field -> field.name.equals(name)).toList();
            expression.codeGen(method, clazz, localVars);
            method.visitFieldInsn(Opcodes.GETFIELD, clazz.name.type, name, fields.get(0).type.getTypeLiteral());
        }
    }

    @Override
    public Type typeCheck(Map<String, Type> localVars, Clazz clazz) {
        if(!(expression instanceof This || expression.typeCheck(localVars, clazz).equals(clazz.name))){
            throw new TypeMismatchException("objectExpr does not math This or the Type of the class");
        }
        List<Field> fields = clazz.fieldDecl;
        List<Field> namedField = fields.stream().filter(field -> field.name.equals(name)).toList();
        boolean isNameFound = !namedField.isEmpty();
        if (isNameFound) {
            type = namedField.get(0).type;
            return type;
        } else {
            throw new TypeMismatchException("Field " + name + " not found.");
        }
    }

    @Override
    public String toString() {
        return "Instvar{" +
                "name='" + name + '\'' +
                ",\n expression=" + expression +
                "\n}";
    }
}
