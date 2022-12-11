import java.util.List;

public abstract class Statement extends Token {
    public List<DataType> getReturnTypes() throws CompilerException {
        return null;
    }
}
