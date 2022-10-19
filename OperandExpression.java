public class OperandExpression extends Expression {
    String type;
    String value;

    public OperandExpression(int n) {
        value = String.valueOf(n);
        type = "int";
    }

    public OperandExpression(float n) {
        value = String.valueOf(n);
        type = "float";
    }

    public OperandExpression(String value, String type) {
        this.value = value;
        this.type = type;
    }

    @Override
    public String toString(int t) {
        String valString = value;
        if (type.equals("char"))
            valString = String.format("'%s'", value);
        else if (type.equals("string"))
            valString = String.format("\"%s\"", value);

        return printParams(t, type + ":" + valString);
    }
}
