package me.xiaoying.miscript.function;

import me.xiaoying.miscript.function.interpreter.InterpreterManager;

import java.util.*;

public class Blank {
    private final String modifier;
    private final Set<Integer> index = new HashSet<>();
    private final Map<String, Object> variables = new HashMap<>();
    private final List<Blank> blanks = new ArrayList<>();
    private final Map<Integer, String> line = new HashMap<>();
    private final InterpreterManager interpreterManager;

    public Blank(String modifier, InterpreterManager interpreterManager) {
        this.modifier = modifier;
        this.interpreterManager = interpreterManager;
    }

    public String getModifier() {
        return this.modifier;
    }

    public void setIndex(int lineIndex) {
        this.index.add(lineIndex);
    }

    public boolean containIndex(int lineIndex) {
        return this.index.contains(lineIndex);
    }

    public void setBlank(Blank blank) {
        this.blanks.add(blank);
    }

    public void insert(int index, String string) {
        this.line.put(index, string);
    }

    public void insertVariable(String name, Object value) {
        if (this.variables.containsKey(name))
            return;

        this.variables.put(name, value);
    }

    public Object getVariable(String name) {
        return this.variables.get(name);
    }

    public void run() {
        for (Integer i : this.line.keySet()) {
            String string = this.line.get(i);
            if (this.interpreterManager.interpreter(string))
                continue;

            System.out.println("出错在: " + i + " -> " + string);
        }
    }
}