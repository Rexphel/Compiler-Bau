package compiler;

import java.util.List;
import java.util.Map;

public class MethodCall extends StmtExpr {

    Expression expression;
    String methodName;
    List<Expression> parameterList;

    public MethodCall(Expression expression, String methodName, List<Expression> parameterList) {
        super((Expression) null);
        this.expression = expression;
        this.methodName = methodName;
        this.parameterList = parameterList;
    }

    @Override
    public void codeGen() {

    }

    @Override
    public Type typeCheck(Map<String, Type> localVars, Clazz clazz) {
        // TODO: Put Parameters in localVars
        parameterList.forEach(x -> localVars.put("ABC" /*TODO NAME*/, x.type));

        return clazz.methodDecl.stream()
                .filter(method -> method.name.equals(methodName))
                .map(method -> method.type)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("No Method found to call!"));
    }
}
