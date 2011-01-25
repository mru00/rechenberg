#include <stdio.h>
#include <unistd.h>
#include <string.h>

#include <map>
#include <string>
#include <math.h>

#include "opdef.h"

struct {
  const char* name;
  double value;
} opinfo[] = {
  { "plus", 1.0 },
  { "minus",  1.0 },
  { "mult",  2.0 },
  { "div",  2.0 },
  { "rem",  3.0 },
  { "index", 2.0 },
  { "boolean op", 1.0 },
  { "assign",  1.0 },
  { "class", 1.0 },
  { "method",  1.0 },
  { "import",  1.0 },
  { "constructor", 1.0 },
  { "if",  1.0 },
  { "else",  1.0 },
  { "switch",  1.0 },
  { "case",  1.0 },
  { "while", 3.0 },
  { "for",  1.0 },
  { "do-while",  1.0 },
  { "try",  1.0 },
  { "catch",  1.0 },
  { "finally", 1.0 },
  { "call",  1.0 },
  { "call argument", 1.0 },
  { "new-call", 1.0 },
  { "field",  3.0 },
  { "var_init",  1.0 },
  { "formal param",  2.0 },
  { "local var",  1.0 },
};

float level_penalty = 1.5;

count_per_measure counter;

extern int yyparse();
extern int yydebug;



double count(op_count &what) {

  std::string name;
  double sum = 0.0;

  op_count::iterator it = what.begin();
  while ( it != what.end() ) {

    count_per_level::iterator level = it->second.begin();

    name.assign(opinfo[it->first].name);
    
    while (level != it->second.end()) {

      int l = std::max(level->first -2,0);
      int c = level->second;
      double value = pow(level_penalty,l)*c*opinfo[it->first].value; 
      sum += value;

      printf ( "%16s: level: %3d count: %3d value:%6.1f\n", 
	       name.c_str(), l, c, value );
      name = "|";
      level++;
    }

    it++;
  }
  return sum;
}


int main(int argc,char *argv[]) {
  yydebug = 0;
  yyparse();


  double sc = count(counter[M_SC]);
  printf("-> SC: %10.2f\n", sc);

  double ec = count(counter[M_EC]);
  printf("-> EC: %10.2f\n", ec);

  double dc = count(counter[M_DC]);
  printf("-> DC: %10.2f\n", dc);

  double cc = sc+ec+dc;
  printf("-> CC: %10.2f\n", cc);



  return 0;
}
