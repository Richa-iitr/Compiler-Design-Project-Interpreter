package com.richa.interpreter.interpret.expeval;

import com.richa.interpreter.ast.expression.ArrayAccess;
import com.richa.interpreter.ast.expression.AssignExpression;
import com.richa.interpreter.ast.expression.FuncCallExpression;
import com.richa.interpreter.ast.expression.Lvalue;
import com.richa.interpreter.ast.expression.VarLiteral;
import com.richa.interpreter.interpret.Interpreter;
import com.richa.interpreter.interpret.Return;
import com.richa.interpreter.interpret.RuntimeError;
import com.richa.interpreter.interpret.memenv.CmlArr;
import com.richa.interpreter.interpret.memenv.MemoryEnvironment.Frame;
import com.richa.interpreter.visitor.VisitorAdapter;

public class ArrayEval extends VisitorAdapter<CmlArr, Frame> {
    private Interpreter interpreter;

    public ArrayEval(Interpreter interpreter) {
        this.interpreter = interpreter;
    }

    @Override
    public CmlArr visit(VarLiteral v, Frame frame) {
        return (CmlArr) frame.retrieve(v);
    }

    @Override
    public CmlArr visit(ArrayAccess a, Frame frame) {
        return (CmlArr) frame.retrieve(a);
    }

    @Override
    public CmlArr visit(AssignExpression e, Frame frame) {
        CmlArr res = e.getExpression().accept(this, frame);
        frame.set((Lvalue) e.getLvalue(), res);
        return res;
    }

    @Override
    public CmlArr visit(FuncCallExpression f, Frame frame) {
        try {
            interpreter.callFunction(f);
        } catch (Return r) {
            return (CmlArr) r.val;
        }
        throw new RuntimeError(
                "Fatal error, function " + f + " declares return type but doesn't return");
    }

}
