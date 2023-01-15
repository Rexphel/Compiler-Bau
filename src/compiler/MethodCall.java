package compiler;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Vector;

public class MethodCall extends StmtExpr {

    Expression expression;
    String methodName;
    List<Expression> parameterList;

    public MethodCall(Expression expression, String methodName, List<Expression> parameterList) {
        super(null, null);
        this.expression = expression;
        this.methodName = methodName;
        this.parameterList = parameterList;
    }

    @Override
    public Type typeCheck(Map<String, Type> localVars, Vector<Clazz> classes) {
        var typeOfExpression = localVars.get(methodName);
        var clazzList = classes.stream().filter(clazz -> clazz.name.equals(typeOfExpression)).toList();
        if (clazzList.isEmpty()) {
            throw new RuntimeException("No Class found in MethodCall!");
        }
        var clazz = clazzList.get(0);
        return Arrays.stream(clazz.methodDecl)
                .filter(method -> method.name.equals(methodName))
                .map(method -> method.type)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("No Method found to call!"));
    }
}
