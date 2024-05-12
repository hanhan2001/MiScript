package me.xiaoying.miscript.function.interpreter;

import me.xiaoying.miscript.function.Blank;

public class PrintInterpreter extends Interpreter {
    public PrintInterpreter() {
        this(InterpreterPriority.HIGHEST);
    }

    public PrintInterpreter(InterpreterPriority priority) {
        super(priority);
    }

    @Override
    public boolean match(String string) {
        return (string.startsWith("println") || string.startsWith("print")) && string.endsWith(")");
    }

    @Override
    public InterpreterStatus run(String string, Blank blank) {
        string = string.replaceFirst("print\\(", "");
        string = string.replaceFirst("println\\(", "");
        string = string.replace(")", "");

        // 判断是否为变量
        if (blank.containsVariable(string))
            string = blank.getVariable(string).toString();

        System.out.println(string);
        return InterpreterStatus.END;
    }
}