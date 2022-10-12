public class UnaryExpression extends Expression {
    String op;
    Expression expression;

    public UnaryExpression(String op, Expression expression) {
        this.op = op;
        this.expression = expression;
    }

    @Override
    public String toString(int t) {
        return printParams(t, op, "(", expression.toString(0), ")");
    }
}
