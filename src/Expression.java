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
    public Type typeCheck(Map<String, Type> localVars, Vector<Class> classes) {
        return null;
    }
    


}
