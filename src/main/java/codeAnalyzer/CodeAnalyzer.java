package codeAnalyzer;

import java.io.*;

public class CodeAnalyzer {
    public int totalFileCount(String path) {
        File directory = new File(path);
        int count = 0;
        if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles();
            for (File file : files) {
                if (file.isFile()) {
                    count += 1;
                } else {
                    count += totalFileCount(file.getAbsolutePath());
                }
            }
            return count;
        } else {
            throw new IllegalArgumentException("path: " + path + " not exist or not directory");
        }
    }

    public long totalLine(String path) throws IOException {
        File directory = new File(path);
        int count = 0;
        if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles();
            for (File file : files) {
                if (file.isFile()) {
                    BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
                    while(bufferedReader.readLine() != null){
                        count += 1;
                    }
                } else {
                    count += totalLine(file.getAbsolutePath());
                }
            }
            return count;
        } else {
            throw new IllegalArgumentException("path: " + path + " not exist or not directory");
        }
    }
}
