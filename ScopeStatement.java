public class ScopeStatement extends Statement {
    StatementList statementList;
    boolean semi;

    public ScopeStatement(StatementList statementList, boolean semi) {
        this.statementList = statementList;
        this.semi = semi;
    }

    @Override
    public String toString(int t) {
        return printParams("", 0, "{\n", statementList.toString(t + 1), "\n", getTabs(t), "}", semi ? " ;" : "", "\n");
    }
}
