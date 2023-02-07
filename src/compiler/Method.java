package compiler;

import compiler.exception.TypeMismatchException;

import java.util.Map;
import org.objectweb.asm.*;

public class Method implements TypedParserObject {
    
    String name;
    Type type;
    Map<String, Type> parameters;
    Statement block;


    public Method(String name, Type type, Map<String, Type> parameters, Statement block) {
        this.name = name;
        this.type = type;
        this.parameters = parameters;
        this.block = block;
    }


    public void codeGen(ClassWriter cw) {
        StringBuilder parameterString = new StringBuilder();
        for (Type value : parameters.values()) {
            parameterString.append(value.getTypeLiteral());
        }
        MethodVisitor method = cw.visitMethod(
            Opcodes.ACC_PUBLIC, 
            name,
            "(" + parameterString + ")" + type.getTypeLiteral(),
                null,
                null);
        //labels here if needed - probably not

        method.visitCode();
        block.codeGen(method);
        method.visitMaxs(0, 0);
        method.visitEnd();
    }

    @Override
    public Type typeCheck(Map<String, Type> localVars, Clazz clazz) {
        //TODO: update local vars with the parameters
        if (block.typeCheck(localVars, clazz).equals(type)) {
            return type;
        } else {
            throw new TypeMismatchException("Blocktype and function type missmatch");
        }//Todo delete local variables from Map  - how about using a copy of the map instead of passing the same map down?
    }


}
