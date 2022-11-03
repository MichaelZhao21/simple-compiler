import java.util.List;

abstract class Token {
    protected String getTabs(int t) {
        StringBuilder tabs = new StringBuilder();
        for (int i = 0; i < t; i++) {
            tabs.append("\t");
        }
        return tabs.toString();
    }

    protected String printParams(int t, String... strings) {
        return printParams(" ", t, strings);
    }

    protected String printParams(String sep, int t, String... strings) {
        if (strings.length == 0)
            return "";
        StringBuilder sb = new StringBuilder().append(strings[0]);
        for (int i = 1; i < strings.length; i++) {
            sb.append(sep).append(strings[i]);
        }
        return getTabs(t) + sb.toString();
    }

    protected <T extends Token> String printCommaList(List<T> l, int t) {
        return printCommaList(l, t, false);
    }

    protected <T extends Token> String printCommaList(List<T> l, int t, boolean isExpression) {
        if (l.size() == 0)
            return "";
        StringBuilder sb = new StringBuilder().append(isExpression ? "( " : "").append(l.get(0).toString(t))
                .append(isExpression ? " )" : "");
        for (int i = 1; i < l.size(); i++) {
            sb.append(", ").append(isExpression ? "( " : "").append(l.get(i).toString(t))
                    .append(isExpression ? " )" : "");
        }
        return sb.toString();
    }

    protected <T extends Token> String printLineList(List<T> l, int t) {
        if (l.size() == 0) 
            return "";
        String sep = "\n" + getTabs(t);
        StringBuilder sb = new StringBuilder().append(l.get(0).toString(t));
        for (int i = 1; i < l.size(); i++) {
            sb.append(sep).append(l.get(i).toString(t));
        }
        return sb.toString();
    }

    public String toString(int t) {
        return "";
    }
}
