package compiler;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.MethodVisitor;

import java.util.Map;

public class Field implements TypedParserObject {

    String name;
    Type type;


    public Field(String name, Type type) {
        this.name = name;
        this.type = type;
    }



    public void codeGen(ClassWriter cw) {
        FieldVisitor field = cw.visitField(0, name, "todo: class name", null, null);
        field.visitEnd();
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
        return type;
    }


}
