public class Parameter extends Token {
    Type type;
    Name id;
    boolean isArray;

    public Parameter(Type type, Name id, boolean isArray) {
        this.type = type;
        this.id = id;
        this.isArray = isArray;
    }

    @Override
    public String toString(int t) {
        return printParams(t, type.toString(0), id.toString(0) + (isArray ? " [ ]" : ""));
    }

    @Override
    public DataType getType() throws CompilerException {
        return new VariableDataType(type.type, false, isArray);
    }
}
