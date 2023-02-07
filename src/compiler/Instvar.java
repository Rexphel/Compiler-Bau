package compiler;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import java.util.List;
import java.util.Map;

public class Instvar extends Expression {

    Expression expression;
    String name;


    public Instvar(Expression expression, String name) {
        this.expression = expression;
        this.name = name;
    }

    @Override
    public void codeGen(MethodVisitor method) {
        //TODO: we probably only call an Instvar with "this", then it is gonna be a GETFIELD instruction (insn)
    }

    @Override
    public Type typeCheck(Map<String, Type> localVars, Clazz clazz) {
        List<Field> fields = clazz.fieldDecl;
        List<Field> namedField = fields.stream().filter(field -> field.name.equals(name)).toList();
        boolean isNameFound = !namedField.isEmpty();
        if (isNameFound) {
            type = namedField.get(0).type;
            return type;
        } else {
            throw new RuntimeException("Field " + name + " not found.");
        }
    }
}
