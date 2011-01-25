BISON = bison -d --debug --verbose
FLEX = flex -t 
GCC = gcc -Wall -g
GPP = g++ -Wall -g
RM = rm -f -v
MV = mv
CP = cp

TARGET = rechenberg
LEXER = javalexer
PARSER = parse

build: $(TARGET)
	$(CP) $(TARGET) ..

clean: 
	$(RM) *.o
	$(RM) *~
	$(RM) $(PARSER).tab.hpp
	$(RM) $(PARSER).tab.cpp
	$(RM) $(PARSER).output
	$(RM) $(LEXER).c
	$(RM) $(TARGET)

$(LEXER).c: $(LEXER).l $(PARSER).tab.cpp Makefile
	$(FLEX) $(LEXER).l > $(LEXER).c

$(LEXER).l: Makefile

$(PARSER).tab.cpp: $(PARSER).ypp Makefile
	$(BISON) $(PARSER).ypp

$(PARSER).ypp: Makefile

$(PARSER).tab.o: $(PARSER).tab.cpp
	$(GPP) -c $(PARSER).tab.cpp

main.o: main.cpp
	$(GPP) -c main.cpp

$(LEXER).o: $(LEXER).c
	$(GCC) -c $(LEXER).c

$(TARGET): $(LEXER).o $(PARSER).tab.o main.o
	$(GPP) $(LEXER).o $(PARSER).tab.o main.o -o $(TARGET)

.PHONY: build clean

