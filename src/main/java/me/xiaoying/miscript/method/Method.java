package me.xiaoying.miscript.method;

import me.xiaoying.miscript.Blank;

public class Method {
    private final String name;
    private final Blank blank;
    private MethodType methodType = MethodType.PRIVATE;
    private boolean isStatic = false;

    public Method(int index, String name, Blank blank) {
        this.name = name;
        this.blank = blank;
    }

    public void run() {
        this.blank.clone().run();
    }

    public void setMethodType(MethodType type) {
        this.methodType = type;
    }

    public MethodType getMethodType() {
        return this.methodType;
    }

    public boolean isStatic() {
        return this.isStatic;
    }

    public void setStatic(boolean value) {
        this.isStatic = value;
    }
}