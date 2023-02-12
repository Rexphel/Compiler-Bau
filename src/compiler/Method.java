package compiler;

import compiler.exception.TypeMismatchException;

import java.util.HashMap;
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
        MethodVisitor method = cw.visitMethod(
            Opcodes.ACC_PUBLIC, 
            name,
            getTypeSignature(),
                null,
                null);
        //TODO: add the parameters to a localvars list and pass it down the codeGen method

        method.visitCode();
        block.codeGen(method);
        method.visitMaxs(0, 0);
        method.visitEnd();
    }

    public String getTypeSignature(){
        StringBuilder signature = new StringBuilder("(");
        for (Type value : parameters.values()) {
            signature.append(value.getTypeLiteral());
        }
        signature.append(")");
        signature.append(this.type.getTypeLiteral());
        return signature.toString();
    }

    @Override
    public Type typeCheck(Map<String, Type> localVars, Clazz clazz) {
        Map<String, Type> methodVars = new HashMap<>(parameters);
        methodVars.putAll(localVars);
        if (block.typeCheck(methodVars, clazz).equals(type)) {
            return type;
        } else {
            throw new TypeMismatchException("Blocktype and function type missmatch");
        }
    }

    @Override
    public String toString() {
        return "Method{" +
                "name='" + name + '\'' +
                ",\n type=" + type +
                ",\n parameters=" + parameters +
                ",\n block=" + block +
                "\n}";
    }
}
