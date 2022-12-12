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
        return printParams(t, printCommaList(nameList, 0));
    }

    @Override
    public DataType getType() throws CompilerException {
        List<DataType> dataTypes = new LinkedList<>();
        for (Name n : nameList) {
            dataTypes.add(n.getType());
        }
        return new ListDataType(dataTypes);
    }
}
