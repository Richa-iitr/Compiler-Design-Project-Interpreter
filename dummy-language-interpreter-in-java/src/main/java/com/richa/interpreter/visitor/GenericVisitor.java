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

public interface GenericVisitor<T, A> {
    T visit(Visitable v, A arg);

    T visit(Program p, A arg);

    T visit(IfStatement i, A arg);

    T visit(WhileStatement w, A arg);

    T visit(BlockStatement b, A arg);

    T visit(ForStatement f, A arg);

    T visit(PrintStatement p, A arg);

    T visit(ReturnStatement r, A arg);

    T visit(BreakStatement b, A arg);

    T visit(ContinueStatement c, A arg);

    T visit(VarDecl v, A arg);

    T visit(ArrayDecl a, A arg);

    T visit(ArithmeticBinExpression e, A arg);

    T visit(LogicalExpression l, A arg);

    T visit(EqualityExpression e, A arg);

    T visit(RelationalExpression r, A arg);

    T visit(LogicalNotExpression n, A arg);

    T visit(PostIncrementOperation p, A arg);

    T visit(PreIncrementOperation p, A arg);

    T visit(AssignExpression e, A arg);

    T visit(CastExpression c, A arg);

    T visit(FloatLiteral f, A arg);

    T visit(IntegerLiteral i, A arg);

    T visit(BooleanLiteral b, A arg);

    T visit(StringLiteral s, A arg);

    T visit(VarLiteral v, A arg);

    T visit(ArrayAccess a, A arg);

    T visit(FuncCallExpression f, A arg);

    T visit(FuncDecl d, A arg);
}
