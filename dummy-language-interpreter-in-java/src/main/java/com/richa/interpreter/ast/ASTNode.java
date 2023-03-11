package com.richa.interpreter.ast;

import java.io.Serializable;

import com.richa.interpreter.visitor.Visitable;

@SuppressWarnings("serial")
public abstract class ASTNode implements Visitable, Serializable {
    private transient Position start;

    public ASTNode(Position start) {
        this.start = start;
    }

    public Position getPosition() {
        return start;
    }
}
