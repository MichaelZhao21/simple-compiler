public class BinaryExpression extends Expression {
    Expression lhs;
    String op;
    Expression rhs;

    public BinaryExpression(Expression lhs, String op, Expression rhs) {
        this.lhs = lhs;
        this.op = op;
        this.rhs = rhs;
    }

    @Override
    public String toString(int t) {
        return printParams(t, "(", lhs.toString(0), ")", op, "(", rhs.toString(0), ")");
    }

    @Override
    public DataType getType() throws CompilerException {
        DataType lhsRawType = lhs.getType();
        DataType rhsRawType = rhs.getType();
        if (!(lhsRawType instanceof VariableDataType) || !(rhsRawType instanceof VariableDataType)) {
            throw new CompilerException(String.format("Error: Cannot perform %s on %s and %s", op, lhsRawType.toString(), rhsRawType.toString()));
        }
        VariableDataType lhsType = (VariableDataType) lhs.getType();
        VariableDataType rhsType = (VariableDataType) rhs.getType();

        if ((lhsType.type.equals("int") || lhsType.type.equals("float"))
                && (rhsType.type.equals("int") || rhsType.type.equals("float"))) {
            if (lhsType.type.equals("float") || rhsType.type.equals("float")) {
                return new VariableDataType("float");
            } else {
                return new VariableDataType("int");
            }
        }

        throw new CompilerException(String.format("Error: Cannot perform %s on %s and %s", op, lhsType.type, rhsType.type));
    }
}
