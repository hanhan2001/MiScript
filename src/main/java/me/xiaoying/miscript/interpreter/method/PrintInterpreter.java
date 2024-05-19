package me.xiaoying.miscript.interpreter.method;

import me.xiaoying.miscript.Blank;
import me.xiaoying.miscript.interpreter.Interpreter;
import me.xiaoying.miscript.interpreter.InterpreterPriority;
import me.xiaoying.miscript.interpreter.InterpreterStatus;

/**
 * Interpreter Print
 */
public class PrintInterpreter extends Interpreter {
    public PrintInterpreter() {
        this(InterpreterPriority.LOWEST);
    }

    public PrintInterpreter(InterpreterPriority priority) {
        super(priority);
    }

    @Override
    public boolean match(String string) {
        return (string.startsWith("println(") || string.startsWith("print(")) && string.endsWith(")");
    }

    @Override
    public InterpreterStatus run(String string, Blank blank) {
        string = string.replace(")", "");
        if (string.startsWith("println(")) {
            string = string.replaceFirst("println\\(", "");
            System.out.println(string);
            return InterpreterStatus.END;
        }

        string = string.replace("print(", "");
        System.out.print(string);
        return InterpreterStatus.END;
    }
}