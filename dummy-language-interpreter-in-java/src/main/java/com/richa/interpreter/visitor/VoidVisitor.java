package com.richa.interpreter.visitor;

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
import com.richa.interpreter.ast.statement.VarDecl;
import com.richa.interpreter.ast.statement.WhileStatement;

public interface VoidVisitor<A> {
    void visit(Visitable v, A arg);

    void visit(Program p, A arg);

    void visit(IfStatement i, A arg);

    void visit(WhileStatement w, A arg);

    void visit(ForStatement f, A arg);

    void visit(BlockStatement b, A arg);

    void visit(PrintStatement p, A arg);

    void visit(ReturnStatement r, A arg);

    void visit(BreakStatement b, A arg);

    void visit(ContinueStatement c, A arg);

    void visit(VarDecl v, A arg);

    void visit(ArrayDecl a, A arg);

    void visit(ArithmeticBinExpression e, A arg);

    void visit(LogicalExpression l, A arg);

    void visit(RelationalExpression r, A arg);

    void visit(EqualityExpression e, A arg);

    void visit(LogicalNotExpression n, A arg);

    void visit(PostIncrementOperation p, A arg);

    void visit(PreIncrementOperation p, A arg);

    void visit(AssignExpression e, A arg);

    void visit(CastExpression c, A arg);

    void visit(FloatLiteral f, A arg);

    void visit(IntegerLiteral i, A arg);

    void visit(BooleanLiteral b, A arg);

    void visit(StringLiteral s, A arg);

    void visit(VarLiteral v, A arg);

    void visit(ArrayAccess a, A arg);

    void visit(FuncCallExpression f, A arg);

    void visit(FuncDecl d, A arg);
}
