import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import java.util.List;
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
        if ((initialValue.typeCheck(localVars, clazz).equals(type)) || initialValue == null) {
            localVars.put(name, type);
            return type;
        } else {
            throw new RuntimeException("initial Value does not equal type");
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
