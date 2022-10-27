public class Method extends Token {
    Type returnType;
    Name id;
    ArgumentList argumentList;
    FieldList fieldList;
    StatementList statementList;
    boolean semi;

    public Method(Type returnType, Name id, ArgumentList argumentList, FieldList fieldList, StatementList statementList,
            boolean semi) {
        this.returnType = returnType;
        this.id = id;
        this.argumentList = argumentList;
        this.fieldList = fieldList;
        this.statementList = statementList;
        this.semi = semi;
    }

    @Override
    public String toString(int t) {
        return printParams(t, returnType.toString(0), id.toString(0), "(", argumentList.toString(0), ") {\n",
                fieldList.toString(0), statementList.toString(0))
                + printParams("", t, "\n", getTabs(t), "}", semi ? " ;" : "", "\n");
    }
}
