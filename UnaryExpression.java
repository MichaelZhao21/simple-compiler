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
        VariableDataType type = DataType.getVariableType(expression.getType(),
                String.format("Error: Cannot perform %s on %s", op, expression.getType().toString()));
        CompilerException error = new CompilerException(
                String.format("Error: Cannot perform %s on %s", op, type.toString()));

        // ~ op
        if (op.equals("~")) {
            VariableDataType booleanDataType = new VariableDataType("boolean", true);
            if (!booleanDataType.equals(type))
                throw error;
            return type;
        }

        // + and - op
        VariableDataType floatDataType = new VariableDataType("float", true);
        if (!floatDataType.equals(type))
            throw error;
        return type;
    }

    @Override
    public String typeCheck() throws CompilerException {
        return String.format("Performed %s on %s (result = %s)", op, expression.getType().toString(),
                getType().toString());
    }
}
