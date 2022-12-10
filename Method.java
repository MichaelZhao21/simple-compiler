public class Method extends Decleration {
    Type returnType;
    Name id;
    ParameterList parameterList;
    FieldList fieldList;
    StatementList statementList;
    boolean semi;

    public Method(Type returnType, Name id, FunctionList parameterList, FieldList fieldList, StatementList statementList,
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
                + printParams("", t + 1, fieldList.toString(t + 1), statementList.toString(t + 1), "\n", getTabs(t), "}", semi ? " ;" : "");
    }

    @Override
    public String typeCheck() throws CompilerException {
        symbolTable.addMethod(id.id, parameterList, returnType.type);
        symbolTable.startScope();
        String paramCheck = parameterList.typeCheck();
        String fieldCheck = fieldList.typeCheck();
        String statementCheck = statementList.typeCheck();
        symbolTable.endScope();
        return String.format("Defined method %s(%s):\n\t%s\n\t%s", id.toString(0), paramCheck, fieldCheck, statementCheck);
    }
}
