package com.richa.interpreter.ast.expression;

import com.richa.interpreter.ast.Position;
import com.richa.interpreter.ast.type.Type;
import com.richa.interpreter.visitor.GenericVisitor;
import com.richa.interpreter.visitor.VoidVisitor;

@SuppressWarnings("serial")
public class IntegerLiteral extends Expression {
    private int value;

    public IntegerLiteral(Position start, int value) {
        super(start);
        this.value = value;
        setType(Type.INT);
    }

    @Override
    public <A> void accept(VoidVisitor<A> v, A arg) {
        v.visit(this, arg);
    }

    @Override
    public <T, A> T accept(GenericVisitor<T, A> v, A arg) {
        return v.visit(this, arg);
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value + "";
    }
}
