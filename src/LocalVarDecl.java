import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import java.util.List;
import java.util.Map;

public class LocalVarDecl extends Statement {

    Expression initialValue;
    Type type;
    String name;

    public LocalVarDecl(Type type, String name, Expression initialValue) {
        this.type = type;
        this.name = name;
        this.initialValue = initialValue;
    }

    @Override
    public void codeGen(MethodVisitor method, Clazz clazz, List<LocalVarDecl> localVars) {
        localVars.add(this);
        if (initialValue != null){
            int localIndex = localVars.size() -1;
            initialValue.codeGen(method, clazz, localVars);
            method.visitVarInsn(Opcodes.ISTORE, localIndex); // TODO: we have more than Integer, what about Strings? -ASTORE
        }
    }

    @Override
    public Type typeCheck(Map<String, Type> localVars, Clazz clazz) {
        if ((initialValue == null || initialValue.typeCheck(localVars, clazz).equals(type))) {
            localVars.put(name, type);
            return Type.VOID;   //watch out! Don't know if VOID is realy true here (before : type)
        } else {
            throw new TypeMismatchException("initial Value does not equal type");
        }
    }

    @Override
    public String toString() {
        return "LocalVarDecl{" +
                "type=" + type +
                ",\n name='" + name + '\'' +
                "\n}";
    }
}
