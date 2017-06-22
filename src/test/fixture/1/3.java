package codeAnalyzer;

import java.io.File;

public class CodeAnalyzer {
    public int anlyze(String path) {
        File directory = new File(path);
        int count = 0;
        if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles();
            for (File file : files) {
                if (file.isFile()) {
                    count += 1;
                } else {
                    count += anlyze(file.getAbsolutePath());
                }
            }
            return count;
        } else {
            throw new IllegalArgumentException("path: " + path + " not exist or not directory");
        }
    }

    public long totalLine(String path) {
        return -1;
    }
}