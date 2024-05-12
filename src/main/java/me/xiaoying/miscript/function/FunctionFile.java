package me.xiaoying.miscript.function;

import java.io.*;

public class FunctionFile {

//    private final

    public FunctionFile(String file) {
        this(new File(file));
    }

    public FunctionFile(InputStream inputStream) {

    }

    public FunctionFile(File file) {
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