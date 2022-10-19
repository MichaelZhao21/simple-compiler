import java.util.List;
import java.util.LinkedList;

public class ReadList extends FunctionList {
    List<Name> nameList;

    public ReadList() {
        nameList = new LinkedList<>();
    }

    public ReadList(Name n) {
        nameList = new LinkedList<>();
        nameList.add(n);
    }

    @Override
    public ReadList prepend(Expression n) {
        nameList.add(0, (Name) n);
        return this;
    }

    @Override
    public String toString(int t) {
        return printParams(t, printList(", ", nameList, 0));
    }
}
