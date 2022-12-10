import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class ListDataType extends DataType {
    List<DataType> typeList;

    public ListDataType(List<DataType> typeList) {
        this.typeList = typeList;
    }

    @Override
    public boolean equals(Object obj) {
        ListDataType t = (ListDataType) obj;
        if (t.typeList.size() != typeList.size())
            return false;

        Iterator<DataType> it1 = typeList.iterator();
        Iterator<DataType> it2 = t.typeList.iterator();
        while (it1.hasNext() && it2.hasNext()) {
            if (!it1.next().equals(it2.next())) {
                return false;
            }
        }

        return true;
    }

    @Override
    public String toString() {
        return typeList.stream().map(DataType::toString).collect(Collectors.joining(", "));
    }
}
