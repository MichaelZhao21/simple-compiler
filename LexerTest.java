import java.io.*;
import java_cup.runtime.*;

public class LexerTest{

    public static void main(String[] args) {
        Symbol s;
        try {
            Lexer lexer = new Lexer(new FileReader(args[0]));
            for (s = lexer.next_token(); s.sym != 0;
                    s = lexer.next_token()) {

                String value = s.value == null ? "" : " (value=" + s.value.toString() + ")";
                System.out.printf("[Line: %-3d Col: %-3d] Token %s %s%s\n", s.left, s.right, s, sym.terminalNames[s.sym], value);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
