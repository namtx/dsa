build:
	clang++ -std=c++17 -o main main.cpp
clean:
	rm -f main
run:
	./main input.txt
_test:
	./main test.txt
all: build run
test: build _test
