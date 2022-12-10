public abstract class DataType {
    public static boolean isMethodType(DataType... typeList) {
        for (DataType type : typeList) {
            if (type instanceof MethodDataType)
                return true;
        }
        return false;
    }

    public static VariableDataType getVariableType(DataType type, String err) throws CompilerException {
        if (type instanceof MethodDataType || type instanceof ListDataType) {
            throw new CompilerException(err);
        }
        return (VariableDataType) type;
    }
}