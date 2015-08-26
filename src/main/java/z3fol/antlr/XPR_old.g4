grammar XPR;

@header {package z3fol.antlr;}

/*------------------------------------------------------------------
 * PARSER RULES
 *------------------------------------------------------------------*/

// misc characters
LPAREN: '(';
RPAREN: ')';
PLUS: '+';
MINUS: '-';
TIMES: '*';
DIV: '/';
GT: '>';
GE: '>=';
LE: '<=';
LT: '<';
EQ: '=';
NE: '!=';
POINT: '.';
POW: '^';
OR: '|';
AND: '&';
IMPLIES: '=>';
IFF: '<=>';
XOR: 'XOR';
NOT: '!';
SEMICOLON: ';';

SET_IN: 'in';
SET_NOTIN: 'notin';

PLUSEQ: '+=';
MINUSEQ: '-=';


EXISTS: 'Exists';
FORALL: 'Forall';
KWD_TYPE: 'type';
KWD_DECLARE: 'declare';
KWD_ASSERT: 'assert';

NUM_DECIMAL: [0-9]+;
IDENTIFIER_UC : [A-Z_][a-zA-Z0-9_]*;
IDENTIFIER_LC : [a-z_][a-zA-Z0-9_]*;
identifier: IDENTIFIER_LC | IDENTIFIER_UC;
identifier_uc: IDENTIFIER_UC;

number: MINUS? NUM_DECIMAL;

document: (line? ';')*;

line
    : typeDeclaration
    | varDeclaration
    | fact
    | instruction
    ;

typeDeclaration: KWD_TYPE identifier type?;

type
    : identifier_uc
    | typeTuple
    | typeGeneric
    ;
typeTuple: LPAREN type (',' type) RPAREN;
typeGeneric: identifier_uc LT type GT;
varDeclaration: KWD_DECLARE variableAndType;

variable: identifier;
variable_value: MINUS? variable;
variableAndType: type variable;
variableAndTypeList: variableAndType (',' variableAndType)*;

fact: KWD_ASSERT quantifier;
quantifier: ((FORALL | EXISTS) variableAndTypeList ':')? logic_statement;
logic_statement: disjunction (logop disjunction)?;
disjunction: conjunction (OR conjunction)*;
conjunction: negation (AND negation)*;
negation: NOT? (predicate | LPAREN quantifier RPAREN);

equation: expression relop expression;
relop: EQ | NE | GT | LT | GE | LE ;
logop: IMPLIES | IFF | XOR;
sumop: PLUS | MINUS;
mulop: TIMES | DIV;

expression: mulExpression (sumop mulExpression)*;
expression_list: expression (',' expression)*;
mulExpression: powExpression (mulop powExpression)*;
powExpression: atom (POW expression)?;

atom
    : variable_value
    | number
    | LPAREN expression RPAREN
    | call
    ;

call
    : identifier
    | identifier LPAREN expression_list RPAREN
    ;

predicate_call
    : identifier
    | identifier LPAREN expression_list RPAREN
    ;

predicate
    : equation
    | set_theory_statement
    | predicate_call
    ;

set_theory_statement: expression setop expression;
setop: SET_IN | SET_NOTIN;

assignment_op: EQ | PLUSEQ | MINUSEQ;
instruction: identifier assignment_op expression;





Whitespace: [ \t]+ -> skip;
Newline: ('\r' '\n'? | '\n') -> skip;
BlockComment: '/*' .*? '*/' -> skip;
LineComment: '//' ~[\r\n]* -> skip;
