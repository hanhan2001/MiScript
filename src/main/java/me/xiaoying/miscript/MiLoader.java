package me.xiaoying.miscript;

import me.xiaoying.miscript.interpreter.InterpreterManager;
import me.xiaoying.miscript.interpreter.method.PrintInterpreter;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * 加载器 类似 ClassLoader
 */
public class MiLoader {
    private String path;
    private String name = "MiLoader";
    private final Map<String, Clazz> knownClazz = new HashMap<>();
    private InterpreterManager interpreterManager = new InterpreterManager();

    /**
     * 实例化 MiLoader<br>
     * 以当前运行路径作为根目录
     */
    public MiLoader() {
        this(System.getProperty("user.dir"));
        this.init();
    }

    /**
     * 实例化 MiLoader<br>
     * 指定加载器所在根目录
     *
     * @param root 系统路径，如 {@code C:/Users/Administrator/Desktop}
     */
    public MiLoader(String root) {
        File path = new File(root);
        if (!path.exists())
            throw new RuntimeException("Can't set path for MiLoader(It is not exists for this path?)");

        this.path = path.getPath();
        this.init();
    }

    private void init() {
        this.interpreterManager = new InterpreterManager();
        this.interpreterManager.registerInterpreter(new PrintInterpreter());
    }

    /**
     * 加载 Clazz
     *
     * @param name Clazz路径，路径格式需将 {@code /} 替换为 {@code .}
     * @return Clazz
     */
    public Clazz loadClass(String name) {
        // 判断 Clazz 是否已加载
        if (this.knownClazz.containsKey(name))
            return this.knownClazz.get(name);

        File file = new File(this.path + "/" + name.replace(".", "/"));
        if (file.isDirectory())
            return null;

        // 判断文件是否存在
        // 无后缀名文件不存在时则判断默认后缀名 *.ms 文件是否存在
        if (!file.exists()) {
            file = new File(this.path + "/" + name.replace(".", "/") + ".ms");
            if (!file.exists())
                return null;
        }

        Clazz clazz = new Clazz(name, file, this);
        this.knownClazz.put(name, clazz);
        return clazz;
    }

    public InterpreterManager getInterpreterManager() {
        return this.interpreterManager;
    }

    public String getName() {
        return this.name == null || this.name.isEmpty() ? this.getClass().getName() : this.name;
    }
}