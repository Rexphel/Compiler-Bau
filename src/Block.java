import org.objectweb.asm.MethodVisitor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Block extends Statement {

    List<Statement> statements;

    public Block(List<Statement> statement) {
        this.statements = statement;
    }

    @Override
    public void codeGen(MethodVisitor method) {
        for (Statement statement : statements) {
            statement.codeGen(method);
        }

    }

    @Override
    public Type typeCheck(Map<String, Type> localVars, Clazz clazz) {
        List<Type> types = new ArrayList<>(List.of());
        statements.forEach(statement1 -> {
            Type typ1 = statement1.typeCheck(localVars, clazz);
            if (!typ1.equals(Type.VOID)) {
                types.add(typ1);
            }
        });
        if (!types.isEmpty()) {
            type = types.get(0); //Todo Obermenge von Typen bilden? Prof fragen
        } else {
            type = Type.VOID;
        }
        return type;

    }

    @Override
    public String toString() {
        return "Block{\n" +
                "statements=" + statements + "\n"+
                '}';
    }
}
