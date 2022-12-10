import java.util.List;
import java.util.LinkedList;

public class ParameterList extends FunctionList {
    List<Parameter> parameterList;

    public ParameterList() {
        parameterList = new LinkedList<>();
    }

    public ParameterList(Parameter p) {
        parameterList = new LinkedList<>();
        parameterList.add(p);
    }

    public ParameterList prepend(Parameter p) {
        parameterList.add(0, p);
        return this;
    }

    @Override
    public String toString(int t) {
        return printParams(t, printCommaList(parameterList, 0));
    }

    @Override
    public DataType getType() throws CompilerException {
        List<DataType> dataTypes = new LinkedList<>();
        for (Parameter p : parameterList) {
            dataTypes.add(p.getType());
        }
        return new ListDataType(dataTypes);
    }

    @Override
    public String typeCheck() throws CompilerException {
        return getType().toString();
    }
}
