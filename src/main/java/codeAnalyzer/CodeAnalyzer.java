package codeAnalyzer;

import java.io.File;

public class CodeAnalyzer {
    public int anlyze(String path) {
        File directory = new File(path);
        return directory.list().length;
    }
}
