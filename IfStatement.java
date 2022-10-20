public class IfStatement extends Statement {
    Expression condition;
    StatementList statements;
    ElseClause elseClause;

    public IfStatement(Expression condition, StatementList statements, ElseClause elseClause) {
        this.condition = condition;
        this.statements = statements;
        this.elseClause = elseClause;
    }

    @Override
    public String toString(int t) {
        return printParams(0, "if ( (", condition.toString(0), ") ) {\n") +
                printParams("", 0, statements.toString(t + 1), "\n", getTabs(t), "}", elseClause.toString(t));
    }
}
