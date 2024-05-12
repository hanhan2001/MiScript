package me.xiaoying.miscript.function.interpreter;

import me.xiaoying.miscript.function.Blank;

/**
 * 变量定义解释器
 */
public class VariableInterpreter extends Interpreter {
    public VariableInterpreter() {
        this(InterpreterPriority.LOWEST);
    }

    public VariableInterpreter(InterpreterPriority priority) {
        super(priority);
    }

    @Override
    public boolean match(String string) {
        return true;
    }

    @Override
    public InterpreterStatus run(String string, Blank blank) {
        
        return null;
    }
}