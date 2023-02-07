package compiler;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.objectweb.asm.*;

import static jdk.internal.org.objectweb.asm.Opcodes.ALOAD;
import static jdk.internal.org.objectweb.asm.Opcodes.INVOKESPECIAL;

public class Clazz extends Statement {

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


    @Override
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
            f.codeGen();
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

        // wenn in FieldDecl statt nur field auch assign stehen kann müssen hier im Konstructor die Initialwerte geladen werden
        constructor.visitInsn(Opcodes.RETURN);
        constructor.visitMaxs(0,0);
        constructor.visitEnd();

        //methods
        for(Method m : methodDecl) {
            m.codeGen();
        }


        cw.visitEnd();

    }

    // TODO: Set clazz in general main of compiler, not here.
    @Override
    public Type typeCheck(Map<String, Type> localVars, Clazz clazz) {
        List<TypedParserObject> l = new ArrayList<>(fieldDecl);
        l.addAll(methodDecl);
        l.forEach(obj -> obj.typeCheck(localVars, clazz));
        type = Type.VOID;
        return type;
    }

}