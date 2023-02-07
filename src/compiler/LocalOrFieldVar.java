package compiler;

import java.util.Map;
import java.util.Set;
import java.util.Vector;
import java.util.stream.Collectors;

public class LocalOrFieldVar extends Expression {
    
    String name;

    public LocalOrFieldVar(String name) {
        super(null);
        this.name = name;
    }

    @Override
    public Type typeCheck(Map<String, Type> localVars, Vector<Clazz> classes) {
        Set<Map.Entry<String,Type>> set = localVars.entrySet().stream().filter(stringTypeEntry -> stringTypeEntry.getKey().equals(name)).collect(Collectors.toSet());
        if(set.isEmpty()){
            throw new RuntimeException("no Variable found") ;
        } else {
            type = localVars.get(name);
            return type;
        }
    }
}
