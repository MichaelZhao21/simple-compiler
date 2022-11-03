public class Program extends Token {
    Name id;
    DeclerationList memberDeclerations;

    public Program(Name id, DeclerationList memberDeclerations) {
        this.memberDeclerations = memberDeclerations;
        this.id = id;
    }

    @Override
    public String toString(int t) {
        return printParams(t, "class", id.toString(0), "{") +
                printParams("", 0, "\n", memberDeclerations.toString(t + 1), "\n}");
    }
}
