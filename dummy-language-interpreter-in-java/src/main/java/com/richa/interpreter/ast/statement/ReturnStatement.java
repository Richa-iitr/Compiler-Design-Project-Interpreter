package com.richa.interpreter.ast.statement;

import com.richa.interpreter.ast.Position;
import com.richa.interpreter.ast.expression.Expression;
import com.richa.interpreter.visitor.GenericVisitor;
import com.richa.interpreter.visitor.VoidVisitor;

@SuppressWarnings("serial")
public class ReturnStatement extends Statement {
    private Expression expression;

    public ReturnStatement(Position start, Expression exp) {
        super(start);
        this.expression = exp;
    }

    @Override
    public <T, A> T accept(GenericVisitor<T, A> v, A arg) {
        return v.visit(this, arg);
    }

    @Override
    public <A> void accept(VoidVisitor<A> v, A arg) {
        v.visit(this, arg);
    }

    public Expression getExpression() {
        return expression;
    }

    public void setExpression(Expression e) {
        this.expression = e;
    }

}
