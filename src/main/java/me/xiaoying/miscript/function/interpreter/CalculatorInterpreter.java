package me.xiaoying.miscript.function.interpreter;

import me.xiaoying.miscript.function.Blank;

public class CalculatorInterpreter extends Interpreter {
    public CalculatorInterpreter() {
        this(InterpreterPriority.LOWEST);
    }

    public CalculatorInterpreter(InterpreterPriority priority) {
        super(priority);
    }

    @Override
    public boolean match(String string) {
        return true;
    }

    @Override
    public InterpreterStatus run(String string, Blank blank) {
        return InterpreterStatus.RUNNING;
    }
}