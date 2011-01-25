#include <map>

enum MEASURE {
  M_SC,
  M_EC,
  M_DC
};

enum OP_ENUM {
  OP_BEGIN_EC=0,
  OP_PLUS = OP_BEGIN_EC,
  OP_MINUS,
  OP_MULT,
  OP_DIV,
  OP_REM,
  OP_INDEX,
  OP_BOOL_OP,
  OP_BEGIN_SC,
  OP_ASSIGN = OP_BEGIN_SC,
  OP_CLASSDEF,
  OP_METHODDEF,
  OP_IMPORT,
  OP_CONSTRUCTOR,
  OP_IF,
  OP_ELSE,
  OP_SWITCH,
  OP_CASE,
  OP_WHILE,
  OP_FOR,
  OP_DOWHILE,
  OP_TRY,
  OP_CATCH,
  OP_FINALLY,
  OP_CALL,
  OP_CALL_ARG,
  OP_NEW_CALL,
  OP_BEGIN_DC,
  OP_FIELDDEF = OP_BEGIN_DC,
  OP_VAR_INIT,
  OP_FORMAL_PARAM,
  OP_LOCAL_VAR
} ;


typedef int level_t;
typedef int count_t;

typedef std::map<level_t, count_t> count_per_level;
typedef std::map<OP_ENUM, count_per_level> op_count;
typedef std::map<MEASURE, op_count> count_per_measure;
extern count_per_measure counter;
