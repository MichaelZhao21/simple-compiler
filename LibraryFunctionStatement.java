public class LibraryFunctionStatement extends Statement {
    String function;
    FunctionList list;

    public LibraryFunctionStatement(String function, FunctionList list) {
        this.function = function;
        this.list = list;
    }

    @Override
    public String toString(int t) {
        return printParams(0, function, "(", list.toString(0), ") ;");
    }

    @Override
    public String typeCheck() throws CompilerException {
        ListDataType argsType = (ListDataType) list.getType();
        for (DataType type : argsType.typeList) {
            if (type instanceof MethodDataType) {
                throw new CompilerException("Error: cannot call " + function + " with argument " + type.toString());
            }
            VariableDataType varType = (VariableDataType) type;
            if (function.equals("print") || function.equals("printline")) {
                if (varType.isArray || varType.type.equals("void")) {
                    throw new CompilerException("Error: cannot call print with argument " + varType.toString());
                }
            } else if (function.equals("read")) {
                if (varType.isArray || varType.isFinal) {
                    throw new CompilerException("Error: cannot call read with the argument" + varType.toString());
                }
            }
        }
        return "Called function " + function + " with args: " + argsType.toString();
    }
}
