%{
  #include <stdio.h>
  #include <unistd.h>
  #include <string.h>

#include "parse.tab.hpp"

static int nlines = 1;
extern int yywrap();
%}


ID       [a-zA-Z][_a-zA-Z0-9]*

INT_LIT   [0-9]+
FLOAT_LIT [0-9]+\.[0-9]*
CHAR_LIT  '[a-zA-Z0-9]'
STRING_LIT (\"[^\n"]*\")

COMMENT1  (\/\/[^\n]*)
COMMENT2  (\/\*([^\*]|\*[^/])*\*\/)

%%

{COMMENT2} 
{COMMENT1} 

throws     { return THROWS_TK; }

int        { return INTEGRAL_TK; }
boolean    { return BOOLEAN_TK; }
char       { return CHAR_TK; }
byte       { return BYTE_TK; }
short      { return SHORT_TK; }
long       { return LONG_TK; }
float      { return FLOAT_TK; }
double     { return INTEGRAL_TK; }

super      { return SUPER_TK; }
class      { return CLASS_TK; }
extends    { return EXTENDS_TK; }
implements { return IMPLEMENTS_TK; }
import     { return IMPORT_TK; }
package    { return PACKAGE_TK; }

private    { return MODIFIER_TK; }
protected  { return MODIFIER_TK; }
public     { return MODIFIER_TK; }
final      { return MODIFIER_TK; }
abstract   { return MODIFIER_TK; }
native     { return MODIFIER_TK; }
transient  { return MODIFIER_TK; }
volatile   { return MODIFIER_TK; }
strictfp   { return MODIFIER_TK; }
static     { return MODIFIER_TK; }

this       { return THIS_TK; }
void       { return VOID_TK; }
new        { return NEW_TK; }

true       { return BOOL_LIT_TK; }
false      { return BOOL_LIT_TK; }

switch     { return SWITCH_TK; }
assert     { return ASSERT_TK; }

case       { return CASE_TK; }
default    { return DEFAULT_TK; }

if         { return IF_TK; }
else       { return ELSE_TK; }
while      { return WHILE_TK; }
do         { return DO_TK; }
for        { return FOR_TK; }
null       { return NULL_TK; }
break      { return BREAK_TK; }
continue   { return CONTINUE_TK; }
return     { return RETURN_TK; }
throw      { return THROW_TK; }
try        { return TRY_TK; }
catch      { return CATCH_TK; }

finally    { return FINALLY_TK; }
instanceof { return INSTANCEOF_TK; }

\<\<       { return LS_TK; }
\>\>       { return SRS_TK; }
\>\>\>     { return ZRS_TK; }

\+\+         { return INCR_TK; }
--         { return DECR_TK; }

\(        { return OP_TK; }
\)        { return CP_TK; }
\{        { return OCB_TK; }
\}        { return CCB_TK; }

\[        { return OSB_TK; }
\]        { return CSB_TK; }

==        { return EQ_TK; }
!=        { return NEQ_TK; }
\>         { return GT_TK; }
\>=        { return GTE_TK; }
\<         { return LT_TK; }
\<=        { return LTE_TK; }

&         { return AND_TK; }
\|\|        { return BOOL_OR_TK; }
&&        { return BOOL_AND_TK; }

\|         { return OR_TK; } 
\^         { return XOR_TK; }
,         { return C_TK; }
\.        { return DOT_TK; }

!         { return NOT_TK; }
~         { return NEG_TK; }
;         { return SC_TK; }
:         { return REL_CL_TK; }
\?         { return REL_QM_TK; }

{FLOAT_LIT} {return FP_LIT_TK; }
{CHAR_LIT} {return CHAR_LIT_TK;}
{STRING_LIT} {return STRING_LIT_TK;}
{INT_LIT} { return INT_LIT_TK; }


{ID}      { yylval.str = strdup(yytext); return(ID_TK); }



\*=         { return ASSIGN_TK; }
\/=         { return ASSIGN_TK; }
%=          { return ASSIGN_TK; }
\+=         { return ASSIGN_TK; }
-=          { return ASSIGN_TK; }
\<\<=       { return ASSIGN_TK; }
\>\>=       { return ASSIGN_TK; }
\>\>\>=     { return ASSIGN_TK; }
&=          { return ASSIGN_TK; }
\^=         { return ASSIGN_TK; }
\|=         { return ASSIGN_TK; }


=           { return (ASSIGN_TK); }



\+         { return PLUS_TK; }
-         { return MINUS_TK; }
\*         { return MULT_TK; }
\/         { return DIV_TK; }
%         { return REM_TK; }

\n        { nlines ++; }
.                ;


%%
