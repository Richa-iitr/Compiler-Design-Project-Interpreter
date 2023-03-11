package com.richa.interpreter.semantic;

import com.richa.interpreter.ErrUtils;
import com.richa.interpreter.ast.FuncDecl;
import com.richa.interpreter.ast.Program;
import com.richa.interpreter.ast.expression.ArithmeticBinExpression;
import com.richa.interpreter.ast.expression.ArrayAccess;
import com.richa.interpreter.ast.expression.AssignExpression;
import com.richa.interpreter.ast.expression.BooleanLiteral;
import com.richa.interpreter.ast.expression.CastExpression;
import com.richa.interpreter.ast.expression.EqualityExpression;
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
import com.richa.interpreter.ast.type.Type;
import com.richa.interpreter.visitor.GenericVisitor;
import com.richa.interpreter.visitor.Visitable;

/**
 * AST walker that checks if every functions declaring a return type actually
 * returns on every execution path.
 * 
 *
 */
public class ReturnChecker implements GenericVisitor<Boolean, Void> {

    @Override
    public Boolean visit(Program p, Void arg) {
        for(String id : p.getFunctions().keySet()) {
            p.getFunctions().get(id).accept(this, arg);
        }

        return null;
    }

    @Override
    public Boolean visit(FuncDecl d, Void arg) {
        boolean ret = d.getBody().accept(this, arg);
        if(!ret && d.getType() != Type.VOID) {
            ErrUtils.semanticError(d.getPosition(),
                    "Function `%s` declares return type of %s, but does not return.", d.getId(),
                    d.getType().toString().toLowerCase());
        }
        return ret;
    }

    @Override
    public Boolean visit(BlockStatement v, Void arg) {
        boolean ret = false;

        int i;
        for(i = 0; i < v.getStmts().length; i++) {
            Statement s = v.getStmts()[i];
            ret |= s.accept(this, arg);
            if(ret)
                break;
        }

        if(i < v.getStmts().length - 1) {
            ErrUtils.semanticError(v.getStmts()[i + 1].getPosition(), "Unreachable code.");
        }

        return ret;
    }

    @Override
    public Boolean visit(ForStatement v, Void arg) {
        v.getBody().accept(this, arg);
        return false;
    }

    @Override
    public Boolean visit(WhileStatement v, Void arg) {
        v.getBody().accept(this, arg);
        return false;
    }

    @Override
    public Boolean visit(IfStatement v, Void arg) {
        boolean thenStmt = v.getThenStmt().accept(this, arg);
        boolean elseStmt = v.getElseStmt() == null ? false : v.getElseStmt().accept(this, arg);

        return thenStmt && elseStmt;
    }

    @Override
    public Boolean visit(ReturnStatement r, Void arg) {
        return true;
    }

    @Override
    public Boolean visit(Visitable v, Void arg) {
        return false;
    }

    @Override
    public Boolean visit(PrintStatement p, Void arg) {
        return false;
    }

    @Override
    public Boolean visit(VarDecl v, Void arg) {
        return false;
    }

    @Override
    public Boolean visit(ArrayDecl a, Void arg) {
        return false;
    }

    @Override
    public Boolean visit(ArithmeticBinExpression e, Void arg) {
        return false;
    }

    @Override
    public Boolean visit(LogicalExpression l, Void arg) {
        return false;
    }

    @Override
    public Boolean visit(EqualityExpression e, Void arg) {
        return false;
    }

    @Override
    public Boolean visit(RelationalExpression r, Void arg) {
        return false;
    }

    @Override
    public Boolean visit(LogicalNotExpression n, Void arg) {
        return false;
    }

    @Override
    public Boolean visit(PostIncrementOperation p, Void arg) {
        return false;
    }

    @Override
    public Boolean visit(PreIncrementOperation p, Void arg) {
        return false;
    }

    @Override
    public Boolean visit(AssignExpression e, Void arg) {
        return false;
    }

    @Override
    public Boolean visit(FloatLiteral f, Void arg) {
        return false;
    }

    @Override
    public Boolean visit(IntegerLiteral i, Void arg) {
        return false;
    }

    @Override
    public Boolean visit(BooleanLiteral b, Void arg) {
        return false;
    }

    @Override
    public Boolean visit(StringLiteral s, Void arg) {
        return false;
    }

    @Override
    public Boolean visit(VarLiteral v, Void arg) {
        return false;
    }

    @Override
    public Boolean visit(ArrayAccess a, Void arg) {
        return false;
    }

    @Override
    public Boolean visit(FuncCallExpression f, Void arg) {
        return false;
    }

    @Override
    public Boolean visit(CastExpression c, Void arg) {
        return false;
    }

    @Override
    public Boolean visit(BreakStatement b, Void arg) {
        return false;
    }

    @Override
    public Boolean visit(ContinueStatement c, Void arg) {
        return false;
    }

}
