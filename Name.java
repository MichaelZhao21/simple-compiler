public class Name extends Expression {
    String id;
    Expression expression;
    public Name(String id, Expression expression) {
        this.id = id;
        this.expression = expression;
    }

    public Name(String id) {
        this.id = id;
        this.expression = null;
    }

    @Override
    public String toString(int t) {
        if (expression == null)
            return printParams("", t, id);
        return printParams(t, id, "[", "(", expression.toString(0), ")", "]");
    }
}