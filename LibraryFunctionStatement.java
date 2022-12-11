import java.util.List;

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
        for (DataType rawType : argsType.typeList) {
            VariableDataType type = DataType.getVariableType(rawType,
                    "Error: cannot call " + function + " with argument " + rawType.toString());
            if (function.equals("print") || function.equals("printline")) {
                if (type.isArray || type.type.equals("void")) {
                    throw new CompilerException("Error: cannot call print with argument " + type.toString());
                }
            } else if (function.equals("read")) {
                if (type.isArray || type.isFinal) {
                    throw new CompilerException("Error: cannot call read with the argument" + type.toString());
                }
            }
        }
        return "Called function " + function + " with args: " + argsType.toString();
    }

    @Override
    public List<DataType> getReturnTypes() throws CompilerException {
        return null;
    }
}
