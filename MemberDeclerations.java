public class MemberDeclerations extends Token {
    FieldList fieldList;
    MethodList methodList;

    public MemberDeclerations(FieldList fieldList, MethodList methodList) {
        this.fieldList = fieldList;
        this.methodList = methodList;
    }

    @Override
    public String toString(int t) {
        return printParams(t, fieldList.toString(t), methodList.toString(t));
    }
}
