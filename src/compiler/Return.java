package compiler;

import java.util.Map;

public class Return extends Statement {
    
    Expression expression;


    public Return(Expression expression) {
        this.expression = expression;
    }

    @Override
    public void codeGen() {

    }

    @Override
    public Type typeCheck(Map<String, Type> localVars, Clazz clazz) {
        type = expression.typeCheck(localVars, clazz);
        return type;
    }
}
