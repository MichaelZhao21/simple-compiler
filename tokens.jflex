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

whitespace = [ \n\t\r]

Identifier = [A-Za-z][A-Za-z0-9]*
Type = "int" | "char" | "bool" | "float"
IntegerLiteral = [0-9]+
FloatLiteral = [0-9]+\.[0-9]+

%%
/**
 * LEXICAL RULES:
 */

/**
 * Implement terminals here, ORDER MATTERS!
 */

<YYINITIAL> {
    {Type}              { return symbol(sym.TYPE, new String(yytext())); }

    ";"                 { return symbol(sym.SEMI); }
    "="                 { return symbol(sym.ASSIGN); }

    {FloatLiteral}      { return symbol(sym.FLOAT_LITERAL, Float.parseFloat(yytext())); }
    {IntegerLiteral}    { return symbol(sym.INTEGER_LITERAL, Integer.parseInt(yytext())); }
    {Identifier}        { return symbol(sym.ID, new String(yytext())); }
    {whitespace}        { /* Ignore whitespace. */ }
    .                   { System.out.printf("[Line: %-3d Col: %-3d] ILLEGAL CHAR '%s'\n", yyline, yychar, yytext()); }
}