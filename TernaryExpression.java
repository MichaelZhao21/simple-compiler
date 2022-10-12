public class TernaryExpression extends Expression {
    Expression e1;
    Expression e2;
    Expression e3;

    public TernaryExpression(Expression e1, Expression e2, Expression e3) {
        this.e1 = e1;
        this.e2 = e2;
        this.e3 = e3;
    }

    @Override
    public String toString(int t) {
        return printParams(t, "(", "(", e1.toString(0), ")", "?", "(", e2.toString(0), ")", ":", "(", e3.toString(0), ")", ")");
    }
}
