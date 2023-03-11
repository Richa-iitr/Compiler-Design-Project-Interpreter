package com.richa.interpreter.natives;

import com.richa.interpreter.ast.type.Type;
import com.richa.interpreter.interpret.Interpreter;

public class StrLen extends Native<Integer> {
    public final static String ID = "strlen";

    public StrLen() {
        super(Type.INT, ID, Type.STRING);
    }

    @Override
    public Integer call(Interpreter i, Object... args) {
        return ((String) args[0]).length();
    }

}
