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
            method.visitFieldInsn(Opcodes.GETFIELD, clazz.name.type, name, null); // TODO descriptor
        } else if (expression instanceof Super) {
            // TODO
        }else {
            // we do not want to handle any other expression!
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
