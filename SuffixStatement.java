import java.util.List;

public class SuffixStatement extends Statement {
    Name name;
    String op;

    public SuffixStatement(Name name, String op) {
        this.name = name;
        this.op = op;
    }

    @Override
    public String toString(int t) {
        return printParams(0, name.toString(0), op, ";");
    }

    @Override
    public DataType getType() throws CompilerException {
        VariableDataType type = DataType.getVariableType(name.getType(),
                String.format("Error: Cannot perform %s on %s", op, name.getType().toString()));
        if (type.type != "int" && type.type != "float") {
            throw new CompilerException(String.format("Error: Cannot perform %s on %s", op, type.toString()));
        } else if (type.isFinal) {
            throw new CompilerException(String.format("Error: Cannot perform %s on final %s", op, type.toString()));
        }
        return type;
    }

    @Override
    public String typeCheck() throws CompilerException {
        return op + ": " + getType().toString() + " " + name.toString(0);
    }

    @Override
    public List<DataType> getReturnTypes() throws CompilerException {
        return null;
    }
}
