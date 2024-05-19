package me.xiaoying.miscript.interpreter;

import me.xiaoying.miscript.Blank;

/**
 * 解释器
 */
public abstract class Interpreter {
    private final InterpreterPriority priority;

    public Interpreter(InterpreterPriority priority) {
        this.priority = priority;
    }

    public InterpreterPriority getPriority() {
        return this.priority;
    }

    public abstract boolean match(String string);

    public abstract InterpreterStatus run(String string, Blank blank);
}