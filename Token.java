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
        if (strings.length == 0) return "";
        StringBuilder sb = new StringBuilder().append(strings[0]);
        for (int i = 1; i < strings.length; i++) {
            sb.append(" ").append(strings[i]);
        }
        return getTabs(t) + sb.toString();
    }

    protected <T extends Token> String printList(String sep, List<T> l) {
        if (l.size() == 0) return "";
        StringBuilder sb = new StringBuilder().append(l.get(0).toString(0));
        for (int i = 1; i < l.size(); i++) {
            sb.append(sep).append(l.get(i).toString(0));
        }
        return sb.toString();
    }

    public String toString(int t) {
        return "";
    }
}
