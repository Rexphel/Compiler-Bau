public class Unary extends Expression {
    
    String name;
    Expression expression;


    public Unary(String name, Expression expression) {
        super(null);
        this.name = name;
        this.expression = expression;
    }


}
