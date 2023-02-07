package compiler;

import org.objectweb.asm.MethodVisitor;

import java.util.Map;

public class Bool extends Expression {

    boolean bool;


    public Bool(boolean bool) {
        this.bool = bool;
    }

    @Override
    public void codeGen(MethodVisitor method) {
        //wahrscheinlich was mit ZCONST

    }

    @Override
    public Type typeCheck(Map<String, Type> localVars, Clazz clazz) {
        type = Type.BOOLEAN;
        return type;
    }
}
