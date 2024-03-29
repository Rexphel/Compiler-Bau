import org.objectweb.asm.*;

import java.util.List;
import java.util.Map;

public class New extends StmtExpr {

    Type type;
    List<Expression> expressionList; //parameter in constructor

    public New(Type type, List<Expression> expressionList) {
        this.type = type;
        this.expressionList = expressionList;
    }

    @Override
    public void codeGen(MethodVisitor method, Clazz clazz, List<LocalVarDecl> localVars) {
        method.visitTypeInsn(Opcodes.NEW, clazz.name.type);
        method.visitInsn(Opcodes.DUP);
        method.visitMethodInsn(Opcodes.INVOKESPECIAL, clazz.name.type, "<init>", "()V", false );
    }

    @Override
    public Type typeCheck(Map<String, Type> localVars, Clazz clazz) {
        if (expressionList.isEmpty()){
            type = clazz.name;
            return type;
        }else{
            throw new TypeMismatchException("to many arguments");
        }
    }

    @Override
    public String toString() {
        return "New{" +
                "type=" + type +
                ",\n expressionList=" + expressionList +
                "\n}";
    }
}
