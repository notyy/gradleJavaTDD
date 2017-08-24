package codeAnalyzer;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class CodeAnalyzer {

    private DirectoryScanner directoryScanner = new DirectoryScannerImpl();
    private SourceCodeProcessor sourceCodeProcessor = new SourceCodeProcessorImpl();

    public CodeAnalyzer(){

    }

    public CodeAnalyzer(DirectoryScanner directoryScanner, SourceCodeProcessor sourceCodeProcessor){
        this.directoryScanner = directoryScanner;
        this.sourceCodeProcessor = sourceCodeProcessor;
    }

    public AnalyzeResult analyze(String path) throws IOException {
        List<File> files = directoryScanner.scan(path);
        int totalLoC = 0;
        for (File file: files) {
            totalLoC += sourceCodeProcessor.lineOfCode(file);
        }
        return new AnalyzeResult(files.size(),totalLoC);
    }
}