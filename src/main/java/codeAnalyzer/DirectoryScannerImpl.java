package codeAnalyzer;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class DirectoryScannerImpl implements DirectoryScanner {
    public DirectoryScannerImpl() {
    }

    @Override
    public List<File> scan(String path) {
        List<File> files = new ArrayList<File>();
        File file = new File(path);
        if (file.exists() && file.isDirectory()) {
            File[] subFiles = file.listFiles();
            for (File subFile : subFiles) {
                if (subFile.isFile()) files.add(subFile);
                else files.addAll(scan(subFile.getAbsolutePath()));
            }
            return files;
        } else {
            throw new IllegalArgumentException("file not found or is not a directory: " + path);
        }
    }
}