package com.richa.interpreter.interpret;

@SuppressWarnings("serial")
public class RuntimeError extends Error {
    public RuntimeError(String msg) {
        super(msg);
    }
}
