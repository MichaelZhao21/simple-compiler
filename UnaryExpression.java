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

    @Override
    public DataType getType() throws CompilerException {
        DataType rawExprType = expression.getType();
        if (rawExprType instanceof MethodDataType) {
            throw new CompilerException(String.format("Error: Cannot perform %s on %s", op, rawExprType.toString()));
        }
        VariableDataType exprType = (VariableDataType) expression.getType();
        if (exprType.type != "int" && exprType.type != "float") {
            throw new CompilerException(String.format("Error: Cannot perform %s on %s", op, exprType.type));
        }
        return exprType;
    }

    @Override
    public String typeCheck() throws CompilerException {
        return op + ": " + getType().toString() + " " + expression.toString(0);
    }
}
