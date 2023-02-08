package compiler;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import java.util.Map;

public class LocalVarDecl extends Statement {

    Expression initialValue;
    Type type;
    String name;

    public LocalVarDecl(Type type, String name) {
        this.type = type;
        this.name = name;
    }

    @Override
    public void codeGen(MethodVisitor method) {
        if (initialValue != null){
            int localIndex = 1; //TODO: get index from localVars
            initialValue.codeGen(method);
            method.visitVarInsn(Opcodes.ISTORE, localIndex); //TODO: we have more than Integer, what about Strings?
        }
    }

    @Override
    public Type typeCheck(Map<String, Type> localVars, Clazz clazz) {
        localVars.put(name, type);
        return type;
    }

    @Override
    public String toString() {
        return "LocalVarDecl{" +
                "type=" + type +
                ",\n name='" + name + '\'' +
                "\n}";
    }
}
