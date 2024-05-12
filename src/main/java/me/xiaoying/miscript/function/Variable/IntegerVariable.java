package me.xiaoying.miscript.function.Variable;

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
}