package com.richa.interpreter.ast.expression;

import com.richa.interpreter.ast.Identifier;
import com.richa.interpreter.visitor.GenericVisitor;
import com.richa.interpreter.visitor.VoidVisitor;
import java.util.Collection;

@SuppressWarnings("serial")
public class FuncCallExpression extends Expression {
    private static final Expression[] VOID_ARGS = new Expression[0];

    private Identifier funcName;
    private Expression[] args;
    private boolean isNative;

    public FuncCallExpression(Identifier funcName, Collection<Expression> args) {
        super(funcName.getPosition());
        this.args = args == null ? VOID_ARGS : args.toArray(new Expression[args.size()]);
        this.funcName = funcName;
    }

    public FuncCallExpression(Identifier funcName) {
        this(funcName, null);
    }

    @Override
    public <T, A> T accept(GenericVisitor<T, A> v, A arg) {
        return v.visit(this, arg);
    }

    @Override
    public <A> void accept(VoidVisitor<A> v, A arg) {
        v.visit(this, arg);
    }

    public Identifier getFuncName() {
        return funcName;
    }

    public Expression[] getArgs() {
        return args;
    }

    public boolean isNative() {
        return isNative;
    }

    public void setNative(boolean isNative) {
        this.isNative = isNative;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(funcName.getVal() + "(");

        for(int i = 0; i < args.length; i++) {
            sb.append(args[i]);
            if(i < args.length - 1)
                sb.append(", ");
        }

        sb.append(")");
        return sb.toString();
    }
}
