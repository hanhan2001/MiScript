package me.xiaoying.miscript.function.variable;

/**
 * Variable Integer
 */
public class IntegerVariable implements Variable {
    private final int value;

    public IntegerVariable(int number) {
        this.value = number;
    }

    @Override
    public Integer getValue() {
        return this.value;
    }

    @Override
    public boolean match(String string) {
        return false;
    }
}