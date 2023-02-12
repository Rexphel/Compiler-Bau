package compiler;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.objectweb.asm.*;

import static jdk.internal.org.objectweb.asm.Opcodes.ALOAD;
import static jdk.internal.org.objectweb.asm.Opcodes.INVOKESPECIAL;

public class Clazz implements TypedParserObject {

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

    public void codeGen() {
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
                field.initialValue.codeGen(constructor);
                constructor.visitFieldInsn(Opcodes.PUTFIELD, this.name.type, field.name, field.type.getTypeLiteral() );
            }
        }

        // wenn in FieldDecl statt nur field auch assign stehen kann müssen hier im Konstructor die Initialwerte geladen werden
        constructor.visitInsn(Opcodes.RETURN);
        constructor.visitMaxs(0,0);
        constructor.visitEnd();

        //methods
        for(Method m : methodDecl) {
            m.codeGen(cw);
        }


        cw.visitEnd();

    }

    // TODO: Set clazz in general main of compiler, not here. (Maybe)
    @Override
    public Type typeCheck(Map<String, Type> localVars, Clazz clazz) {

        // TODO: Differentiate between localVars and clazz's fieldDecl

        clazz = this;
        List<TypedParserObject> l = new ArrayList<>(fieldDecl);
        l.addAll(methodDecl);
        Clazz finalClazz = clazz; // IntelliJ wants it that way
        l.forEach(obj -> obj.typeCheck(localVars, finalClazz));
        return Type.VOID;
//        type = Type.VOID;
//        return type;
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