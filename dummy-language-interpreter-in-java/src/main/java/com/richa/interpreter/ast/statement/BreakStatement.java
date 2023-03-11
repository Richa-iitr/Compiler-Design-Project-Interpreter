package com.richa.interpreter.ast.statement;

import com.richa.interpreter.ast.Position;
import com.richa.interpreter.visitor.GenericVisitor;
import com.richa.interpreter.visitor.VoidVisitor;

@SuppressWarnings("serial")
public class BreakStatement extends Statement {

    public BreakStatement(Position start) {
        super(start);
    }

    @Override
    public <T, A> T accept(GenericVisitor<T, A> v, A arg) {
        return v.visit(this, arg);
    }

    @Override
    public <A> void accept(VoidVisitor<A> v, A arg) {
        v.visit(this, arg);
    }

}