package compiler;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import java.util.List;
import java.util.Map;

public class MethodCall extends StmtExpr {

    Expression objectExpr;
    String methodName;
    List<Expression> parameterList;

    public MethodCall( String methodName, List<Expression> parameterList) {
        this.methodName = methodName;
        this.parameterList = parameterList;
    }



    @Override
    public void codeGen(MethodVisitor method) {
        //objectExpr should always be this, therefore:
        objectExpr.codeGen(method);

        for (Expression expression : parameterList) {
            expression.codeGen(method);
        }
        method.visitMethodInsn(Opcodes.INVOKEVIRTUAL, ""/*TODO class name*/, methodName, ""/*todo: with clazz and methodname get methodSignature (getMethodSignature)*/, false );

    }

    @Override
    public Type typeCheck(Map<String, Type> localVars, Clazz clazz) {
        return clazz.methodDecl.stream()
                .filter(method -> method.name.equals(methodName))
                .map(method -> method.type)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("No Method found to call!"));
    }

    @Override
    public String toString() {
        return "MethodCall{" +
                "methodName='" + methodName + '\'' +
                ",\n parameterList=" + parameterList +
                "\n}";
    }
}
