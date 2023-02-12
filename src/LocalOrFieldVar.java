import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
        if (true /*is LocalVar*/) {
            int localIndex = 1; //TODO: get index from localvars List
            method.visitVarInsn(Opcodes.ILOAD, localIndex);
        } else if (true /*is Field*/) {

        }
    }

    @Override
    public Type typeCheck(Map<String, Type> localVars, Clazz clazz) {
        type = localVars.get(name);
        if (type == null) {
            List<Field> fieldVars = clazz.fieldDecl.stream().filter(item -> item.name.equals(name)).toList();
            if (fieldVars.isEmpty()) {
                throw new RuntimeException("Fieldvar is not found");
            } else {
                //Typ von ersten gefundenen Variablen
                return type = fieldVars.stream().findFirst().get().type;
            }
        } else {
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
