import java.util.Arrays;
import java.util.List;

public class ReturnStatement extends Statement {
    Expression e;

    public ReturnStatement(Expression e) {
        this.e = e;
    }

    public ReturnStatement() {
        this.e = null;
    } 

    @Override
    public String toString(int t) {
        if (e == null) return "return ;";
        return printParams(0, "return", "(", e.toString(0), ")", ";");
    }

    @Override
    public DataType getType() throws CompilerException {
        return e.getType();
    }

    @Override
    public String typeCheck() throws CompilerException {
        return "Returned " + e.getType().toString();
    }

    @Override
    public List<DataType> getReturnTypes() throws CompilerException {
        return Arrays.asList(getType());
    }
}
