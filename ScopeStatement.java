public class ScopeStatement extends Statement {
    FieldList fieldList;
    StatementList statementList;
    boolean semi;

    public ScopeStatement(FieldList fieldList, StatementList statementList, boolean semi) {
        this.fieldList = fieldList;
        this.statementList = statementList;
        this.semi = semi;
    }

    @Override
    public String toString(int t) {
        return printParams("", 0, "{\n", fieldList.toString(t + 1), statementList.toString(t + 1), "\n", getTabs(t), "}", semi ? " ;" : "", "\n");
    }
}
