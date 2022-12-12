import java.util.List;

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

    @Override
    public String typeCheck() throws CompilerException {
        VariableDataType condType = DataType.getVariableType(condition.getType(),
                "Error: While conditional cannot be type " + condition.getType().toString());
        VariableDataType booleanType = new VariableDataType("boolean", true);
        if (!booleanType.equals(condType)) {
            throw new CompilerException("Error: While conditional cannot be type " + condType.toString());
        }
        String statementTypeCheck = statements.typeCheck();
        return "While statement: " + statementTypeCheck;
    }

    @Override
    public List<DataType> getReturnTypes() throws CompilerException {
        return statements.getReturnTypes();
    }
}
