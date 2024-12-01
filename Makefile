# Create cpp directory if it doesn't exist
$(shell mkdir -p cpp)

# Generate cpp file from parameter
gen-cpp:
	@read -p "Enter class name: " name; \
	echo "Creating cpp/$${name}.cpp"; \
	echo "#include <iostream>\n#include <vector>\n\n using namespace std;\n\nclass Solution {\npublic:\n};" > cpp/$${name}.cpp
