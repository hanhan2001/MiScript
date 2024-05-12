package me.xiaoying.miscript.function.interpreter;

import me.xiaoying.miscript.function.Blank;

public abstract class Interpreter {
    private final InterpreterPriority priority;

    public Interpreter(InterpreterPriority priority) {
        this.priority = priority;
    }

    public InterpreterPriority getPriority() {
        return priority;
    }

    public abstract boolean match(String string);

    public abstract InterpreterStatus run(String string, Blank blank);
}