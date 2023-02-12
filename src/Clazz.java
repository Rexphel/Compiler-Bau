import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.*;

import static org.objectweb.asm.Opcodes.ALOAD;
import static org.objectweb.asm.Opcodes.INVOKESPECIAL;

public class Clazz {

    Type name;
    //Field[] fieldDecl;
    //Method[] methodDecl;
    List<Field> fieldDecl;
    List<Method> methodDecl;


    public Clazz(String statement, Type name, List<Field> fieldDecl, List<Method> methodDecl) {
        this.name = name;
        this.fieldDecl = fieldDecl;
        this.methodDecl = methodDecl;
    }

    public byte[] codeGen() {
        //we probably want to instantiate the cw in the Main class
        ClassWriter cw = new ClassWriter( ClassWriter.COMPUTE_FRAMES | ClassWriter.COMPUTE_MAXS);
        cw. visit(
                Opcodes.V1_8,
                Opcodes.ACC_PUBLIC,
                name.type,
                null,
                "java/lang/Object",
                null);

        for (Field f : fieldDecl){
            // cw.visitField(...);
            f.codeGen(cw);
        }

        //constructor
        MethodVisitor constructor = cw. visitMethod(
                Opcodes.ACC_PUBLIC,
                "<init>",
                "()V",
                null,
                null);

        constructor.visitCode();
        constructor.visitVarInsn(ALOAD, 0);
        constructor.visitMethodInsn(INVOKESPECIAL, "java/lang/Object", "<init>", "()V", false);

        for (Field field : fieldDecl) {
            if (field.initialValue != null){
                constructor.visitVarInsn(Opcodes.ALOAD, 0);
                field.initialValue.codeGen(constructor, this, new ArrayList<>());
                constructor.visitFieldInsn(Opcodes.PUTFIELD, this.name.type, field.name, field.type.getTypeLiteral() );
            }
        }

        // wenn in FieldDecl statt nur field auch assign stehen kann müssen hier im Konstructor die Initialwerte geladen werden
        constructor.visitInsn(Opcodes.RETURN);
        constructor.visitMaxs(0,0);
        constructor.visitEnd();

        //methods
        for(Method m : methodDecl) {
            m.codeGen(cw, this);
        }


        cw.visitEnd();

        return cw.toByteArray();

    }

    public Type typeCheck() {

        List<TypedParserObject> l = new ArrayList<>(fieldDecl);
        l.addAll(methodDecl);// IntelliJ wants it that way
        l.forEach(obj -> obj.typeCheck(new HashMap<>(), this));
        return Type.VOID;
    }

    @Override
    public String toString() {
        return "Clazz{" +
                "name=" + name +
                ",\n fieldDecl=" + fieldDecl +
                ",\n methodDecl=" + methodDecl +
                "\n}";
    }
}