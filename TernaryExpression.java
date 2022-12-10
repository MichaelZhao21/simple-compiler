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
        return printParams(t, "(", "(", e1.toString(0), ")", "?", "(", e2.toString(0), ")", ":", "(", e3.toString(0),
                ")", ")");
    }

    @Override
    public DataType getType() throws CompilerException {
        VariableDataType condType = DataType.getVariableType(e1.getType(),
                "Error: Invalid ternary condition type: " + e1.getType().toString());
        VariableDataType boolType = new VariableDataType("boolean", true);
        if (!boolType.equals(condType)) {
            throw new CompilerException("Error: invalid ternary condition type: " + condType.toString());
        }
        String error = String.format("Error: Invalid ternary expression with types %s and %s", e2.getType().toString(),
                e3.getType().toString());
        VariableDataType trueExprType = DataType.getVariableType(e2.getType(), error);
        VariableDataType falseExprType = DataType.getVariableType(e3.getType(), error);
        if (!trueExprType.equals(falseExprType)) {
            throw new CompilerException(error);
        }
        return trueExprType;
    }

    @Override
    public String typeCheck() throws CompilerException {
        return String.format("Ternary Expression %s -> %s", e1.getType().toString(), getType().toString());
    }
}
