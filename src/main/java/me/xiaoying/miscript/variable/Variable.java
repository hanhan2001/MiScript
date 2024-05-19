package me.xiaoying.miscript.variable;

import me.xiaoying.miscript.Object;

public class Variable {
    private final Object type;
    private final String name;
    private Object value;

    public Variable(Object type, String name) {
        this.type = type;
        this.name = name;
    }

    public Variable(Object type, String name, Object value) {
        this.type = type;
        this.name = name;
    }

    public Object getType() {
        return this.type;
    }

    public String getName() {
        return this.name;
    }

    public Object getValue() {
        return this.value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}