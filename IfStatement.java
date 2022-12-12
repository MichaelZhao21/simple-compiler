import java.util.List;

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
                + printParams("", t + 1, fieldList.toString(t + 1), statements.toString(t + 1), "\n", getTabs(t), "}",
                        elseClause.toString(t));
    }

    @Override
    public String typeCheck() throws CompilerException {
        VariableDataType condType = DataType.getVariableType(condition.getType(),
                "Error: If conditional cannot be type " + condition.getType().toString());
        VariableDataType booleanType = new VariableDataType("boolean", true);
        if (!booleanType.equals(condType)) {
            throw new CompilerException("Error: If conditional cannot be type " + condType.toString());
        }
        String statementTypeCheck = statements.typeCheck();
        return "If statement: " + statementTypeCheck;
    }

    @Override
    public List<DataType> getReturnTypes() throws CompilerException {
        List<DataType> returnTypes = statements.getReturnTypes();
        returnTypes.addAll(elseClause.getReturnTypes());
        return returnTypes;
    }
}
