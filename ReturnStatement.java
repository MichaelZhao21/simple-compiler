public class ReturnStatement extends Statement {
    Expression e;

    public ReturnStatement(Expression e) {
        this.e = e;
    }

    public ReturnStatement() {
        this.e = null;
    } 

    @Override
    public String toString(int t) {
        if (e == null) return "return ;";
        return printParams(0, "return", "(", e.toString(0), ")", ";");
    }
}
