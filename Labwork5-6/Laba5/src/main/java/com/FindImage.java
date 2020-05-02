package com;

import java.io.File;

public class FindImage {


    public boolean FindName(String name)
    {
        File folder = new File("/Users/dima/Desktop/images");
        File[] files = folder.listFiles();

        for (File nameFile:files) {
            if (nameFile.getName().contains(name)) {
                return  true;
            }
        }
        return false;
    }
}
