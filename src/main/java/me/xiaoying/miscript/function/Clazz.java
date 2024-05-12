package me.xiaoying.miscript.function;

import me.xiaoying.miscript.function.loader.MiLoader;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 类似 Java Class
 */
public class Clazz {
    private Blank blank;
    private MiLoader loader;

    public Clazz(String file, MiLoader loader) {
        this(new File(file), loader);
    }

//    public Clazz(InputStream inputStream, String name, String packagePath, MiLoader loader) {
//        this.loader = loader;
//        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
//    }

    public Clazz(File file, MiLoader loader) {
        if (file == null || !file.exists())
            return;

        this.loader = loader;

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            Blank blank = new Blank("public", loader.getInterpreterManager());

            int index = 1;
            String string;
            while ((string = reader.readLine()) != null) {
                blank.insert(index, string);
                index++;
            }

            this.blank = blank;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void run() {
        this.blank.run();
    }

    public MiLoader getLoader() {
        return this.loader;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}