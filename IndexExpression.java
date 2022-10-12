public class IndexExpression extends Expression {
    String id;
    Expression expression;
    public IndexExpression(String id, Expression expression) {
        this.id = id;
        this.expression = expression;
    }

    @Override
    public String toString(int t) {
        return printParams(t, id, "[", "(", expression.toString(0), ")", "]");
    }
}