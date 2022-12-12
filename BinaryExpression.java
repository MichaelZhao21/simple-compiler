import java.util.Arrays;
import java.util.List;

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
        if (DataType.isMethodType(lhsRawType, rhsRawType)) {
            throw new CompilerException(String.format("Error: Cannot perform %s on %s and %s", op,
                    lhsRawType.toString(), rhsRawType.toString()));
        }
        VariableDataType lhsType = (VariableDataType) lhs.getType();
        lhsType.ignoreFinal = true;
        VariableDataType rhsType = (VariableDataType) rhs.getType();

        List<String> mathOps = Arrays.asList("+", "-", "*", "/");
        List<String> boolOps = Arrays.asList("||", "&&");

        // Check math ops
        if (mathOps.contains(op)) {
            // String concat
            if (op.equals("+") && ((lhsType.type.equals("string")))) {
                if (lhsType.equals(rhsType)) {
                    return new VariableDataType("string");
                }
                throw new CompilerException(
                        String.format("Error: cannot add types %s and %s", lhsType.toString(), rhsType.toString()));
            }
            if (op.equals("+") && (rhsType.type.equals("string"))) {
                if (rhsType.equals(lhsType)) {
                    return new VariableDataType("string");
                }
                throw new CompilerException(
                        String.format("Error: cannot add types %s and %s", lhsType.toString(), rhsType.toString()));
            }

            // Number ops
            if ((lhsType.type.equals("int") || lhsType.type.equals("float"))
                    && (rhsType.type.equals("int") || rhsType.type.equals("float"))) {
                if (lhsType.type.equals("float") || rhsType.type.equals("float")) {
                    return new VariableDataType("float");
                } else {
                    return new VariableDataType("int");
                }
            }
        } else if (boolOps.contains(op)) {
            // Check non math ops
            VariableDataType booleanType = new VariableDataType("boolean");
            if (booleanType.equals(lhsType) && booleanType.equals(rhsType)) {
                return new VariableDataType("boolean");
            }
            throw new CompilerException(
                    String.format("Error: cannot perform %s on types %s and %s", op, lhsType.toString(),
                            rhsType.toString()));
        } else {
            // Check comparison ops
            if ((lhsType.type.equals("int") || lhsType.type.equals("float"))
                    && (rhsType.type.equals("int") || rhsType.type.equals("float"))) {
                return new VariableDataType("boolean");
            }
        }

        throw new CompilerException(
                String.format("Error: Cannot perform %s on %s and %s", op, lhsType.type, rhsType.type));
    }
}
