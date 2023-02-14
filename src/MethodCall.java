import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import java.util.ArrayList;
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
        method.visitMethodInsn(Opcodes.INVOKEVIRTUAL, clazz.name.type, methodName, methodSignature, false);

    }

    @Override
    public Type typeCheck(Map<String, Type> localVars, Clazz clazz) {
        if(!(objectExpr instanceof This || objectExpr.typeCheck(localVars, clazz).equals(clazz.name))){
            throw new TypeMismatchException("objectExpr does not math This or the Type of the class");
        }

        List<Method> methods = clazz.methodDecl.stream()
                .filter(method -> method.name
                        .equals(methodName)).toList();

        if (methods.isEmpty()) {
            throw new TypeMismatchException("no methods found");
        }
        List<Method> foundMethod = new ArrayList<>();
        //go over the list of methods
        for (int i = 0; i < methods.size(); i++) {
            Method methodz = methods.get(i);
            // check if we have the same amount of parameters
            if (methodz.parameters.size() == parameterList.size()) {
                // check if type of thw parameters are equal
                for (int j = 0; j < parameterList.size(); j++) {
                    //check if the parameters have the same type
                    if (!(methodz.parameters.get(i).type.equals(parameterList.get(i).typeCheck(localVars, clazz)))) {
                        break;
                    }
                    // add the method after we checked all parameters
                    if (j + 1 == methodz.parameters.size()) {
                        foundMethod.add(methodz);
                    } else throw new TypeMismatchException("hear we should not land");
                }
            }
        }
        //check if we found a method
        if (foundMethod.isEmpty()) {
            throw new TypeMismatchException("no methode with this name and parameters");
        } else return foundMethod.get(0).type;

        /*clazz.methodDecl.stream()
                .filter(method -> method.name.equals(methodName))
                .map(method -> method.type)
                .findFirst()
                .orElseThrow(() -> new TypeMismatchException("No Method found to call!"));*/
    }

    @Override
    public String toString() {
        return "MethodCall{" +
                "methodName='" + methodName + '\'' +
                ",\n parameterList=" + parameterList +
                "\n}";
    }
}
