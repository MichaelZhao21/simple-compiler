import java_cup.runtime.*;

%%
/**
 * LEXICAL FUNCTIONS:
 */
%cup
%line
%column
%unicode
%class Lexer

%{
    // StringBuffer for creating a string literal
    StringBuffer str = new StringBuffer();

    /**
    * Return a new Symbol with the given token id, and with the current line and
    * column numbers.
    */
    Symbol symbol(int tokenId) {
        return new Symbol(tokenId, yyline, yycolumn);
    }

    /**
    * Return a new Symbol with the given token id, the current line and column
    * numbers, and the given token value.  The value is used for tokens such as
    * identifiers and numbers.
    */
    Symbol symbol(int tokenId, Object value) {
        return new Symbol(tokenId, yyline, yycolumn, value);
    }

%}


/**
 * PATTERN DEFINITIONS:
 * Implement patterns as regex here
 */

Whitespace = [ \n\t\r]
LineTerminator = \r|\n|\r\n
Identifier = [A-Za-z][A-Za-z0-9]*
Type = "int" | "char" | "bool" | "float"
IntegerLiteral = [0-9]+
FloatLiteral = [0-9]+\.[0-9]+
StringLiteral = \"([A-Za-z]|\\n|\\t|\\\\|\\\")*\"
CharLiteral = \'([A-Za-z ]|\\n|\\t|\\\\|\\\")\'
Comment = (\\\\.*\n)|(\\\*(.|\R)*\*\\)

%%
/**
 * LEXICAL RULES:
 */

<YYINITIAL> {

    ";"                 { return symbol(sym.SEMI); }
    "=="                { return symbol(sym.EQ); }
    "="                 { return symbol(sym.ASSIGN); }
    "*"                 { return symbol(sym.MULTIPLY); }
    "/"                 { return symbol(sym.DIVIDE); }
    "+"                 { return symbol(sym.ADD); }
    "-"                 { return symbol(sym.SUBTRACT); }
    "<>"                { return symbol(sym.NE); }
    "<="                { return symbol(sym.LTE); }
    ">="                { return symbol(sym.GTE); }
    "<"                 { return symbol(sym.LT); }
    ">"                 { return symbol(sym.GT); }
    "||"                { return symbol(sym.OR); }
    "&&"                { return symbol(sym.AND); }
    "("                 { return symbol(sym.LPAREN); }
    ")"                 { return symbol(sym.RPAREN); }
    "["                 { return symbol(sym.LBRACKET); }
    "]"                 { return symbol(sym.RBRACKET); }
    "~"                 { return symbol(sym.COMPLEMENT); }
    "?"                 { return symbol(sym.QUESTION); }
    ":"                 { return symbol(sym.COLON); }
    final               { return symbol(sym.FINAL); }
    if                  { return symbol(sym.IF); }
    else                { return symbol(sym.ELSE); }
    while               { return symbol(sym.WHILE); }
    read                { return symbol(sym.READ); }
    printline           { return symbol(sym.PRINTLINE); }
    print               { return symbol(sym.PRINT); }
    return              { return symbol(sym.RETURN); }

    {Type}              { return symbol(sym.TYPE, new String(yytext())); }
    {FloatLiteral}      { return symbol(sym.FLOAT_LITERAL, Float.parseFloat(yytext())); }
    {IntegerLiteral}    { return symbol(sym.INTEGER_LITERAL, Integer.parseInt(yytext())); }
    {StringLiteral}     { return symbol(sym.STRING_LITERAL, new String(yytext())); }
    {CharLiteral}       { return symbol(sym.CHAR_LITERAL, new String(yytext())); }
    {Comment}           { return symbol(sym.COMMENT, new String(yytext())); }
    {Identifier}        { return symbol(sym.ID, new String(yytext())); }
    {Whitespace}        { /* Ignore whitespace. */ }
    .                   { System.out.printf("[Line: %-3d Col: %-3d] ILLEGAL CHAR '%s'\n", yyline, yychar, yytext()); }
}