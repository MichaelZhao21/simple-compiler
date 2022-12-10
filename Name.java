public class Name extends Expression {
    String id;
    Expression expression;
    Integer number;

    public Name(String id, Expression expression) {
        this.id = id;
        this.expression = expression;
        this.number = null;
    }

    public Name(String id, int number) {
        this.id = id;
        this.expression = null;
        this.number = number;
    }

    public Name(String id) {
        this.id = id;
        this.expression = null;
        this.number = null;
    }

    @Override
    public String toString(int t) {
        if (expression == null) {
            if (number == null) {
                return printParams("", t, id);
            } else {
                return printParams(t, id, "[", number.toString(), "]");
            }
        }
        return printParams(t, id, "[", "(", expression.toString(0), ")", "]");
    }

    @Override
    public DataType getType() throws CompilerException {
        return symbolTable.get(id);
    }

    @Override
    public String typeCheck() throws CompilerException {
        return getType().toString();
    }
}