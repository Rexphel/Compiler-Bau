package compiler;

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
    public void codeGen() {

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
