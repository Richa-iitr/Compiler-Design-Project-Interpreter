package com.richa.interpreter.visitor;

import com.richa.interpreter.ast.FuncDecl;
import com.richa.interpreter.ast.Program;
import com.richa.interpreter.ast.expression.ArithmeticBinExpression;
import com.richa.interpreter.ast.expression.ArrayAccess;
import com.richa.interpreter.ast.expression.AssignExpression;
import com.richa.interpreter.ast.expression.BooleanLiteral;
import com.richa.interpreter.ast.expression.CastExpression;
import com.richa.interpreter.ast.expression.EqualityExpression;
import com.richa.interpreter.ast.expression.Expression;
import com.richa.interpreter.ast.expression.FloatLiteral;
import com.richa.interpreter.ast.expression.FuncCallExpression;
import com.richa.interpreter.ast.expression.IntegerLiteral;
import com.richa.interpreter.ast.expression.LogicalExpression;
import com.richa.interpreter.ast.expression.LogicalNotExpression;
import com.richa.interpreter.ast.expression.PostIncrementOperation;
import com.richa.interpreter.ast.expression.PreIncrementOperation;
import com.richa.interpreter.ast.expression.RelationalExpression;
import com.richa.interpreter.ast.expression.StringLiteral;
import com.richa.interpreter.ast.expression.VarLiteral;
import com.richa.interpreter.ast.statement.ArrayDecl;
import com.richa.interpreter.ast.statement.BlockStatement;
import com.richa.interpreter.ast.statement.BreakStatement;
import com.richa.interpreter.ast.statement.ContinueStatement;
import com.richa.interpreter.ast.statement.ForStatement;
import com.richa.interpreter.ast.statement.IfStatement;
import com.richa.interpreter.ast.statement.PrintStatement;
import com.richa.interpreter.ast.statement.ReturnStatement;
import com.richa.interpreter.ast.statement.Statement;
import com.richa.interpreter.ast.statement.VarDecl;
import com.richa.interpreter.ast.statement.WhileStatement;

public class VoidVisitorAdapter<A> implements VoidVisitor<A> {

    @Override
    public void visit(Visitable v, A arg) {
    }

    @Override
    public void visit(Program p, A arg) {
        for(String id : p.getFunctions().keySet()) {
            p.getFunctions().get(id).accept(this, arg);
        }
    }

    @Override
    public void visit(IfStatement v, A arg) {
        v.getCondition().accept(this, arg);
        v.getThenStmt().accept(this, arg);
        if(v.getElseStmt() != null)
            v.getElseStmt().accept(this, arg);
    }

    @Override
    public void visit(WhileStatement v, A arg) {
        v.getCondition().accept(this, arg);
        v.getBody().accept(this, null);
    }

    @Override
    public void visit(ForStatement v, A arg) {
        if(v.getInit() != null)
            v.getInit().accept(this, arg);
        if(v.getCond() != null)
            v.getCond().accept(this, arg);
        if(v.getAct() != null)
            v.getAct().accept(this, arg);
        v.getBody().accept(this, arg);
    }

    @Override
    public void visit(BlockStatement v, A arg) {
        for(Statement s : v.getStmts()) {
            s.accept(this, arg);
        }
    }

    @Override
    public void visit(PrintStatement p, A arg) {
        p.getExpression().accept(this, arg);
    }

    @Override
    public void visit(ReturnStatement r, A arg) {
        if(r.getExpression() != null)
            r.getExpression().accept(this, arg);
    }

    @Override
    public void visit(BreakStatement b, A arg) {
    }

    @Override
    public void visit(ContinueStatement c, A arg) {
    }

    @Override
    public void visit(VarDecl v, A arg) {
        if(v.getInitializer() != null)
            v.getInitializer().accept(this, arg);
    }

    @Override
    public void visit(ArrayDecl a, A arg) {
        for(Expression e : a.getDimensions()) {
            e.accept(this, arg);
        }
    }

    @Override
    public void visit(ArithmeticBinExpression e, A arg) {
        e.getLeft().accept(this, arg);
        e.getRight().accept(this, arg);
    }

    @Override
    public void visit(LogicalExpression l, A arg) {
        l.getLeft().accept(this, arg);
        l.getRight().accept(this, arg);
    }

    @Override
    public void visit(RelationalExpression r, A arg) {
        r.getLeft().accept(this, arg);
        r.getRight().accept(this, arg);
    }

    @Override
    public void visit(EqualityExpression e, A arg) {
        e.getLeft().accept(this, arg);
        e.getRight().accept(this, arg);
    }

    @Override
    public void visit(LogicalNotExpression n, A arg) {
        n.getExpression().accept(this, arg);
    }

    @Override
    public void visit(PostIncrementOperation p, A arg) {
        p.getExpression().accept(this, arg);
    }

    @Override
    public void visit(PreIncrementOperation p, A arg) {
        p.getExpression().accept(this, arg);
    }

    @Override
    public void visit(AssignExpression e, A arg) {
        e.getLvalue().accept(this, arg);
        e.getExpression().accept(this, arg);
    }

    @Override
    public void visit(CastExpression c, A arg) {
        c.getExpression().accept(this, arg);
    }

    @Override
    public void visit(FloatLiteral f, A arg) {
    }

    @Override
    public void visit(IntegerLiteral i, A arg) {
    }

    @Override
    public void visit(BooleanLiteral b, A arg) {
    }

    @Override
    public void visit(StringLiteral s, A arg) {
    }

    @Override
    public void visit(VarLiteral v, A arg) {
    }

    @Override
    public void visit(ArrayAccess a, A arg) {
        a.getLvalue().accept(this, arg);
        a.getIndex().accept(this, arg);
    }

    @Override
    public void visit(FuncCallExpression f, A arg) {
        for(Expression e : f.getArgs()) {
            e.accept(this, arg);
        }
    }

    @Override
    public void visit(FuncDecl d, A arg) {
        d.getBody().accept(this, arg);
    }

}
