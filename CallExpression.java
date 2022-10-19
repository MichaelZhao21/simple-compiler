public class CallExpression extends Expression {
    String id;
    FunctionList argumentList;

    public CallExpression(String id) {
        this.id = id;
        this.argumentList = new PrintList();
    }

    public CallExpression(String id, FunctionList argumentList) {
        this.id = id;
        this.argumentList = argumentList;
    }

    @Override
    public String toString(int t) {
        return printParams(t, "id:" + id, "(", argumentList.toString(0), ")");
    }
}
