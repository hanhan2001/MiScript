package me.xiaoying.miscript.function.interpreter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InterpreterManager {
    private Map<InterpreterPriority, List<Interpreter>> knownInterpreter = new HashMap<>();

    public void registerInterpreter(Interpreter interpreter) {
        List<Interpreter> list;
        if ((list = this.knownInterpreter.get(interpreter.getPriority())) == null)
            list = new ArrayList<>();

        list.add(interpreter);
        this.knownInterpreter.put(interpreter.getPriority(), list);
    }

    public boolean interpreter(String string) {
        InterpreterStatus status = null;
        if (this.knownInterpreter.get(InterpreterPriority.LOWEST) != null) {
            for (Interpreter interpreter : this.knownInterpreter.get(InterpreterPriority.LOWEST)) {
                status = interpreter.run(string);
                if (status == InterpreterStatus.END)
                    return true;

                if (status == InterpreterStatus.ERROR)
                    return false;
            }
        }

        if (this.knownInterpreter.get(InterpreterPriority.LOW) != null) {
            for (Interpreter interpreter : this.knownInterpreter.get(InterpreterPriority.LOW)) {
                status = interpreter.run(string);
                if (status == InterpreterStatus.END)
                    return true;

                if (status == InterpreterStatus.ERROR)
                    return false;
            }
        }

        if (this.knownInterpreter.get(InterpreterPriority.NORMAL) != null) {
            for (Interpreter interpreter : this.knownInterpreter.get(InterpreterPriority.NORMAL)) {
                status = interpreter.run(string);
                if (status == InterpreterStatus.END)
                    return true;

                if (status == InterpreterStatus.ERROR)
                    return false;
            }
        }

        if (this.knownInterpreter.get(InterpreterPriority.HIGH) != null) {
            for (Interpreter interpreter : this.knownInterpreter.get(InterpreterPriority.HIGH)) {
                status = interpreter.run(string);
                if (status == InterpreterStatus.END)
                    return true;

                if (status == InterpreterStatus.ERROR)
                    return false;
            }
        }

        if (this.knownInterpreter.get(InterpreterPriority.HIGHEST) != null) {
            for (Interpreter interpreter : this.knownInterpreter.get(InterpreterPriority.HIGHEST)) {
                status = interpreter.run(string);
                if (status == InterpreterStatus.END)
                    return true;

                if (status == InterpreterStatus.ERROR)
                    return false;
            }
        }

        if (status == null)
            return false;
        return true;
    }
}