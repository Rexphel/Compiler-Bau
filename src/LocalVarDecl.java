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
            if(initialValue.type.isObjectType()){
                method.visitVarInsn(Opcodes.ASTORE, localIndex);
            }else {
                method.visitVarInsn(Opcodes.ISTORE, localIndex);
            } 
        }
    }

    @Override
    public Type typeCheck(Map<String, Type> localVars, Clazz clazz) {
        if ((initialValue.typeCheck(localVars, clazz).equals(type)) || initialValue == null) {
            localVars.put(name, type);
            return Type.VOID;   
        } else {
            throw new RuntimeException("initial Value does not equal type");
        }
    }

    @Override
    public String toString() {
        return "LocalVarDecl{" +
                "type=" + type +
                ",\n name='" + name + '\'' +
                ",\n initialvalue='" + initialValue + '\'' +
                "\n}";
    }
}
