public class ParenExpression extends Expression {
    Expression expression;

    public ParenExpression(Expression expression) {
        this.expression = expression;
    }

    @Override
    public String toString(int t) {
        return printParams(t, "(", expression.toString(0), ")");
    }

    @Override
    public DataType getType() throws CompilerException {
        return expression.getType();
    }

    @Override
    public String typeCheck() throws CompilerException {
        return expression.typeCheck();
    }
}
