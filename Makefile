JAVA=java
JAVAC=javac
JFLEX=$(JAVA) -jar jflex-full-1.8.2.jar
CUPJAR=./java-cup-11b.jar
CUP=$(JAVA) -jar $(CUPJAR)
CP=.:$(CUPJAR)
TEST=tests

default: run

.SUFFIXES: $(SUFFIXES) .class .java

.java.class:
		$(JAVAC) -cp $(CP) $*.java

FILE=    Lexer.java      parser.java    sym.java \
    LexerTest.java

run: test 

all: Lexer.java parser.java $(FILE:java=class)

test: all
		$(JAVA) -cp $(CP) LexerTest tests/$(TEST).txt > tests/$(TEST)-output.txt
		cat tests/$(TEST).txt
		cat -n tests/$(TEST)-output.txt

clean:
		rm -f *.class *~ *.bak Lexer.java parser.java sym.java

Lexer.java: tokens.jflex
		$(JFLEX) tokens.jflex

parser.java: grammar.cup
		$(CUP) -interface < grammar.cup

parserD.java: grammar.cup
		$(CUP) -interface -dump < grammar.cup
