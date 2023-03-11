package com.richa.interpreter.ast.statement;

import java.util.Collection;

import com.richa.interpreter.ast.Identifier;
import com.richa.interpreter.ast.Position;
import com.richa.interpreter.ast.expression.Expression;
import com.richa.interpreter.ast.type.Type;
import com.richa.interpreter.visitor.GenericVisitor;
import com.richa.interpreter.visitor.VoidVisitor;

@SuppressWarnings("serial")
public class ArrayDecl extends Statement {
    private Identifier id;
    private Expression[] dimensions;
    private Type type;

    public ArrayDecl(Position start, Type type, Collection<Expression> dimensions, Identifier id) {
        super(start);
        this.dimensions = dimensions.toArray(new Expression[dimensions.size()]);
        this.type = type;
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

    public Type getType() {
        return type;
    }

    public Expression[] getDimensions() {
        return dimensions;
    }

    public Identifier getId() {
        return id;
    }

}
