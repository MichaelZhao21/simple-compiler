import java.util.LinkedList;
import java.util.List;

public class VariableDataType extends DataType {
    String type;
    boolean isFinal;
    boolean ignoreFinal;
    boolean isArray;

    public VariableDataType(String type) {
        this.type = type;
        this.isFinal = false;
        this.isArray = false;
        this.ignoreFinal = false;
    }

    public VariableDataType(String type, boolean ignoreFinal) {
        this.type = type;
        this.isFinal = false;
        this.isArray = false;
        this.ignoreFinal = ignoreFinal;
    }

    public VariableDataType(String type, boolean isFinal, boolean isArray) {
        this.type = type;
        this.isFinal = isFinal;
        this.isArray = isArray;
        this.ignoreFinal = false;
    }

    public VariableDataType(String type, boolean isFinal, boolean isArray, boolean ignoreFinal) {
        this.type = type;
        this.isFinal = isFinal;
        this.isArray = isArray;
        this.ignoreFinal = ignoreFinal;
    }

    @Override
    public boolean equals(Object obj) {
        VariableDataType t = (VariableDataType) obj;

        // Coercion will happen on the RHS object
        List<String> avaliableTypes = new LinkedList<>();
        avaliableTypes.add(t.type);
        if (t.type.equals("int")) {
            avaliableTypes.add("boolean");
            avaliableTypes.add("float");
        }
        if (!t.isArray) {
            avaliableTypes.add("string");
        }
        
        // Ignore final qualifier on initialization
        if (ignoreFinal || t.ignoreFinal) {
            return avaliableTypes.contains(type) && isArray == t.isArray;
        }
        return avaliableTypes.contains(type) && isFinal == t.isFinal && isArray == t.isArray;
    }

    @Override
    public String toString() {
        return String.format("%s%s%s", isFinal ? "final " : "", type, isArray ? " []" : "");
    }
}
