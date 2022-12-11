import java.util.List;
import java.util.LinkedList;

public class StatementList extends Token {
    List<Statement> statements;

    public StatementList() {
        statements = new LinkedList<>();
    }

    public StatementList prepend(Statement s) {
        statements.add(0, s);
        return this;
    }

    @Override
    public String toString(int t) {
        return printParams(0, printLineList(statements, t));
    }

    @Override
    public String typeCheck() throws CompilerException {
        StringBuilder sb = new StringBuilder("Statements:\n");
        for (Statement s : statements) {
            sb.append("\t\t").append(s.typeCheck()).append("\n");
        }
        return sb.toString();
    }

    public List<DataType> getReturnTypes() throws CompilerException {
        List<DataType> returnTypes = new LinkedList<>();
        for (Statement s : statements) {
            List<DataType> ret = s.getReturnTypes();
            if (ret != null) {
                returnTypes.addAll(ret);
            }
        }
        return returnTypes;
    }
}
