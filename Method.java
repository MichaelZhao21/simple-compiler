public class Method extends Decleration {
    Type returnType;
    Name id;
    FunctionList parameterList;
    FieldList fieldList;
    StatementList statementList;
    boolean semi;

    public Method(Type returnType, Name id, FunctionList parameterList, FieldList fieldList, StatementList statementList,
            boolean semi) {
        this.returnType = returnType;
        this.id = id;
        this.parameterList = parameterList;
        this.fieldList = fieldList;
        this.statementList = statementList;
        this.semi = semi;
    }

    @Override
    public String toString(int t) {
        return printParams(0, returnType.toString(0), id.toString(0), "(", parameterList.toString(0), ") {\n")
                + printParams("", t + 1, fieldList.toString(t + 1), statementList.toString(t + 1), "\n", getTabs(t), "}", semi ? " ;" : "");
    }
}
