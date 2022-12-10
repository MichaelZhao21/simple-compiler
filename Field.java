public class Field extends Decleration {
    Type type;
    Name id;
    Expression expression;
    boolean hasFinal;

    public Field(Type type, Name id, boolean hasFinal) {
        this.type = type;
        this.id = id;
        this.expression = null;
        this.hasFinal = hasFinal;
    }

    public Field(Type type, Name id, Expression expression, boolean hasFinal) {
        this.type = type;
        this.id = id;
        this.expression = expression;
        this.hasFinal = hasFinal;
    }

    @Override
    public String toString(int t) {
        return printParams(0, hasFinal ? "final " : "" + type.toString(0), id.toString(0),
                expression == null ? ";" : "= " + expression.toString(0) + " ;");
    }

    @Override
    public String typeCheck() throws CompilerException {
        symbolTable.addVariable(id.id, type.type, hasFinal, id.number != null);
        if (expression == null) {
            return "Created " + id.id;
        }

        VariableDataType expressionType = (VariableDataType) expression.getType();
        VariableDataType variableType = new VariableDataType(type.type, true);
        if (!variableType.equals(expressionType)) {
            throw new CompilerException(String.format("Error: Cannot assign %s to %s (%s)", expressionType.type,
                    id.toString(0), type.type));
        }
        return "Field " + id.id + " = " + expressionType.type;
    }
}
