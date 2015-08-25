grammar XPR2;

@header {package z3fol.xpr2;}

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
GE: '>=';
LE: '<=';
LT: '<';
EQ: '=';
POINT: '.';
POW: '^';
OR: '|';
AND: '&';
IMPLIES: '=>';
IIF: '<=>';
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

number: MINUS? NUM_DECIMAL;

document: (line ';')*;

line
    : typeDeclaration
    | varDeclaration
    | fact
    | instruction
    ;

typeDeclaration: KWD_TYPE IDENTIFIER_UC type?;

type
    : typeIdentifier
    | typeTuple
    | typeGeneric
    ;
typeIdentifier: IDENTIFIER_UC;
typeTuple: LPAREN type (',' type) RPAREN;
typeGeneric: IDENTIFIER_UC LT type GT;
varDeclaration: KWD_DECLARE identifier type;

variable: IDENTIFIER_LC;
variableAndType: type variable;
variableAndTypeList: variableAndType (',' variableAndType)*;

fact: KWD_ASSERT quantifier;
quantifier: ((FORALL | EXISTS) variableAndTypeList ':')? logic_statement;
logic_statement: disjunction (logop logic_statement)*;
disjunction: conjunction (OR conjunction)*;
conjunction: negation (AND negation)*;
negation: NOT? (predicate | LPAREN quantifier RPAREN);

equation: expression relop expression;
relop: EQ | GT | LT;
logop: IMPLIES | IIF | XOR;

expression: mulExpression ((PLUS|MINUS|MOD) mulExpression)*;
expression_list: expression (',' expression)*;
mulExpression: powExpression ((TIMES|DIV) powExpression)*;
powExpression: atom (POW expression)?;

atom
    : MINUS? variable
    | number
    | call
    | LPAREN expression RPAREN
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
