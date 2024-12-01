generate:
	@read -p "Enter the day number: " day \
	&& mkdir -p day$$day \
	&& touch "day$$day/input.txt" "day$$day/test.txt" "day$$day/main.cpp" \
	&& echo "build:" > "day$$day/Makefile" \
	&& echo "	clang++ -std=c++17 -o main main.cpp" >> "day$$day/Makefile" \
	&& echo "clean:" >> "day$$day/Makefile" \
	&& echo "	rm -f main" >> "day$$day/Makefile" \
	&& echo "run:" >> "day$$day/Makefile" \
	&& echo "	./main input.txt" >> "day$$day/Makefile" \
	&& echo "_test:" >> "day$$day/Makefile" \
	&& echo "	./main test.txt" >> "day$$day/Makefile" \
	&& echo "all: build run" >> "day$$day/Makefile" \
	&& echo "test: build _test" >> "day$$day/Makefile"