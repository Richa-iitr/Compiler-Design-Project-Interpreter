package com.richa.interpreter.natives;

import com.richa.interpreter.ast.type.Type;
import com.richa.interpreter.interpret.Interpreter;

public class Substr extends Native<String> {
    public final static String ID = "substr";

    public Substr() {
        super(Type.STRING, ID, Type.STRING, Type.INT, Type.INT);
    }

    @Override
    public String call(Interpreter i, Object... args) {
        return ((String) args[0]).substring((int) args[1], (int) args[2]);
    }

}
