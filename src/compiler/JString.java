package compiler;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import java.util.Map;

public class JString extends Expression {

    String str;

    public JString(String str) {
        this.str = str;
    }

    @Override
    public void codeGen(MethodVisitor method) {

    }

    @Override
    public Type typeCheck(Map<String, Type> localVars, Clazz clazz) {
        type = Type.STRING;
        return type;
    }
}
