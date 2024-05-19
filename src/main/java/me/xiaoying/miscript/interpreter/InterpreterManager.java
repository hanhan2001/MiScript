package me.xiaoying.miscript.interpreter;

import me.xiaoying.miscript.Blank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Interpreter Manager
 */
public class InterpreterManager {
    private final Map<InterpreterPriority, List<Interpreter>> knownInterpreter = new HashMap<>();

    /**
     * 注册解释器
     *
     * @param interpreter Interpreter
     */
    public void registerInterpreter(Interpreter interpreter) {
        List<Interpreter> list;
        if ((list = this.knownInterpreter.get(interpreter.getPriority())) == null)
            list = new ArrayList<>();

        list.add(interpreter);
        this.knownInterpreter.put(interpreter.getPriority(), list);
    }

    public InterpreterStatus interpreter(String string, Blank blank) {
        InterpreterStatus status;
        status = this.interpreter(InterpreterPriority.LOWEST, string, blank);
        if (status == InterpreterStatus.ERROR)
            return status;

        status = this.interpreter(InterpreterPriority.LOW, string, blank);
        if (status == InterpreterStatus.ERROR)
            return status;

        status = this.interpreter(InterpreterPriority.NORMAL, string, blank);
        if (status == InterpreterStatus.ERROR)
            return status;

        status = this.interpreter(InterpreterPriority.HIGH, string, blank);
        if (status == InterpreterStatus.ERROR)
            return status;

        status = this.interpreter(InterpreterPriority.HIGHEST, string, blank);
        if (status == InterpreterStatus.ERROR)
            return status;

        return InterpreterStatus.END;
    }

    private InterpreterStatus interpreter(InterpreterPriority priority, String string, Blank blank) {
        if (this.knownInterpreter.get(priority) == null)
            return InterpreterStatus.RUNNING;

        for (Interpreter interpreter : this.knownInterpreter.get(priority)) {
            if (!interpreter.match(string))
                continue;

            return interpreter.run(string, blank);
        }

        return InterpreterStatus.ERROR;
    }
}