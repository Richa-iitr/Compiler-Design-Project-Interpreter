import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Define the Token class
class Token {
    public enum TokenType {
        PUBLIC,
        STATIC,
        CLASS,
        INT,
        VOID,
        MAIN,
        EQUALS,
        STRING,
        LBRACKET,
        RBRACKET,
        IDENTIFIER,
        LBRACE,
        INTEGER,
        RBRACE,
        LPAREN,
        RPAREN,
        SEMICOLON,
        EOF,
        PLUS,
        MINUS,
        ASTERISK,
        SLASH
    }

    private TokenType type;
    private String value;

    public Token(TokenType type, String value) {
        this.type = type;
        this.value = value;
    }

    public TokenType getType() {
        return type;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.format("Token(%s, %s)", type, value);
    }
}

// Define the Lexer class
class Lexer {
    private String input;
    private int position;
    private char currentChar;

    public Lexer(String input) {
        this.input = input;
        this.position = 0;
        this.currentChar = this.input.charAt(this.position);
    }

    private int integer() {
        StringBuilder result = new StringBuilder();
        while (this.currentChar != '\0' && Character.isDigit(this.currentChar)) {
            result.append(this.currentChar);
            this.advance();
        }
        // this.position++;
        return Integer.parseInt(result.toString());
    }

    private void advance() {
        this.position++;
        if (this.position > this.input.length() - 1) {
            this.currentChar = '\0'; // EOF
        } else {
            this.currentChar = this.input.charAt(this.position);
        }
    }

    private void skipWhiteSpace() {
        while (this.currentChar != '\0' && Character.isWhitespace(this.currentChar)) {
            this.advance();
        }
    }

    private String identifier() {
        StringBuilder result = new StringBuilder();
        while (this.currentChar != '\0' && Character.isLetterOrDigit(this.currentChar)) {
            result.append(this.currentChar);
            this.advance();
        }
        return result.toString();
    }

    public Token getNextToken() {
        while (this.currentChar != '\0') {
            if (Character.isWhitespace(this.currentChar)) {
                this.skipWhiteSpace();
                continue;
            }

            if (this.currentChar == '{') {
                this.advance();
                return new Token(Token.TokenType.LBRACE, "{");
            }
            if (this.currentChar == '[') {
                this.advance();
                return new Token(Token.TokenType.LBRACKET, "[");
            }

            if (this.currentChar == '(') {
                this.advance();
                return new Token(Token.TokenType.LPAREN, "(");
            }

            if (this.currentChar == '}') {
                this.advance();
                return new Token(Token.TokenType.RBRACE, "}");
            }
            if (this.currentChar == ']') {
                this.advance();
                return new Token(Token.TokenType.RBRACKET, "]");
            }
            if (this.currentChar == ')') {
                this.advance();
                return new Token(Token.TokenType.RPAREN, ")");
            }
            if (this.currentChar == '=') {
                this.advance();
                return new Token(Token.TokenType.EQUALS, "=");
            }

            if (this.currentChar == '-') {
                this.advance();
                return new Token(Token.TokenType.MINUS, "-");
            }
            if (this.currentChar == ';') {
                this.advance();
                return new Token(Token.TokenType.SEMICOLON, ";");
            }
            if (Character.isDigit(this.currentChar)) {
                return new Token(Token.TokenType.INTEGER, Integer.toString(this.integer()));
            }

            if (this.currentChar == 'p') {
                String keyword = this.input.substring(this.position, this.position + 6);
                if (keyword.equals("public")) {
                    this.advance();
                    this.advance();
                    this.advance();
                    this.advance();
                    this.advance();
                    this.advance();
                    return new Token(Token.TokenType.PUBLIC, "public");
                }
            }

            if(this.currentChar == 'i') {
                String keyword = this.input.substring(this.position, this.position + 3);
                if (keyword.equals("int")) {
                    this.advance();
                    this.advance();
                    this.advance();
                    return new Token(Token.TokenType.INT, "int");
                }
            }

            if (this.currentChar == 's') {
                String keyword = this.input.substring(this.position, this.position + 6);
                if (keyword.equals("static")) {
                    this.advance();
                    this.advance();
                    this.advance();
                    this.advance();
                    this.advance();
                    this.advance();
                    return new Token(Token.TokenType.STATIC, "static");
                }
            }

            if (this.currentChar == 'v') {
                String keyword = this.input.substring(this.position, this.position + 4);
                if (keyword.equals("void")) {
                    this.advance();
                    this.advance();
                    this.advance();
                    this.advance();
                    return new Token(Token.TokenType.VOID, "void");
                }
            }

            if (this.currentChar == 'm') {
                String keyword = this.input.substring(this.position, this.position + 4);
                if (keyword.equals("main")) {
                    this.advance();
                    this.advance();
                    this.advance();
                    this.advance();
                    return new Token(Token.TokenType.MAIN, "main");
                }
            }

             if (this.currentChar == 'S') {
                String keyword = this.input.substring(this.position, this.position + 6);
                if (keyword.equals("String")) {
                    this.advance();
                    this.advance();
                    this.advance();
                    this.advance();
                    this.advance();
                    this.advance();
                    return new Token(Token.TokenType.STRING, "String");
                }
            }

            if (this.currentChar == 'c') {
                String keyword = this.input.substring(this.position, this.position + 5);
                // System.out.println("key:" + keyword + " " + this.position);
                if (keyword.equals("class")) {
                    this.advance();
                    this.advance();
                    this.advance();
                    this.advance();
                    this.advance();
                    return new Token(Token.TokenType.CLASS, "class");
                }
            }

            if (Character.isLetter(this.currentChar)) {
                return new Token(Token.TokenType.IDENTIFIER, this.identifier());
            }

            throw new RuntimeException("Invalid character");
        }

        return new Token(Token.TokenType.EOF, "");
    }
}

