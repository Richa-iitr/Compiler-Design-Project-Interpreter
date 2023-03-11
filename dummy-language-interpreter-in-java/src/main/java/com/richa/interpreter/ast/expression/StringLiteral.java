package com.richa.interpreter.ast.expression;

import com.richa.interpreter.ast.Position;
import com.richa.interpreter.ast.type.Type;
import com.richa.interpreter.visitor.GenericVisitor;
import com.richa.interpreter.visitor.VoidVisitor;

@SuppressWarnings("serial")
public class StringLiteral extends Expression {
    private String value;

    public StringLiteral(Position pos, String value) {
        super(pos);
        this.value = value;
        setType(Type.STRING);
    }

    @Override
    public <T, A> T accept(GenericVisitor<T, A> v, A arg) {
        return v.visit(this, null);
    }

    @Override
    public <A> void accept(VoidVisitor<A> v, A arg) {
        v.visit(this, null);
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "\"" + value.replaceAll("\n", "\\\\n") + "\"";
    }

}
