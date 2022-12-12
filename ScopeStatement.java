import java.util.List;

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
        return printParams("", 0, "{\n", getTabs(t + 1), fieldList.toString(t + 1), statementList.toString(t + 1), "\n",
                getTabs(t), "}", semi ? " ;" : "", "\n");
    }

    @Override
    public String typeCheck() throws CompilerException {
        symbolTable.startScope();

        String fieldCheck = fieldList.typeCheck();
        String statementCheck = statementList.typeCheck();

        symbolTable.endScope();

        return String.format("Defined scoped statement: \n\t%s\n\t%s", fieldCheck, statementCheck);
    }

    @Override
    public List<DataType> getReturnTypes() throws CompilerException {
        return statementList.getReturnTypes();
    }
}
