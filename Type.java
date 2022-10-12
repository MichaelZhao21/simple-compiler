public class Type extends Token {
    String type;

    public Type(String type) {
        this.type = type;
    }

    @Override
    public String toString(int t) {
        return printParams(t, type);
    }
}
