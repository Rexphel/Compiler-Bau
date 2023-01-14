package compiler;

public class Binary extends Expression {

    String name;
    Expression expression1;
    Expression expression2;


    public Binary(String name, Expression expression1, Expression expression2) {
        super(null);
        this.name = name;
        this.expression1 = expression1;
        this.expression2 = expression2;
    }


}