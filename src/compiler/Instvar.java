package compiler;

import compiler.exception.TypeMismatchException;

import java.util.*;

public class Instvar extends Expression {
    
    Expression expression;
    String name;

    
    public Instvar(Expression expression, String name) {
        super(null);
        this.expression = expression;
        this.name = name;
    }
    @Override
    public Type typeCheck(Map<String, Type> localVars, Vector<Clazz> classes) {
        if(!classes.isEmpty()) {
            Optional<Clazz> foundClass = classes.stream()
                    .filter(
                            clazz -> expression.typeCheck(localVars, classes).equals(clazz.name)
                    ).findFirst();
            if(foundClass.isPresent()){
                Field[] fields = foundClass.get().fieldDecl;
                List<Field> namedField = Arrays.stream(fields).filter(field -> field.name.equals(name)).toList();
                boolean isNameFound = !namedField.isEmpty();
                if(isNameFound) {
                    type = namedField.get(0).type;
                    return type;
                } else {
                    throw new RuntimeException("Field "+name+" not found.");
                }
            }else{
                throw new RuntimeException("No suitable Class for Field "+name+" found!");
            }
        }else{
            throw new RuntimeException("Class does not exist");
        }
    }
}