// Define the Node classes
abstract class Node {
    public abstract String visit();
    public abstract int evaluate();
}

class IdentifierNode extends Node {
    private Token token;
    private String value;

    public IdentifierNode(Token token) {
        this.token = token;
        this.value = this.token.getValue();
    }

    public String getValue() {
        return value;
    }

    @Override
    public String visit() {
        return this.value;
    }
    @Override
    public int evaluate() {
        return 0;
    }


}

class classDeclarationNode extends Node {
    private IdentifierNode className;
    // private Token classKeyword;
    private List<Node> body;

    public classDeclarationNode(IdentifierNode className, List<Node> body) {
        // this.classKeyword = classKeyword;
        this.className = className;
        this.body = body;
    }

    public Node getClassName() {
        return className;
    }

    public List<Node> getBody() {
        return body;
    }

    public String toString() {
        return String.format("classDeclarationNode( %s, %s)", className.getValue(), body);
    }

@Override
    public int evaluate() {
        return 0;
    }
    @Override
    public String visit() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ");
        sb.append(this.className.visit());
        sb.append(" {\n");
        for (Node node : this.body) {
            sb.append(node.visit());
        }
        sb.append("}\n");
        return sb.toString();
    }

}

// Define the Interpreter class
class Interpreter {
    private Lexer lexer;
    private Token currentToken;

    public Interpreter(Lexer lexer) {
        this.lexer = lexer;
        this.currentToken = this.lexer.getNextToken();
    }

    private void eat(Token.TokenType tokenType) {
        // System.out.println(this.currentToken.getValue());
        if (this.currentToken.getType() == tokenType) {
            this.currentToken = this.lexer.getNextToken();
        } else {
            throw new RuntimeException("Invalid syntax");
        }
    }

    private IdentifierNode identifier() {
        IdentifierNode node = new IdentifierNode(this.currentToken);
        this.eat(Token.TokenType.IDENTIFIER);
        return node;
    }

private Node term() {
    Token token = this.currentToken;
    if (token.getType() == Token.TokenType.INTEGER) {
        this.eat(Token.TokenType.INTEGER);
        return new IntegerNode(token);
    } else if (token.getType() == Token.TokenType.LPAREN) {
        this.eat(Token.TokenType.LPAREN);
        Node node = this.expr();
        this.eat(Token.TokenType.RPAREN);
        return node;
    } else {
        throw new RuntimeException("Invalid syntax");
    }
}

class IntegerNode extends Node {
    private Token token;
    private int value;

