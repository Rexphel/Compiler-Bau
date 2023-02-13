import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.FieldVisitor;

import java.util.Map;

public class Field implements TypedParserObject {

    String name;
    Type type;
    Expression initialValue;


    public Field(String name, Type type, Expression initialValue) {
        this.name = name;
        this.type = type;
        this.initialValue = initialValue;
    }


    public void codeGen(ClassWriter cw) {
        FieldVisitor field = cw.visitField(0, name, type.getTypeLiteral(), null, null);
        field.visitEnd();
        //initialValue is handled by the constructor in Clazz
    }


    @Override
    public Type typeCheck(Map<String, Type> localVars, Clazz clazz) {
        boolean b = false;
        for (int i = 0; i < localVars.size(); i++) {
            if (localVars.keySet().toArray()[i].equals(name)) {
                b = true;
                break;
            }
        }
        if (b) {
            throw new RuntimeException("Field already exists");
        }
        if (initialValue.typeCheck(localVars, clazz).equals(type)|| initialValue == null) {
            return type;
        } else {
            throw new RuntimeException("Initial value does not equal type");
        }
    }

    @Override
    public String toString() {
        return "Field{" +
                "name='" + name + '\'' +
                ",\n type=" + type +
                "\n}";
    }
}
