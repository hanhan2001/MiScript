package me.xiaoying.miscript.method;

import me.xiaoying.miscript.Blank;
import me.xiaoying.miscript.Object;

public class Method {
    private final String name;
    private final Blank blank;
    private MethodType methodType = MethodType.PUBLIC;
    private boolean isStatic = false;
    private Object returnType = null;

    public Method(int index, String name, Blank blank) {
        this.name = name;
        this.blank = blank;
    }

    public void run() {
        this.blank.clone().run();
    }

    /**
     * 设置方法类型
     *
     * @param type MethodType
     */
    public void setMethodType(MethodType type) {
        this.methodType = type;
    }

    /**
     * 获取方法类型<br>
     * {@code public} -> 公有方法<br>
     * {@code private} -> 私有方法<br>
     * {@code protected} -> 限制访问权限<br>
     *
     * @return MethodType
     */
    public MethodType getMethodType() {
        return this.methodType;
    }

    /**
     * 获取方法是否为静态
     *
     * @return Boolean
     */
    public boolean isStatic() {
        return this.isStatic;
    }

    /**
     * 设置方法是否为静态
     *
     * @param value Boolean
     */
    public void setStatic(boolean value) {
        this.isStatic = value;
    }

    /**
     * 获取返回数据类型
     *
     * @return Object
     */
    public Object getReturnType() {
        return this.returnType;
    }
}