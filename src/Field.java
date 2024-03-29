import org.objectweb.asm.*;

import java.util.Map;
import java.util.List;

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

    public void generateInit(MethodVisitor constructor, Clazz clazz, List<LocalVarDecl> noLocalVars){
        if(initialValue != null){
            constructor.visitVarInsn(Opcodes.ALOAD, 0);
            initialValue.codeGen(constructor, clazz, noLocalVars);
            constructor.visitFieldInsn(Opcodes.PUTFIELD, clazz.name.type, name, type.getTypeLiteral());
        }
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
            throw new TypeMismatchException("Field already exists");
        }
        if (initialValue == null ||  initialValue.typeCheck(localVars, clazz).equals(type) || (type.isObjectType() && initialValue instanceof JNull) ) {
            return type;
        } else {
            throw new TypeMismatchException("Initial value does not equal type");
        }
    }

    @Override
    public String toString() {
        return "Field{" +
                "name='" + name + '\'' +
                ",\n type=" + type +
                ",\n initialvalue=" + initialValue +
                "\n}";
    }
}
