package com.richa.interpreter.ast.statement;

import com.richa.interpreter.ast.Position;
import com.richa.interpreter.ast.expression.Expression;
import com.richa.interpreter.visitor.GenericVisitor;
import com.richa.interpreter.visitor.VoidVisitor;

@SuppressWarnings("serial")
public class ForStatement extends Statement {
    private Statement init;
    private Expression cond;
    private Expression act;

    private Statement body;

    public ForStatement(Position start, Statement init, Expression cond, Expression act,
            Statement body) {
        super(start);
        this.init = init;
        this.cond = cond;
        this.act = act;
        this.body = body;
    }

    @Override
    public <T, A> T accept(GenericVisitor<T, A> v, A arg) {
        return v.visit(this, arg);
    }

    @Override
    public <A> void accept(VoidVisitor<A> v, A arg) {
        v.visit(this, arg);
    }

    public Statement getInit() {
        return init;
    }

    public Expression getCond() {
        return cond;
    }

    public Expression getAct() {
        return act;
    }

    public Statement getBody() {
        return body;
    }

}
