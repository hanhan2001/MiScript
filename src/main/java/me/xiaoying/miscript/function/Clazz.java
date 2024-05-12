package me.xiaoying.miscript.function;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 类似 Java Class
 */
public class Clazz {
    private String name;
    private List<Blank> blanks = new ArrayList<>();

    public Clazz(String file) {
        this(new File(file));
    }

    public Clazz(InputStream inputStream, String name, String packagePath) {

    }

    public Clazz(File file) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}