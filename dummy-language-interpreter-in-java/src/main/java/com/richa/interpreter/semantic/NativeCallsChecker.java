package com.richa.interpreter.semantic;

import com.richa.interpreter.ErrUtils;
import com.richa.interpreter.ast.FuncDecl;
import com.richa.interpreter.ast.Program;
import com.richa.interpreter.ast.expression.Expression;
import com.richa.interpreter.ast.expression.FuncCallExpression;
import com.richa.interpreter.natives.Native;
import com.richa.interpreter.visitor.VoidVisitorAdapter;
import java.util.Map;

public class NativeCallsChecker extends VoidVisitorAdapter<Void> {
    private Map<String, Native<?>> natives;

    public NativeCallsChecker(Map<String, Native<?>> natives) {
        this.natives = natives;
    }

    @Override
    public void visit(Program p, Void arg) {
        for(String s : p.getFunctions().keySet()) {
            FuncDecl f = p.getFunctions().get(s);
            if(natives.containsKey(s)) {
                ErrUtils.semanticError(f.getPosition(), "Double declaration of native function %s",
                        s);
            }
            f.accept(this, null);
        }
    }

    @Override
    public void visit(FuncCallExpression f, Void arg) {
        for(Expression a : f.getArgs()) {
            a.accept(this, arg);
        }

        if(natives.containsKey(f.getFuncName().getVal()))
            f.setNative(true);
    }

}
