package me.xiaoying.miscript;

import java.io.*;
import java.nio.file.Files;

/**
 * 类似 Java Class
 */
public class Clazz extends Object implements Cloneable {
    private final String name;
    private final MiLoader loader;
    private Blank blank;

    public Clazz(String name, String content, MiLoader loader) {
        this.name = name;
        this.loader = loader;

        this.initialize(content);
    }

    public Clazz(String name, File file, MiLoader loader) {
        this.name = name;
        this.loader = loader;

        try {
            this.initialize(Files.newInputStream(file.toPath()));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Clazz(String name, InputStream inputStream, MiLoader loader) {
        this.name = name;
        this.loader = loader;

        try {
            this.initialize(inputStream);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void initialize(String content) {
        String[] split = content.split("\n");
        this.blank = new Blank(this);
        for (int i = 0; i < split.length; i++)
            this.blank.insert(i + 1, split[i]);
    }

    private void initialize(InputStream inputStream) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        int index = 1;
        String content;
        this.blank = new Blank(this);
        while ((content = reader.readLine()) != null) {
            this.blank.insert(index, content);
            index++;
        }
        reader.close();
        inputStream.close();
    }

    public MiLoader getLoader() {
        return this.loader;
    }

    @Override
    public String getName() {
        return this.name;
    }

    public void run() {
        this.blank.clone().run();
    }

    @Override
    public Clazz clone() {
        try {
            Clazz clone = (Clazz) super.clone();
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}