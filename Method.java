import java.util.List;

public class Method extends Decleration {
    Type returnType;
    Name id;
    ParameterList parameterList;
    FieldList fieldList;
    StatementList statementList;
    boolean semi;

    public Method(Type returnType, Name id, FunctionList parameterList, FieldList fieldList,
            StatementList statementList,
            boolean semi) {
        this.returnType = returnType;
        this.id = id;
        this.parameterList = (ParameterList) parameterList;
        this.fieldList = fieldList;
        this.statementList = statementList;
        this.semi = semi;
    }

    @Override
    public String toString(int t) {
        return printParams(0, returnType.toString(0), id.toString(0), "(", parameterList.toString(0), ") {\n")
                + printParams("", t + 1, fieldList.toString(t + 1), statementList.toString(t + 1), "\n", getTabs(t),
                        "}", semi ? " ;" : "");
    }

    @Override
    public String typeCheck() throws CompilerException {
        MethodDataType thisType = symbolTable.addMethod(id.id, parameterList, returnType.type);
        symbolTable.startScope();

        String paramCheck = parameterList.typeCheck();
        for (Parameter p : parameterList.parameterList) {
            symbolTable.addVariable(p.id.id, p.type.type, false, p.isArray);
        }

        String fieldCheck = fieldList.typeCheck();
        String statementCheck = statementList.typeCheck();

        List<DataType> returnTypes = statementList.getReturnTypes();
        VariableDataType actualReturnType = new VariableDataType(returnType.type, true);
        if (!returnType.type.equals("void")) {
            if (returnTypes.size() == 0) {
                throw new CompilerException("Error: Missing return statement for method " + thisType.toString());
            }
            for (DataType t : returnTypes) {
                VariableDataType r = DataType.getVariableType(t, "Error: Cannot return method type " + t.toString());
                if (!actualReturnType.equals(r)) {
                    throw new CompilerException(
                            String.format("Error: Cannot return %s for method %s", r.toString(), thisType.toString()));
                }
            }
        }

        symbolTable.endScope();
        return String.format("Defined method %s(%s):\n\t%s\n\t%s", id.toString(0), paramCheck, fieldCheck,
                statementCheck);
    }
}
