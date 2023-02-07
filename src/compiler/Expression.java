package compiler;

import java.util.Map;
import java.util.Vector;

public class Expression implements TypedParserObject {

    Expression expression; // ?

    public Expression(Expression expression) {
        this.expression = expression;
    }

    @Override
    public void codeGen() {
        
    }

    @Override
    public Type typeCheck(Map<String, Type> localVars, Vector<Clazz> classes) {
        System.out.println("This should not happen. (Tried to typecheck Expression object)");
        return null;
    }
}
