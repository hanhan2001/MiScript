package me.xiaoying.miscript.function.interpreter;

public class PrintInterpreter extends Interpreter {
    public PrintInterpreter() {
        this(InterpreterPriority.HIGHEST);
    }

    public PrintInterpreter(InterpreterPriority priority) {
        super(priority);
    }

    @Override
    public boolean match(String string) {
        return string.startsWith("print") && string.endsWith(")");
    }

    @Override
    public InterpreterStatus run(String string) {
        if (string.contains("println("))
            string = string.replace("println(", "");
        string = string.replace(")", "");
        System.out.println(string);
        return InterpreterStatus.END;
    }
}