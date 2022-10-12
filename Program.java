public class Program extends Token {
    private Expression expression;

    public Program(Expression expression) {
        this.expression = expression;
    }

    @Override
    public String toString(int t) {
        return String.format("Program:\n%s\n", expression.toString(t + 1));
    }
}
