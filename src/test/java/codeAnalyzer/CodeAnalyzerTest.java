package codeAnalyzer;

import com.google.common.collect.Lists;
import org.junit.Ignore;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CodeAnalyzerTest {

    private CodeAnalyzer codeAnalyzer = new CodeAnalyzer();

    @Test
    public void can_anlyze_codebase() throws IOException {
        AnalyzeResult analyzeResult = codeAnalyzer.analyze("fixture");
        assertThat(analyzeResult.getFileCount(), is(4));
        assertThat(analyzeResult.getTotalLineOfCode(), is(10));
    }

    @Test
    @Ignore
    public void can_analyze_filenum_for_different_file_type() throws IOException {
        DirectoryScanner directoryScanner = mock(DirectoryScanner.class);
        List<File> files = Lists.newArrayList(new File("1.java"), new File("2.java"),new File("3.scala"));
        when(directoryScanner.scan(anyString())).thenReturn(files);
        SourceCodeProcessor sourceCodeProcessor = mock(SourceCodeProcessor.class);

        CodeAnalyzer codeAnalyzer = new CodeAnalyzer(directoryScanner,new SourceCodeProcessorImpl());
        AnalyzeResult analyzeResult = codeAnalyzer.analyze("anypath");
        Set<String> fileTypes = analyzeResult.getFileTypes();
        assertThat(fileTypes.size(), is(2));
        assertThat(analyzeResult.getFileCount("java"), is(2));
        assertThat(analyzeResult.getFileCount("scala"), is(1));
    }
}