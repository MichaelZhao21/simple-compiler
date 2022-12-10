import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class SymbolTable {
    List<Map<String, DataType>> table;

    public SymbolTable() {
        table = new LinkedList<>();
        table.add(new HashMap<String, DataType>());
    }

    public void startScope() {
        table.add(new HashMap<String, DataType>());
    }

    public void endScope() {
        table.remove(table.size() - 1);
    }

    public void addVariable(String name, String type, boolean isFinal, boolean isArray) throws CompilerException {
        DataType dataType = new VariableDataType(type, isFinal, isArray);
        Map<String, DataType> currentScope = table.get(table.size() - 1);
        if (currentScope.containsKey(name)) {
            throw new CompilerException("Error: redecleration of variable " + name);
        }
        currentScope.put(name, dataType);
    }

    public void addMethod(String id, ParameterList params, String returnType) throws CompilerException {
        ListDataType paramType = (ListDataType) params.getType();
        MethodDataType type = new MethodDataType(paramType, returnType);
        Map<String, DataType> currentScope = table.get(table.size() - 1);
        if (currentScope.containsKey(id)) {
            throw new CompilerException("Error: redecleration of method " + id);
        }
        currentScope.put(id, type);
    }

    public DataType get(String s) throws CompilerException {
        for (int i = table.size() - 1; i >= 0; i--) {
            DataType type = table.get(i).get(s);
            if (type != null) {
                return type;
            }
        }

        throw new CompilerException("Error: usage of undeclared variable " + s);
    }

    @Override
    public String toString() {
        String t = "";
        StringBuilder sb = new StringBuilder();
        for (Map<String, DataType> m : table) {
            sb.append(t).append(m.toString()).append("\n");
            t += "\t";
        }
        return sb.toString();
    }
}
