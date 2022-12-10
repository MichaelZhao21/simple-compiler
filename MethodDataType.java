public class MethodDataType extends DataType {
    ListDataType paramTypeList;
    String returnType;

    public MethodDataType(ListDataType paramTypeList, String returnType) {
        this.paramTypeList = paramTypeList;
        this.returnType = returnType;
    }

    @Override
    public String toString() {
        return String.format("(%s) -> %s", paramTypeList.toString(), returnType);
    }
}
