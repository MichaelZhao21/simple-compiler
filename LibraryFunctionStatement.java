public class LibraryFunctionStatement extends Statement {
    String function;
    FunctionList list;

    public LibraryFunctionStatement(String function, FunctionList list) {
        this.function = function;
        this.list = list;
    }

    @Override
    public String toString(int t) {
        return printParams(0, function, "(", list.toString(0), ") ;");
    }
}
