grammar Lispy;

@header {package eipifi.lispy.lang;}

/*------------------------------------------------------------------
 * PARSER RULES
 *------------------------------------------------------------------*/

// Tokens
LPAREN: '(';
RPAREN: ')';

Whitespace: [ \t]+ -> skip;
Newline: ('\r' '\n'? | '\n') -> skip;
BlockComment: '/*' .*? '*/' -> skip;
LineComment: '//' ~[\r\n]* -> skip;

ATOM: [A-Za-z0-9]+;

atom: ATOM;
par: atom | LPAREN atom par* RPAREN;
document: par*;