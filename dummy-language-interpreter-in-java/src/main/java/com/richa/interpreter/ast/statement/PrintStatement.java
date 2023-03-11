package com.richa.interpreter.ast.statement;

import com.richa.interpreter.ast.Position;
import com.richa.interpreter.ast.expression.Expression;
import com.richa.interpreter.visitor.GenericVisitor;
import com.richa.interpreter.visitor.VoidVisitor;

@SuppressWarnings("serial")
public class PrintStatement extends Statement {
    private Expression e;
    private boolean newLine;

    public PrintStatement(Position start, Expression e) {
        super(start);
        this.e = e;
    }

    public PrintStatement(Position start, Expression e, boolean newLine) {
        super(start);
        this.e = e;
        this.newLine = newLine;
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
        return e;
    }

    public boolean isNweLine() {
        return newLine;
    }

}
