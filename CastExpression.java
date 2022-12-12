public class CastExpression extends Expression {
    Type type;
    Expression expression;

    public CastExpression(Type type, Expression expression) {
        this.type = type;
        this.expression = expression;
    }

    @Override
    public String toString(int t) {
        return printParams(t, "(", type.toString(0), ")", "(", expression.toString(0), ")");
    }

    @Override
    public DataType getType() throws CompilerException {
        return new VariableDataType(type.type);
    }

    @Override
    public String typeCheck() throws CompilerException {
        return "Cast expression to " + getType().toString();
    }
}
