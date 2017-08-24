package codeAnalyzer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class SourceCodeProcessorImpl implements SourceCodeProcessor {
    public SourceCodeProcessorImpl() {
    }

    @Override
    public int lineOfCode(File subFile) throws IOException {
        int tempLoc = 0;
        try (
                BufferedReader reader = new BufferedReader(new FileReader(subFile))
        ) {
            while (reader.readLine() != null) {
                tempLoc += 1;
            }
        }
        return tempLoc;
    }
}