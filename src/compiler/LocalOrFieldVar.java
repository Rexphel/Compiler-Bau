package compiler;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class LocalOrFieldVar extends Expression {

    String name;

    public LocalOrFieldVar(String name) {
        this.name = name;
    }

    @Override
    public void codeGen(MethodVisitor method) {
        //TODO: here we need the localvars,
        //suche nach field -> GETFIELD
        // ansonsten aload ?
        if (true /*is LocalVar*/){
            int localIndex = 1; //TODO: get index from localvars List
            method.visitVarInsn(Opcodes.ILOAD, localIndex);
        } else if (true /*is Field*/){

        }
    }

    @Override
    public Type typeCheck(Map<String, Type> localVars, Clazz clazz) {
        Set<Map.Entry<String, Type>> set = localVars.entrySet().stream().filter(stringTypeEntry -> stringTypeEntry.getKey().equals(name)).collect(Collectors.toSet());
        if (set.isEmpty()) {
            throw new RuntimeException("no Variable found");
        } else {
            type = localVars.get(name);
            return type;
        }
    }

    @Override
    public String toString() {
        return "LocalOrFieldVar{" +
                "name='" + name + '\'' +
                '}';
    }
}
