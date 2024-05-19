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
        this.blank = new Blank(1, content, this);
    }

    private void initialize(InputStream inputStream) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        StringBuilder stringBuilder = new StringBuilder();
        String content;
        while ((content = reader.readLine()) != null) {
            if (!stringBuilder.toString().isEmpty())
                stringBuilder.append("\n");

            stringBuilder.append(content);
        }
        this.blank = new Blank(1, stringBuilder.toString(), this);
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