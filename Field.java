public class Field extends Token {
    Type type;
    Name id;
    Expression expression;
    boolean hasFinal;

    public Field(Type type, Name id, boolean hasFinal) {
        this.type = type;
        this.id = id;
        this.expression = null;
        this.hasFinal = hasFinal;
    }

    public Field(Type type, Name id, Expression expression, boolean hasFinal) {
        this.type = type;
        this.id = id;
        this.expression = expression;
        this.hasFinal = hasFinal;
    }

    @Override
    public String toString(int t) {
        return printParams(t, hasFinal ? "final" : "", type.toString(0), id.toString(0),
                expression == null ? "" : expression.toString(0));
    }
}
