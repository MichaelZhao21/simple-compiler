public abstract class FunctionList extends Token {
    public FunctionList prepend(Expression e) {
        return this;
    }

    public FunctionList prepend(Name n) {
        return this;
    }

    public FunctionList prepend(Parameter p) {
        return this;
    }
}
