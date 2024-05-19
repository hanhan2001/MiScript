package me.xiaoying.miscript;

public class Method {
    private final String name;
    private final Blank blank;

    public Method(String name, Blank blank) {
        this.name = name;
        this.blank = blank;
    }

    public void run() {
        this.blank.clone().run();
    }
}