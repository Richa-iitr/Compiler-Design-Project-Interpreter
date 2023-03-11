package com.richa.interpreter.ast.statement;

import com.richa.interpreter.ast.Position;
import com.richa.interpreter.ast.expression.Expression;
import com.richa.interpreter.visitor.GenericVisitor;
import com.richa.interpreter.visitor.VoidVisitor;

@SuppressWarnings("serial")
public class WhileStatement extends Statement {
    private Expression condition;
    private Statement body;

    public WhileStatement(Expression condition, Statement body, Position start) {
        super(start);
        this.condition = condition;
        this.body = body;
    }

    @Override
    public <A> void accept(VoidVisitor<A> v, A arg) {
        v.visit(this, arg);
    }

    @Override
    public <T, A> T accept(GenericVisitor<T, A> v, A arg) {
        return v.visit(this, arg);
    }

    public Expression getCondition() {
        return condition;
    }

    public Statement getBody() {
        return body;
    }

}
