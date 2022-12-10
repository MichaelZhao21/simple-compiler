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
        DataType rawNameType = name.getType();
        if (rawNameType instanceof MethodDataType) {
            throw new CompilerException(String.format("Error: Cannot perform %s on %s", op, rawNameType.toString()));
        }
        VariableDataType nameType = (VariableDataType) rawNameType;
        if (nameType.type != "int" && nameType.type != "float") {
            throw new CompilerException(String.format("Error: Cannot perform %s on %s", op, nameType.toString()));
        } else if (nameType.isFinal) {
            throw new CompilerException(String.format("Error: Cannot perform %s on final %s", op, nameType.toString()));
        }
        return nameType;
    }

    @Override
    public String typeCheck() throws CompilerException {
        return op + ": " + getType().toString() + " " + name.toString(0);
    }
}
