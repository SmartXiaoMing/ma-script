/* antlr4 SkillScript.g4 -no-listener -package com.xiaoming.script.api.utils.script */
lexer grammar MaScriptLexer;

LinesComment     : '/*' .*? '*/'             -> channel(HIDDEN);
LineComment      : '//' ~[\r\n\u2028\u2029]* -> channel(HIDDEN);

Null             : 'null' ;

Bool             : 'true'
                 | 'false'
                 ;

Int              : '0'
                 | [1-9] [0-9]*
                 ;

Float            : Int '.' [0-9]* ;

String           : '"' (ESC | ~["\\])* '"'
                 | '\'' (ESC | ~['\\])* '\''
                 ;

BackStringFormatOpen : 's`' -> pushMode(BackStringFormatMode) ;
StringFormatOpen : 's"' -> pushMode(StringFormatMode) ;

fragment ESC : '\\' ["\\/bfnrt] ;
WS           : [ \t\r\n]+ -> skip ;
WhiteSpaces  : [\t\u000B\u000C\u0020\u00A0]+ -> channel(HIDDEN);
LineEnd      : [\r\n\u2028\u2029] -> channel(HIDDEN);

Not          : '!'+  ;
Mult         : ('*' | '/' | '%') ;
Add          : ('+' | '-') ;
Relation     : ('<' | '>' | '<=' | '>=');
Eq           : ('==' | '!=' | '===' | '!==' | '~=');
AssignAppend : ('+=' | '-=' | '*=' | '/=' | '%=') ;
Inc          : ('++' | '--') ;
And          : '&&' | '&';
Or           : '||' | '|';
Query        : '?' ;
SquareOpen   : '[' ;
SquareClose  : ']' ;
Dot          : '.' ;
Assign       : '=' ;
BlockOpen    : '{' -> pushMode(DEFAULT_MODE) ;
BlockClose   : '}' -> popMode ;
ParenOpen    : '(' ;
ParenClose   : ')' ;
Colon        : ':' ;
Comma        : ',' ;
Semicolon    : ';' ;
Arrow        : '->' ;
Var          : 'var' ;
Function     : 'function' ;
Return       : 'return' ;
If           : 'if' ;
Else         : 'else' ;
For          : 'for' ;
Break        : 'break' ;
Continue     : 'continue' ;
Id           : [a-zA-Z_] [$a-zA-Z_0-9]* ;

mode StringFormatMode;

StringFormatClose  : '"' -> popMode ;
IdInterp           : '$' [A-Za-z_] [A-Za-z0-9_]* ;
ExprInterpOpen     : '${' -> pushMode(DEFAULT_MODE) ;
TextFormat         : (ESCFormat | ~["\\$])+ ;
fragment ESCFormat : '\\' ["\\/bfnrt$] ;

mode BackStringFormatMode;

BackStringFormatClose  : '`' -> popMode ;
BackIdInterp           : '$' [A-Za-z_] [A-Za-z0-9_]* ;
BackExprInterpOpen     : '${' -> pushMode(DEFAULT_MODE) ;
BackStringFormatSquare : '[' (~[`\\$[\]])+ ']';
BackTextFormat         : (BackESCFormat | ~[`\\$[\]])+ ;
fragment BackESCFormat : '\\' [`\\/bfnrt$[\]] ;