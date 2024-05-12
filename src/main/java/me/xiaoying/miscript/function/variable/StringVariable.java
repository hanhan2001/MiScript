package me.xiaoying.miscript.function.variable;

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

    @Override
    public boolean match(String string) {
        if (!string.startsWith("\""))
            return false;
        if (!string.endsWith("\""))
            return false;

        return true;
    }
}