grammar XPR;

@header {package z3fol.antlr;}

/*------------------------------------------------------------------
 * PARSER RULES
 *------------------------------------------------------------------*/

// Tokens
LPAREN: '(';
RPAREN: ')';
LBRACKET: '{';
RPRACKET: '}';
PLUS: '+';
MINUS: '-';
TIMES: '*';
DIV: '/';
GT: '>';
GE: '>=';
LE: '<=';
LT: '<';
EQ: '=';
NEQ: '!=';
ASSIGN: ':=';
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
SET_UNION: '∪';
SET_INTERSECT: '∩';

EXISTS: 'Exists';
FORALL: 'Forall';
KWD_TYPE: 'type';
KWD_DECLARE: 'declare';
KWD_ASSERT: 'assert';

NUM_DECIMAL: [0-9]+;
IDENTIFIER_UC : [A-Z_][a-zA-Z0-9_]*;
IDENTIFIER_LC : [a-z_][a-zA-Z0-9_]*;

Whitespace: [ \t]+ -> skip;
Newline: ('\r' '\n'? | '\n') -> skip;
BlockComment: '/*' .*? '*/' -> skip;
LineComment: '//' ~[\r\n]* -> skip;

// ---------------------------------------------------------------------------

// General rules
number: MINUS? ('0' | NUM_DECIMAL);

// Variable type. Can be either a plain identifier, a tuple or a generic type (eg. Set).
type: typeIdentifier | typeTuple | typeGeneric;
typeIdentifier: IDENTIFIER_UC;
typeTuple: LPAREN type (',' type)* RPAREN;
typeGeneric: typeIdentifier LT type GT;

// Variable usage
variable: variableIdentifier | variableTuple;
variableTuple: typeIdentifier LPAREN variable (',' variable)+ RPAREN;
variableIdentifier: IDENTIFIER_LC;
variableWithType: type variableIdentifier;
variableWithTypeList: variableWithType (',' variableWithType)*;

// General expression
anyExpression: variable | arithExpression | setExpression;

// Arithmetic expression
sumop: PLUS | MINUS;
mulop: TIMES | DIV;
arithExpression: arithSum;
arithExpressionList: arithExpression (',' arithExpression)*;
arithSum: arithMul (sumop arithMul)*;
arithMul: arithPow (mulop arithPow)*;
arithPow: arithAtom (POW arithExpression)?;
arithAtom: variableIdentifier | number | LPAREN arithExpression RPAREN;

// Set expression
setExpression: setSum;
setSum: setMul (SET_UNION setMul)*;
setMul: setAtom (SET_INTERSECT setAtom)*;
setAtom: variableIdentifier | inlineSet | LPAREN setExpression RPAREN;
inlineSet: LBRACKET arithExpressionList RPRACKET;

// Comparison statement
cmpop: LT | LE | GT | GE;
cmpStatement: arithExpression cmpop arithExpression;

// Equality statement
eqop: EQ | NEQ;
eqStatement: anyExpression eqop anyExpression;

// Set statement
setop: SET_IN | SET_NOTIN;
setStatement: anyExpression setop setExpression;

// General logic statement
logop: IMPLIES | IFF | XOR;
quantifiedStatement: ((FORALL | EXISTS) variableWithTypeList ':')? statement;
statement: disjunction (logop disjunction)?;
disjunction: conjunction (OR conjunction)*;
conjunction: statementAtom (AND statementAtom)*;
statementAtom: NOT? (variableIdentifier | setStatement | cmpStatement | eqStatement | LPAREN quantifiedStatement RPAREN);

// ---------------------------------------------------------------------------

// Document line varieties
typeDeclaration: KWD_TYPE typeIdentifier type?;
variableDeclaration: KWD_DECLARE variableWithType;
factDeclaration: KWD_ASSERT quantifiedStatement;
assignment: variableIdentifier ASSIGN anyExpression;

// Document structure
document: (line ';')*;
line: typeDeclaration | variableDeclaration | factDeclaration | assignment;