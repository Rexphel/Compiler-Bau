public class Instvar extends Expression {
    
    Expression expression;
    String name;


    public Instvar(Expression expression, String name) {
        super(null);
        this.expression = expression;
        this.name = name;
    }


}
