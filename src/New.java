import org.objectweb.asm.MethodVisitor;

import java.util.List;
import java.util.Map;

public class New extends StmtExpr {

    //Is this even needed?
    Type type;
    List<Expression> expressionList; //parameter in constructor

    public New(Type type, List<Expression> expressionList) {
        this.type = type;
        this.expressionList = expressionList;
    }

    @Override
    public void codeGen(MethodVisitor method, Clazz clazz, List<LocalVarDecl> localVars) {
        //TODO: we only want to call the constructor of this class if possible
    }

    @Override
    public Type typeCheck(Map<String, Type> localVars, Clazz clazz) {
        //TODO: look if this is right
        if (expressionList.isEmpty()){
            return clazz.name;
        }else{
            throw new RuntimeException("to many arguments");
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
