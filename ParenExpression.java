public class ParenExpression extends Expression {
    Expression expression;

    public ParenExpression(Expression expression) {
        this.expression = expression;
    }

    @Override
    public String toString(int t) {
        return printParams(t, "(", expression.toString(0), ")");
    }
}
