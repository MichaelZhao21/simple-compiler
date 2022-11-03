import java.util.List;
import java.util.LinkedList;

public class PrintList extends FunctionList {
    List<Expression> expressionList;

    public PrintList() {
        expressionList = new LinkedList<>();
    }

    public PrintList(Expression e) {
        expressionList = new LinkedList<>();
        expressionList.add(e);
    }

    public PrintList prepend(Expression e) {
        expressionList.add(0, e);
        return this;
    }

    @Override
    public String toString(int t) {
        return printParams(t, printCommaList(expressionList, 0, true));
    }
}
