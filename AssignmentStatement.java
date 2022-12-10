public class AssignmentStatement extends Statement {
    Name name;
    Expression expression;

    public AssignmentStatement(Expression name, Expression expression) {
        this.name = (Name) name;
        this.expression = expression;
    }

    @Override
    public String toString(int t) {
        return printParams(0, name.toString(0), "=", "(", expression.toString(0), ") ;");
    }

    @Override
    public String typeCheck() throws CompilerException {
        DataType lhsType = symbolTable.get(name.id);
        DataType rhsType = expression.getType();
        if (!lhsType.equals(rhsType)) {
            throw new CompilerException(String.format("Error: assignment of %s to %s", rhsType, lhsType));
        }
        return "Assigned " + rhsType.toString() + " to " + lhsType.toString();
    }
}
