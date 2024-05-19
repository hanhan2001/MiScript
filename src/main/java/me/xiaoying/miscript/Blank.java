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
    private final Map<Integer, List<Variable>> variables = new HashMap<>();

    public Blank(Clazz clazz) {
        this.clazz = clazz;

    }

    public Blank(Clazz clazz, Blank parent) {
        this.clazz = clazz;
        this.parent = parent;
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
            InterpreterStatus status =  this.clazz.getLoader().getInterpreterManager().interpreter(this.knownIndex.get(integer), this);
            if (status == InterpreterStatus.ERROR) {
                System.err.println("Error: <" + this.getClazz().getName() + "-line:" + integer + "> -> " + this.knownIndex.get(integer));
                return;
            }
        }
    }

    @Override
    protected java.lang.Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}