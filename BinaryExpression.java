public class BinaryExpression extends Expression {
    Expression lhs;
    String op;
    Expression rhs;

    public BinaryExpression(Expression lhs, String op, Expression rhs) {
        this.lhs = lhs;
        this.op = op;
        this.rhs = rhs;
    }

    @Override
    public String toString(int t) {
        return printParams(t, "(", lhs.toString(0), ")", op, "(", rhs.toString(0), ")");
    }
}
