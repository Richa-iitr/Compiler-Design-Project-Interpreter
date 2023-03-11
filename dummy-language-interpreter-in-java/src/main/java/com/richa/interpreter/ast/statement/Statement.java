package com.richa.interpreter.ast.statement;

import com.richa.interpreter.ast.ASTNode;
import com.richa.interpreter.ast.Position;

@SuppressWarnings("serial")
public abstract class Statement extends ASTNode {

    public Statement(Position start) {
        super(start);
    }

}
