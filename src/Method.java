import java.util.*;
import org.objectweb.asm.*;

public class Method implements TypedParserObject {
    
    String name;
    Type type;
    List<LocalVarDecl> parameters;
    Statement block;


    public Method(String name, Type type, List<LocalVarDecl> parameters, Statement block) {
        this.name = name;
        this.type = type;
        this.parameters = parameters;
        this.block = block;
    }


    public void codeGen(ClassWriter cw, Clazz clazz) {
        MethodVisitor method = cw.visitMethod(
            Opcodes.ACC_PUBLIC, 
            name,
            getTypeSignature(),
                null,
                null);
        List<LocalVarDecl> localVars = new ArrayList<>();
        localVars.add(new LocalVarDecl(Type.VOID, "this", null));
        localVars.addAll(parameters);

        method.visitCode();
        block.codeGen(method, clazz, localVars);

        if (type.equals(Type.VOID)){
            method.visitInsn(Opcodes.RETURN);
        }
        method.visitMaxs(0, 0);
        method.visitEnd();
    }

    public String getTypeSignature(){
        StringBuilder signature = new StringBuilder("(");
        parameters.stream().map(x -> x.type.getTypeLiteral()).forEach(signature::append);
        signature.append(")");
        signature.append(this.type.getTypeLiteral());
        return signature.toString();
    }

    @Override
    public Type typeCheck(Map<String, Type> localVars, Clazz clazz) {
        Map<String, Type> methodVars = new HashMap<>();
        parameters.forEach(x -> methodVars.put(x.name, x.type));
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
