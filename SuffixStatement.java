public class SuffixStatement extends Statement {
    Name name;
    String op;
    
    public SuffixStatement(Name name, String op) {
        this.name = name;
        this.op = op;
    }

    @Override
    public String toString(int t) {
        return printParams(0, name.toString(0), op, ";");
    }
}
