# Compiler Project Phase 0

Compiler project built for [CS 4386](https://catalog.utdallas.edu/2022/undergraduate/courses/cs4386).

Currently we are at phase 0, which simply identifies the tokens.

## Build and Execution

Build and run the basic test file with `make run`. If you want to run the extensive tests, execute `make test`. Both commands will build the lexer and parsers.

By default, `make test` will run the `tests/tests.txt` file. To run a different test file, you can set the `TEST` variable while running the Makefile. For example, to run the advanced tests (see the `tests` directory), you would issue the command `make test VAR="adv-tests"`. Any new tests would simply need to be a `.txt` file put in the `tests` directory and can be run with the command `make test VAR="[name of test file without .txt extension]"`.

## To Run Custom Tests

To run a custom test, simply create a new rule in the `Makefile` in the following format:

```Makefile
test: all
		$(JAVA) -cp $(CP) LexerTest tests.txt > tests-output.txt
		cat tests.txt
		cat -n tests-output.txt
```

Replace `test` with the make command you wish to use, replace `tests.txt` with the input test file, and `tests-output.txt` with the file you wish to output text to.

## Resources Used

- [CS Princeton's CUP User Manual](https://www.cs.princeton.edu/~appel/modern/java/CUP/manual.html#spec)
- [JFlex Manual](https://jflex.de/manual.html#Example)
- [Java CUP Manual (no longer active website; need to use wayback machine)](https://web.archive.org/web/20220407005956/https://www2.cs.tum.edu/projects/cup/examples.php)
- [Random Google Group Post from 2001](https://groups.google.com/g/comp.compilers/c/fGHJWkTkZG8)
