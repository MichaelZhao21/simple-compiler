public class WhileStatement extends Statement {
    Expression condition;
    StatementList statements;

    public WhileStatement(Expression condition, StatementList statements) {
        this.condition = condition;
        this.statements = statements;
    }

    @Override
    public String toString(int t) {
        return printParams(0, "while ( (", condition.toString(0), ") ) {\n") +
                printParams("", 0, statements.toString(t + 1), "\n", getTabs(t), "}");
    }
}
