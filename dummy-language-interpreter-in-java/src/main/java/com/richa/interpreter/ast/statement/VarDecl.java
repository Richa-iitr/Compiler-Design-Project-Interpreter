package com.richa.interpreter.ast.statement;

import com.richa.interpreter.ast.Identifier;
import com.richa.interpreter.ast.Position;
import com.richa.interpreter.ast.expression.Expression;
import com.richa.interpreter.ast.type.Type;
import com.richa.interpreter.visitor.GenericVisitor;
import com.richa.interpreter.visitor.VoidVisitor;

@SuppressWarnings("serial")
public class VarDecl extends Statement {
    private Type type;
    private Identifier id;
    private Expression init;

    public VarDecl(Position pos, Type type, Identifier id) {
        super(pos);
        this.type = type;
        this.id = id;
    }

    public VarDecl(Position pos, Type type, Identifier id, Expression init) {
        this(pos, type, id);
        this.init = init;
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

    public Identifier getId() {
        return id;
    }

    public Expression getInitializer() {
        return init;
    }

}
