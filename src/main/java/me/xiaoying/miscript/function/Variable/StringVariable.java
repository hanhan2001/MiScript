package me.xiaoying.miscript.function.Variable;

/**
 * Variable String
 */
public class StringVariable implements Variable {
    private final String value;

    public StringVariable(String string) {
        this.value = string;
    }

    @Override
    public String getValue() {
        return this.value;
    }
}