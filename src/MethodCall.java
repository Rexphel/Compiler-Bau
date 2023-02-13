import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import java.util.List;
import java.util.Map;

public class MethodCall extends StmtExpr {

    Expression objectExpr;
    String methodName;
    List<Expression> parameterList;

    public MethodCall(Expression expression, String methodName, List<Expression> parameterList) {
        this.objectExpr = expression;
        this.methodName = methodName;
        this.parameterList = parameterList;
    }



    @Override
    public void codeGen(MethodVisitor method, Clazz clazz, List<LocalVarDecl> localVars) {
        //objectExpr should always be this, therefore:
        objectExpr.codeGen(method, clazz, localVars);

        for (Expression expression : parameterList) {
            expression.codeGen(method, clazz, localVars);
        }
        List<Method> methods = clazz.methodDecl.stream().filter(method1 -> method1.name.equals(methodName)).toList();
        String methodSignature = methods.get(0).getTypeSignature();
        method.visitMethodInsn(Opcodes.INVOKEVIRTUAL, clazz.name.type, methodName, methodSignature, false );

    }

    @Override
    public Type typeCheck(Map<String, Type> localVars, Clazz clazz) {
        // TODO: objectExpr darf nur this sein und Parametertype checken





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
