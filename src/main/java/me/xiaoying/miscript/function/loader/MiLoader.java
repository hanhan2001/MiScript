package me.xiaoying.miscript.function.loader;

import me.xiaoying.miscript.function.Clazz;
import me.xiaoying.miscript.function.interpreter.InterpreterManager;

import java.util.HashMap;
import java.util.Map;

/**
 * 加载器
 */
public class MiLoader {
    private final String path;
    private final Map<String, Clazz> knownClazz = new HashMap<>();
    private final InterpreterManager interpreterManager = new InterpreterManager();

    public MiLoader() {
        this.path = System.getProperty("user.dir");
    }

    /**
     * 构造器
     *
     * @param path 根路径
     */
    public MiLoader(String path) {
        this.path = path;
    }

    public void registerClazz(String name, Clazz clazz) {
        this.knownClazz.put(name, clazz);
    }

    public Clazz loadClass(String name) {
        String origin = name;
        name = this.path + "/" + name;
        name = name.replace("\\.", "/");
        Clazz clazz = new Clazz(name, this.interpreterManager, this);
        this.registerClazz(origin, clazz);
        return clazz;
    }

    public Clazz getClazz(String name) {
        return this.knownClazz.get(name);
    }

    public InterpreterManager getInterpreterManager() {
        return this.interpreterManager;
    }
}