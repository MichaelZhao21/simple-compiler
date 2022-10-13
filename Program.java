public class Program extends Token {
    private StatementList statements;

    public Program(StatementList statements) {
        this.statements = statements;
    }

    @Override
    public String toString(int t) {
        return String.format("%sProgram:\n%s\n", getTabs(t), statements.toString(t + 1));
    }
}
