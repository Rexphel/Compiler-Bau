package ast;

public class LocalVarDecl extends Statement {
    
    Type type;
    String name;


    public LocalVarDecl(Type type, String name) {
        super(null);
        this.type = type;
        this.name = name;
    }

    

}
