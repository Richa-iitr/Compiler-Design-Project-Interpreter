# Compiler-Design-Project-Interpreter

Code for Interpreter which takes JAVA program as input and performs simple arithmetic subtraction: 
Code for extended interpreter which performs print, arithmetic operations, function calls, loops etc with integers as well as doubles using regex for lexical analysis and ast for parsing: 

## Run the code:
## Interpreter 1:
```
javac JavaSubtractionInterpreter.java
```
```
java JavaSubtractionInterpreter
```
### Examples 
You can find some examples of the language in [line](https://github.com/Richa-iitr/Compiler-Design-Project-Interpreter/blob/main/JavaSubtractionInterpreter.java#L485)

### Output
![Screenshot from 2023-03-11 14-32-37](https://user-images.githubusercontent.com/76250660/224476959-8994cc36-8097-4cfe-a569-a25be49822cf.png)

```
4
```

## Interpreter-2
The grammar is C-like

For print with newline
```
println ""
```
replace double quotes with anystring you want to print or any variable.

For defining integers:
```
int x = 10
int y = -5
int res = x - y
```
where `x`, `y`, `res` and the values 10, -5 can be replaced by any valid name. The convention of variable names is similar to that of c.
For remaining grammar the [test](https://github.com/Richa-iitr/Compiler-Design-Project-Interpreter/blob/main/dummy-language-interpreter-in-java/src/main/resources/test.c%2B-) file can be referred 
### Examples 
You can find some examples of the language in [src/main/resources](https://github.com/Richa-iitr/Compiler-Design-Project-Interpreter/blob/main/dummy-language-interpreter-in-java/src/main/resources/test.c%2B-)

### Output
![Screenshot from 2023-03-11 14-59-25](https://user-images.githubusercontent.com/76250660/224476950-024cb023-3a64-4777-a5d5-b1ec325dcc28.png)


### Run
Compile it using the maven command: (If maven not installed install using `sudo apt install maven` in ubuntu)
```
mvn package
```
A jar file will be created in the `target` folder. Then, to run the interpreter, type in the terminal:
```
java -jar target/interpreter-1.0.jar src/main/resources/test.c+-
``` 
