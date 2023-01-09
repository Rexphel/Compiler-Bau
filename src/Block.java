import java.util.Map;
import java.util.Vector;

public class Block extends Statement {
    
    // TODO: Maybe Statement list/array?
    Statement statement;

    public Block(Statement statement) {
        super(null);
        this.statement = statement;
    }

    @Override
    public void codeGen() {
    }

    @Override
    public Type typeCheck(Map<String, Type> localVars, Vector<Class> classes) {
        return null;
    }

    

}
