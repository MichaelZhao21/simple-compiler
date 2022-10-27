import java.util.List;
import java.util.LinkedList;

public class MethodList extends Token {
    List<Method> methodList;

    public MethodList() {
        methodList = new LinkedList<>();    
    }

    public MethodList prepend(Method m) {
        methodList.add(0, m);
        return this;
    }

    @Override
    public String toString(int t) {
        return printParams(t, printList("\n" + getTabs(t), methodList, t));
    }
}
