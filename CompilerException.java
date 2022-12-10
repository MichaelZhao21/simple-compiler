public class CompilerException extends Exception {
    String error;

    public CompilerException(String error) {
        this.error = error;
    }

    @Override
    public String toString() {
        return error;
    }
}
