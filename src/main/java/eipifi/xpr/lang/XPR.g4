grammar XPR;

@header {package eipifi.xpr.lang;}

/*------------------------------------------------------------------
 * PARSER RULES
 *------------------------------------------------------------------*/

// Tokens
LPAREN: '(';
RPAREN: ')';
LBRACKET: '{';
RBRACKET: '}';
PLUS: '+';
MINUS: '-';
TIMES: '*';
DIV: '/';
GT: '>';
GE: '>=';
LE: '<=';
LT: '<';
EQ: '==';
NEQ: '!=';
ASSIGN: '=';
DOT: '.';
COMMA: ',';
POW: '^';
OR: '|';
AND: '&';
IMPLIES: '=>';
IFF: '<=>';
XOR: 'XOR';
NOT: '!';
COLON: ':';
SEMICOLON: ';';

SET_IN: 'in';
SET_NOTIN: 'notin';
SET_UNION: '∪';
SET_INTERSECT: '∩';
SET_DIFF: '\\';
SET_SUB: '⊂';

EXISTS: 'exists';
FORALL: 'forall';
KWD_TYPE: 'type';
KWD_ASSERT: 'assert';
KWD_SCHEMA: 'schema';
KWD_OPERATION: 'operation';
KWD_TRUE: 'true';
KWD_FALSE: 'false';

NUM_DECIMAL: [0-9]+;
IDENTIFIER : [a-zA-Z0-9_]+;

Whitespace: [ \t]+ -> skip;
Newline: ('\r' '\n'? | '\n') -> skip;
BlockComment: '/*' .*? '*/' -> skip;
LineComment: '//' ~[\r\n]* -> skip;

// ---------------------------------------------------------------------------

// general rules
simple_id: IDENTIFIER;
id: IDENTIFIER (DOT IDENTIFIER)*;
num: NUM_DECIMAL;

// declarations
typeIdList: typeId (COMMA typeId)*;
typeId: type id;
type: id;

// arithmetic
arithExpr
    : LPAREN arithExpr RPAREN
    | arithExpr POW arithExpr
    | arithExpr TIMES arithExpr
    | arithExpr DIV arithExpr
    | arithExpr PLUS arithExpr
    | arithExpr MINUS arithExpr
    | id
    | num;

// boolean
boolExpr
    : LPAREN boolExpr RPAREN
    | boolExpr IFF boolExpr
    | boolExpr XOR boolExpr
    | boolExpr IMPLIES boolExpr
    | boolExpr AND boolExpr
    | boolExpr OR boolExpr
    | membership
    | subset
    | comparison
    | equality
    | id
    | (KWD_TRUE | KWD_FALSE)
    | quantifiedExpr
    ;

equality: expr (EQ | NEQ) expr;
comparison: arithExpr (LE | GE | LT | GT) arithExpr;
membership: expr SET_IN arrayExpr;
subset: arrayExpr SET_SUB arrayExpr;
quantifiedExpr: (FORALL | EXISTS) typeIdList COLON boolExpr;

// arrays (Z3 sets)
arrayExpr
    : LPAREN arrayExpr RPAREN
    | arrayExpr SET_INTERSECT arrayExpr
    | arrayExpr SET_UNION arrayExpr
    | arrayExpr SET_DIFF arrayExpr
    | inlineSet
    | id
    ;

inlineSet: LBRACKET (expr (COMMA expr)*)? RBRACKET;
tuple: LPAREN expr COMMA (expr (COMMA expr)*)? RPAREN;

// connect it all
expr
    : LPAREN expr RPAREN
    | id
    | num
    | arithExpr
    | arrayExpr
    | tuple
    | LPAREN boolExpr RPAREN
    ;

// structural rules
fact: KWD_ASSERT boolExpr;
assignment: id ASSIGN expr;
declaration: typeId;

typeDeclaration: KWD_TYPE simple_id LPAREN typeIdList RPAREN (LBRACKET fact* RBRACKET)?;
operation: KWD_OPERATION simple_id LPAREN typeIdList? RPAREN LBRACKET (fact | assignment)* RBRACKET;

schemaLine: typeDeclaration | fact | assignment | declaration | operation;
schema: KWD_SCHEMA simple_id LBRACKET schemaLine* RBRACKET;

// stuff
document: schema*;
