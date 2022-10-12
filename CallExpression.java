public class CallExpression extends Expression {
    String id;
    ArgumentList argumentList;

    public CallExpression(String id) {
        this.id = id;
        this.argumentList = new ArgumentList();
    }

    public CallExpression(String id, ArgumentList argumentList) {
        this.id = id;
        this.argumentList = argumentList;
    }

    @Override
    public String toString(int t) {
        return printParams(t, "id:" + id, "(", argumentList.toString(0), ")");
    }
}
