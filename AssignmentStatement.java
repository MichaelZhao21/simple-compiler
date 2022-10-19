public class AssignmentStatement extends Statement {
    Expression name;
    Expression expression;

    public AssignmentStatement(Expression name, Expression expression) {
        this.name = name;
        this.expression = expression;
    }

    @Override
    public String toString(int t) {
        return printParams(0, name.toString(0), "=", "(", expression.toString(0), ") ;");
    }
}
