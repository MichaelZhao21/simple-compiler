public class CallExpression extends Expression {
    String id;
    FunctionList argumentList;

    public CallExpression(String id) {
        this.id = id;
        this.argumentList = new PrintList();
    }

    public CallExpression(String id, FunctionList argumentList) {
        this.id = id;
        this.argumentList = argumentList;
    }

    @Override
    public String toString(int t) {
        return printParams(t, id, "(", argumentList.toString(0), ")");
    }

    @Override
    public DataType getType() throws CompilerException {
        DataType rawMethodType = symbolTable.get(id);
        if (!DataType.isMethodType(rawMethodType)) {
            throw new CompilerException(String.format("Error: %s is not a callable method", rawMethodType.toString()));
        }
        MethodDataType methodType = (MethodDataType) rawMethodType;
        if (!methodType.paramTypeList.equals(argumentList.getType())) {
            throw new CompilerException(String.format("Error: arugment list (%s) does not match parameter list (%s)",
                    argumentList.toString(), methodType.paramTypeList.toString()));
        }
        return new VariableDataType(methodType.returnType);
    }

    @Override
    public String typeCheck() throws CompilerException {
        return "Called method " + id + " with return type " + getType();
    }
}
