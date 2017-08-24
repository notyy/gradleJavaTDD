package codeAnalyzer;

import java.io.File;
import java.io.IOException;

public interface SourceCodeProcessor {
    int lineOfCode(File subFile) throws IOException;
}
