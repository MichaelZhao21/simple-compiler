public class IfStatement extends Statement {
    Expression condition;
    FieldList fieldList;
    StatementList statements;
    ElseClause elseClause;

    public IfStatement(Expression condition, FieldList fieldList, StatementList statements, ElseClause elseClause) {
        this.condition = condition;
        this.fieldList = fieldList;
        this.statements = statements;
        this.elseClause = elseClause;
    }

    @Override
    public String toString(int t) {
        return printParams(0, "if ( (", condition.toString(0), ") ) {\n")
                + printParams("", t + 1, fieldList.toString(t + 1), statements.toString(t + 1), "\n", getTabs(t), "}", elseClause.toString(t));
    }
}
