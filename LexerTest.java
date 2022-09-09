import java.io.*;
import java_cup.runtime.*;

public class LexerTest{

    public static void main(String[] args) {
        Symbol sym;
        try {
            Lexer lexer = new Lexer(new FileReader(args[0]));
            for (sym = lexer.next_token(); sym.sym != 0;
                    sym = lexer.next_token()) {

                String value = sym.value == null ? "" : " (value=" + sym.value.toString() + ")";
                System.out.printf("[Line: %-3d Col: %-3d] Token %s%s\n", sym.left, sym.right, sym, value);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
