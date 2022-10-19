public class ElseClause extends Token {
    StatementList statements;

    public ElseClause(StatementList statements) {
        this.statements = statements;
    }

    public ElseClause() {
        this.statements = null;
    }

    @Override
    public String toString(int t) {
        if (statements == null)
            return "";
        return printParams("", 0, " else {\n", statements.toString(t + 1), "\n", getTabs(t), "}");
    }
}