    public IntegerNode(Token token) {
        this.token = token;
        this.value = Integer.parseInt(this.token.getValue());
    }

    public int getValue() {
        return value;
    }

    @Override
    public int evaluate() {
        return this.value;
    }

    @Override
    public String visit() {
        return Integer.toString(this.value);
    }
}

public Node expr() {
    Node node = this.term();
    // System.out.println(this.currentToken.getType());
    while (this.currentToken.getType() == Token.TokenType.PLUS || this.currentToken.getType() == Token.TokenType.MINUS) {
        Token token = this.currentToken;
        if (token.getType() == Token.TokenType.PLUS) {
            this.eat(Token.TokenType.PLUS);
        } else if (token.getType() == Token.TokenType.MINUS) {
            this.eat(Token.TokenType.MINUS);
        }

        node = new BinaryOperationNode(node, token, this.term());
    }

    return node;
}



    private Node expression() {
        Node node = this.expr();
        System.out.println("Result: " + node.evaluate());
        return node;
    }

    private Node mainFunction() {
        this.eat(Token.TokenType.PUBLIC);
        this.eat(Token.TokenType.STATIC);
        this.eat(Token.TokenType.VOID);
        this.eat(Token.TokenType.MAIN);
        this.eat(Token.TokenType.LPAREN);
        this.eat(Token.TokenType.STRING);
        this.eat(Token.TokenType.LBRACKET);
        this.eat(Token.TokenType.RBRACKET);
        this.eat(Token.TokenType.IDENTIFIER);
        this.eat(Token.TokenType.RPAREN);
        this.eat(Token.TokenType.LBRACE);
        this.eat(Token.TokenType.INT);
        this.eat(Token.TokenType.IDENTIFIER);
        this.eat(Token.TokenType.EQUALS);
        Node node = this.expression();
        this.eat(Token.TokenType.SEMICOLON);
        this.eat(Token.TokenType.RBRACE);
        return node;
    }

    private Node classDeclaration() {
        this.eat(Token.TokenType.PUBLIC);
        this.eat(Token.TokenType.CLASS);
        IdentifierNode classNameNode = this.identifier();
        List<Node> body = new ArrayList<>();
        this.eat(Token.TokenType.LBRACE);
        body.add(this.mainFunction());
        this.eat(Token.TokenType.RBRACE);
        return new classDeclarationNode(classNameNode, body);
    }

    public void parse() {
        Node node = this.classDeclaration();
    }
}


// Define the BinOpNode class
class BinaryOperationNode extends Node {
    private Node left;
    private Token operator;
    private Node right;

    public BinaryOperationNode(Node left, Token operator, Node right) {
        this.left = left;
        this.operator = operator;
        this.right = right;
    }

    public int evaluate() {
        int leftVal = Integer.parseInt(this.left.visit());
        int rightVal = Integer.parseInt(this.right.visit());

        switch (this.operator.getType()) {
            case PLUS:
                return leftVal + rightVal;
            case MINUS:
                return leftVal - rightVal;
            default:
                throw new RuntimeException("Invalid operator");
        }
    }

    @Override
    public String visit() {
        return "";
    }

}

// Example usage
public class JavaSubtractionInterpreter {
    public static void main(String[] args) {
        //change the input expression here: note for handling complex expressions like different variables names and then operating we can modify the way expr() is handled
    String input = "public class MyClass {\n" +
                   "    public static void main(String[] args) {\n" +
                   "        int x = 10 - 6;\n" +
                   "    }\n" +
                   "}";
    
    Lexer lexer = new Lexer(input);
    Interpreter interpreter = new Interpreter(lexer);
    interpreter.parse();
}
}
