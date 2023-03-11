package com.richa.interpreter.ast.expression;

import com.richa.interpreter.ast.Position;
import com.richa.interpreter.ast.statement.Statement;
import com.richa.interpreter.ast.type.Type;

@SuppressWarnings("serial")
public abstract class Expression extends Statement {
    private Type type;

    public Expression(Position start) {
        super(start);
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Type getType() {
        return type;
    }

}
