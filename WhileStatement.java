public class WhileStatement extends Statement {
    Expression condition;
    FieldList fieldList;
    StatementList statements;

    public WhileStatement(Expression condition, FieldList fieldList, StatementList statements) {
        this.condition = condition;
        this.fieldList = fieldList;
        this.statements = statements;
    }

    @Override
    public String toString(int t) {
        return printParams(0, "while ( (", condition.toString(0), ") ) {\n") +
                printParams("", t + 1, fieldList.toString(t + 1), statements.toString(t + 1), "\n", getTabs(t), "}");
    }
}
