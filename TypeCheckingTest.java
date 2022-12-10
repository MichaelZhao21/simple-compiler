import java.io.*;
import java_cup.runtime.*;

public class TypeCheckingTest {
    public static void main(String[] args) {
        Reader reader = null;

        // If no file provided, read from input stream
        // If file is provided, open the file for reading
        if (args.length == 1) {
            File input = new File(args[0]);
            if (!input.canRead()) {
                System.out.printf("ERROR: Could not read [%s]\n", input);
                System.exit(1);
            }
            try {
                reader = new FileReader(input);
            } catch (Exception e) {
                e.printStackTrace();
                System.exit(1);
            }
        } else {
            reader = new InputStreamReader(System.in);
        }

        // Create lexer and parser
        Lexer lexer = new Lexer(reader);
        Parser parser = new Parser(lexer);
        Program program = null;

        // Run the parser
        try {
            program = (Program) parser.parse().value;
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Run the type checker
        if (program != null) {
            try {
                String typeCatch = program.typeCheck();
                System.out.println("\n=== TYPE CHECKING VALID ===\n" + typeCatch + "\n===========================\n");
            } catch (CompilerException e) {
                System.err.println(e.toString());
            }
        }
    }
}