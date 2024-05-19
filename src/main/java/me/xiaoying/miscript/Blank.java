package me.xiaoying.miscript;

import me.xiaoying.miscript.interpreter.InterpreterStatus;
import me.xiaoying.miscript.variable.Variable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Blank implements Cloneable {
    private final Clazz clazz;
    private Blank parent;
    private final Map<Integer, String> knownIndex = new HashMap<>();
    private final Map<Integer, Blank> knownBlanks = new HashMap<>();
    private final Map<Integer, List<Variable>> variables = new HashMap<>();

    public Blank(int index, String content, Clazz clazz) {
        this.clazz = clazz;

        this.init(index, content);
    }

    public Blank(int index, String content, Clazz clazz, Blank parent) {
        this.clazz = clazz;
        this.parent = parent;

        this.init(index, content);
    }

    private void init(int index, String content) {
        String[] split = content.split("\n");
        for (String string : split) {
            this.insert(index, string);
            index++;
        }
    }

    public void setVariable() {

    }

    public Clazz getClazz() {
        return this.clazz;
    }

    public Blank getParent() {
        return this.parent;
    }

    public void insert(int index, String string) {
        this.knownIndex.put(index, string);
    }

    public void run() {
        for (Integer integer : this.knownIndex.keySet()) {
            if (this.knownIndex.get(integer) == null || this.knownIndex.get(integer).isEmpty())
                continue;

            InterpreterStatus status =  this.clazz.getLoader().getInterpreterManager().interpreter(this.knownIndex.get(integer), this);
            if (status == InterpreterStatus.ERROR) {
                System.err.println("Error: <" + this.getClazz().getName() + "-line:" + integer + "> -> " + this.knownIndex.get(integer));
                return;
            }
        }
    }

    @Override
    public Blank clone() {
        try {
            Blank clone = (Blank) super.clone();
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}