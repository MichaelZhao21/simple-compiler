public class Program extends Token {
    Name id;
    MemberDeclerations memberDeclerations;

    public Program(Name id, MemberDeclerations memberDeclerations) {
        this.memberDeclerations = memberDeclerations;
        this.id = id;
    }

    @Override
    public String toString(int t) {
        return printParams(t, "class", id.toString(0), "{\n", memberDeclerations.toString(t), "\n}");
    }
}
