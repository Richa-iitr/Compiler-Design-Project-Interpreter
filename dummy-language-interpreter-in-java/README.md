# Interpreter

## What is it?
This project contains a toy c-like programming language. 
For now the language is implemented by an interpreter that runs directly on the parsed AST.

## Examples 
You can find some examples of the language in [src/main/resources](https://github.com/Richa-iitr/Compiler-Design-Project-Interpreter/blob/main/dummy-language-interpreter-in-java/src/main/resources/test.c%2B-)

## Run?
Compile it using the maven command: (If maven not installed install using `sudo apt install maven` in ubuntu)
```
mvn package
```
A jar file will be created in the `target` folder. Then, to run the interpreter, type in the terminal:
```
java -jar target/interpreter-1.0.jar src/main/resources/test.c+-
``` 
