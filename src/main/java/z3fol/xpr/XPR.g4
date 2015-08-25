/*
* FOL originally written for Antlr3 by Stephan Opfer
*
* Ported to Antlr4 by Tom Everett
*
*/

grammar XPR;

@header {package z3fol.xpr;}

/*------------------------------------------------------------------
 * PARSER RULES
 *------------------------------------------------------------------*/

// misc characters
LPAREN: '(';
RPAREN: ')';
PLUS: '+';
MINUS: '-';
TIMES: '*';
MOD: '%';
DIV: '/';
GT: '>';
LT: '<';
EQ: '=';
POINT: '.';
POW: '^';
EXISTS: 'Exists';
FORALL: 'Forall';
OR: '|';
AND: '&';
NOT: '!';

// characters
NUM_DECIMAL
    : [1-9][0-9]+
    | '0';

IDENTIFIER : [a-z0-9_][a-zA-Z0-9_]*;

number: MINUS? NUM_DECIMAL;
variable: IDENTIFIER;
variable_declaration: IDENTIFIER IDENTIFIER;
variable_declaration_list: variable_declaration (',' variable_declaration)*;

// Mathematical expression (holds a value)
expression: mulExpression ((PLUS|MINUS|MOD) mulExpression)*;
expression_list: expression (',' expression)*;
mulExpression: powExpression ((TIMES|DIV) powExpression)*;
powExpression: atom (POW expression)?;

atom
    : MINUS? variable
    | number
    | function_call
    | LPAREN expression RPAREN
    ;

function_call
    : variable LPAREN expression_list RPAREN
    | variable LPAREN RPAREN
    ;

// Equations and formulas
equation: expression relop expression;
relop: EQ | GT | LT;

formula: ((FORALL | EXISTS) variable_declaration_list ':')? disjunction;
disjunction: conjunction (OR conjunction)*;
conjunction: negation (AND negation)*;
negation: NOT? (predicate | LPAREN formula RPAREN);

predicate
    : equation
    | variable
    | function_call // a boolean function
    ;

// Statement

// Lexer
fragment SPACE: (' ' | '\t' | '\r' | '\n');
WS: SPACE+ -> skip;
