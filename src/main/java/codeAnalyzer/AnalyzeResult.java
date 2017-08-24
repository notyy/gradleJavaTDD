package codeAnalyzer;

import java.util.Set;

public class AnalyzeResult {
    private int fileCount;
    private int totalLineOfCode;

    public AnalyzeResult(int fileCount, int totalLineOfCode) {
        this.fileCount = fileCount;
        this.totalLineOfCode = totalLineOfCode;
    }

    public int getFileCount() {
        return fileCount;
    }

    public int getTotalLineOfCode() {
        return totalLineOfCode;
    }

    public Set<String> getFileTypes() {
        return null;
    }

    public int getFileCount(String fileType) {
        return -1;
    }
}
