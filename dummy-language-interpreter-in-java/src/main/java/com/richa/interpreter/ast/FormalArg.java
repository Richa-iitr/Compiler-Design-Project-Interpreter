package com.richa.interpreter.ast;

import com.richa.interpreter.ast.type.Type;
import com.richa.interpreter.visitor.GenericVisitor;
import com.richa.interpreter.visitor.VoidVisitor;

@SuppressWarnings("serial")
public class FormalArg extends ASTNode {
    private Type type;
    private Identifier id;

    public FormalArg(Position pos, Type type, Identifier id) {
        super(pos);
        this.type = type;
        this.id = id;
    }

    @Override
    public <A> void accept(VoidVisitor<A> v, A arg) {
        v.visit(this, arg);
    }

    @Override
    public <T, A> T accept(GenericVisitor<T, A> v, A arg) {
        return v.visit(this, arg);
    }

    public Type getType() {
        return type;
    }

    public Identifier getIdentifier() {
        return id;
    }

    @Override
    public String toString() {
        return type + " " + id.getVal();
    }

}