BISON = bison -d --debug --verbose
FLEX = flex -t 
GCC = gcc -Wall -g
GPP = g++ -Wall -g
RM = rm -f -v

TARGET = rechenberg
LEXER = javalexer
PARSER = parse

ZIP = zip

ZIPFILES = src/$(LEXER).l src/$(PARSER).ypp src/main.cpp src/opdef.h Makefile test/* 


build:
	$(MAKE) -C src build

test: build
#	./$(TARGET) < test/test.java
	./$(TARGET) < test/bsp1.java
#	./$(TARGET) < test/bsp2.java
#	./$(TARGET) < test/bsp3.java
#	./$(TARGET) < test/bsp4.java
#	./$(TARGET) < test/bsp5.java


clean: 
	$(MAKE) -C src clean
	$(RM) $(TARGET)

zip:
	zip $(TARGET).zip $(ZIPFILES)


.PHONY: test build zip clean

