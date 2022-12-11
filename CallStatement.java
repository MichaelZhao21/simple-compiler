import java.util.List;

public class CallStatement extends Statement {
    Expression c;

    public CallStatement(Expression c) {
        this.c = c;
    }

    @Override
    public String toString(int t) {
        return printParams(0, c.toString(0), ";");
    }
    
    @Override
    public DataType getType() throws CompilerException {
        return c.getType();
    }

    @Override
    public String typeCheck() throws CompilerException {
        return c.typeCheck();
    }

    @Override
    public List<DataType> getReturnTypes() throws CompilerException {
        return null;
    }
}
