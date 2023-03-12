Compiler-Design-Project-Interpreter

Code for Interpreter which takes JAVA program as input and performs simple arithmetic subtraction: Code for extended interpreter which performs print, arithmetic operations, function calls, loops etc with integers as well as doubles using regex for lexical analysis and ast for parsing:

Run the code:

Interpreter 1:

javac JavaSubtractionInterpreter.java
java JavaSubtractionInterpreter

Examples
You can find some examples of the language in line, only change the expression in this line for different testcases
    int x = 10 - 6;
    int x = -10 - (-6);
    int x = -10 - (-7);

Output
Prints the difference 
4
-4
-3

Interpreter-2
The grammar is C-like

For print with newline

println ""
replace double quotes with any string you want to print or any variable.

For defining integers:

int x = 10
int y = -5
int res = x - y
where x, y, res and the values 10, -5 can be replaced by any valid name. The convention of variable names is similar to that of c. For remaining grammar the test file can be referred

Examples
You can find some examples of the language in src/main/resources/test.c+-

Output
The result of subtraction is as in the start of the output in the sample case. 

Run
Compile it using the maven command: (If maven not installed install using sudo apt install maven in ubuntu)

mvn package
A jar file will be created in the target folder. Then, to run the interpreter, type in the terminal:

java -jar target/interpreter-1.0.jar src/main/resources/test.c+-