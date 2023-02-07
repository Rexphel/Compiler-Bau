package compiler;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Block extends Statement {
    
    // TODO: Maybe compiler.Statement list/array?
    List<Statement> statement;

    public Block(List<Statement> statement) {
        this.statement = statement;
    }

    @Override
    public void codeGen() {
    }

    @Override
    public Type typeCheck(Map<String, Type> localVars, Clazz clazz) {
        List<Type> types = new ArrayList<>(List.of());
        statement.forEach(statement1 -> {
           Type typ1 = statement1.typeCheck(localVars, clazz);
           if (!typ1.equals(Type.VOID)) {
               types.add(typ1);
           }
       });
        if (!types.isEmpty()){
            type = types.get(0); //Todo Obermenge von Typen bilden? Prof fragen
        } else {
            type = Type.VOID;
        }
        return type;

    }


    

}
