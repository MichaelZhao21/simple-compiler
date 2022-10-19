# Compiler Project Phase 1

Compiler project built for [CS 4386](https://catalog.utdallas.edu/2022/undergraduate/courses/cs4386).

## Project Organization

- **lib**: Contains all CUP and JFlex library JARs
- **tests**: Contains all test text files

## Build and Execution

Build and run the basic test file with `make run`. If you want to run the extensive tests, execute `make test`. Both commands will build the lexer and parsers.

By default, `make test` will run the `tests/tests.txt` file. To run a different test file, you can set the `TEST` variable while running the Makefile. For example, to run the advanced tests (see the `tests` directory), you would issue the command `make test TEST="tests"`. Any new tests would simply need to be a `.txt` file put in the `tests` directory and can be run with the command `make test TEST="[name of test file without .txt extension]"`.

To run ONLY the lexer (See `LexerTest.java`), you can use `make lex-test`. The `TEST` variable still behaves the same as the `test` recipe. For the test files written to specifically catch scanning/lexing errors, see the `tests/lexer` directory. A good example can be seen when running `make lex-test TEST="lexer/adv-tests"`.

## Phases

- **Phase 1**: Tokenizer, mostly working on `src/tokens.jflex`, which uses Regular Expressions to scan incoming tokens.
- **Phase 2**: Parser, will take the tokens from the first part and implements the grammar in `src/grammar.cup`.

## Resources Used

- [CS Princeton's CUP User Manual](https://www.cs.princeton.edu/~appel/modern/java/CUP/manual.html#spec)
- [JFlex Manual](https://jflex.de/manual.html#Example)
- [Java CUP Manual (no longer active website; need to use wayback machine)](https://web.archive.org/web/20220407005956/https://www2.cs.tum.edu/projects/cup/examples.php)
- [Random Google Group Post from 2001](https://groups.google.com/g/comp.compilers/c/fGHJWkTkZG8)

# Grammar Implemented

```
Program                     ➞  class id { MemberDeclerations }
MemberDeclerations          ➞  FieldDeclerations MethodDeclerations
FieldDeclerations           ➞  FieldDecleration FieldDeclerations | λ
MethodDeclerations          ➞  MethodDecleration MethodDeclerations | λ
FieldDecleration            ➞  OptionalFinal Type id OptionalExpression ;
                            |   Type id [ integerliteral ] ;
OptionalFinal               ➞  final | λ
OptionalExpression          ➞  = Expression | λ
MethodDecleration           ➞  ReturnType id ( ArgumentDeclerations ) { FieldStatements Statements } OptionalSemi
OptionalSemi                ➞  ; | λ
ReturnType                  ➞  Type | void
Type                        ➞  int | char | bool | float
ArgumentDeclerations        ➞  ArgumentDeclerationList | λ
ArgumentDeclerationList     ➞  ArgumentDecleration, ArgumentDeclerationList | ArgumentDecleration
ArgumentDecleration         ➞  Type id | Type id []
Statements                  ➞  Statements Statement | λ
Statement                   ➞  if ( Expression ) { FieldDeclerations Statements } IfEnd
                            |   while ( Expression ) { FieldDeclerations Statements }
                            |   Name = Expression ;
                            |   read ( ReadList ) ;
                            |   print ( PrintList ) ;
                            |   printline ( PrintLineList ) ;
                            |   id () ;
                            |   id ( Arguments ) ;
                            |   return ;
                            |   return Expression ;
                            |   Name ++ ;
                            |   Name -- ;
                            |   { FieldDecleration Statements } OptionalSemi
IfEnd                       ➞  else { FieldDeclerations Statements } | λ
Name                        ➞  id | id [ Expression ]
Arguments                   ➞  Expression, Arguments | Expression
ReadList                    ➞  Name, ReadList | Name
PrintList                   ➞  Expression, PrintList | Expression
PrintLineList               ➞  PrintList | λ  
Expression                  ➞  Name
                            |   id ()
                            |   id ( Arguments )
                            |   integerliteral
                            |   characterliteral
                            |   stringliteral
                            |   floatliteral
                            |   true
                            |   false
                            |   ( Expression )
                            |   ~ Expression
                            |   - Expression
                            |   + Expression
                            |   ( Type ) Expression
                            |   Expression BinaryOperator Expression
                            |   ( Expression ? Expression : Expression ) 
BinaryOperator              ➞  * | / | + | - | < | > | <= | >= | == | <> | \|\| | &&
```
