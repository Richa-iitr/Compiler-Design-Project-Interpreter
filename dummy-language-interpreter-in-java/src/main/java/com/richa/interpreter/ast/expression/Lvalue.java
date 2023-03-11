package com.richa.interpreter.ast.expression;

import com.richa.interpreter.ast.Position;

@SuppressWarnings("serial")
public abstract class Lvalue extends Expression {

    public Lvalue(Position start) {
        super(start);
    }

}
