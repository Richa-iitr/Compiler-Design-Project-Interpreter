package com.richa.interpreter.ast.expression;

import com.richa.interpreter.ast.Position;
import com.richa.interpreter.visitor.GenericVisitor;
import com.richa.interpreter.visitor.VoidVisitor;

@SuppressWarnings("serial")
public class PreIncrementOperation extends UnaryExpression {
    private IncrementOperator op;

    public PreIncrementOperation(IncrementOperator op, Expression e, Position pos) {
        super(e, pos);
        this.op = op;
    }

    @Override
    public <T, A> T accept(GenericVisitor<T, A> v, A arg) {
        return v.visit(this, arg);
    }

    @Override
    public <A> void accept(VoidVisitor<A> v, A arg) {
        v.visit(this, arg);
    }

    public IncrementOperator getOperator() {
        return op;
    }

    @Override
    public String toString() {
        return op.toString() + getExpression();
    }

}
