import java.util.List;
import java.util.LinkedList;

public class ArgumentList extends Token {
    List<Expression> expressionList;

    public ArgumentList() {
        expressionList = new LinkedList<>();
    }

    public ArgumentList(Expression e) {
        expressionList = new LinkedList<>();
        expressionList.add(e);
    }

    public ArgumentList prepend(Expression e) {
        expressionList.add(0, e);
        return this;
    }

    @Override
    public String toString(int t) {
        return printParams(t, printList(", ", expressionList));
    }
}
