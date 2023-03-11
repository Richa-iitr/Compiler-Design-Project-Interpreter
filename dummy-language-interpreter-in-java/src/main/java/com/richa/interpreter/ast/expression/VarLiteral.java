package com.richa.interpreter.ast.expression;

import com.richa.interpreter.ast.Identifier;
import com.richa.interpreter.visitor.GenericVisitor;
import com.richa.interpreter.visitor.VoidVisitor;

@SuppressWarnings("serial")
public class VarLiteral extends Lvalue {
    private Identifier id;

    public VarLiteral(Identifier id) {
        super(id.getPosition());
        this.id = id;
    }

    @Override
    public <T, A> T accept(GenericVisitor<T, A> v, A arg) {
        return v.visit(this, arg);
    }

    @Override
    public <A> void accept(VoidVisitor<A> v, A arg) {
        v.visit(this, arg);
    }

    public Identifier getId() {
        return id;
    }

    @Override
    public String toString() {
        return id.getVal();
    }

}
