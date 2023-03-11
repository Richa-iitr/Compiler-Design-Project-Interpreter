package com.richa.interpreter.ast.expression;

import com.richa.interpreter.ast.Position;

@SuppressWarnings("serial")
public abstract class UnaryExpression extends Expression {
    private Expression expression;

    public UnaryExpression(Expression e, Position pos) {
        super(pos);
        this.expression = e;
    }

    public Expression getExpression() {
        return expression;
    }

}
