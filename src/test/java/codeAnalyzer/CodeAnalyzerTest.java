package codeAnalyzer;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class CodeAnalyzerTest {
    @Test
    public void can_count_files_under_given_folder(){
        CodeAnalyzer codeAnalyzer = new CodeAnalyzer();
        int fileCount = codeAnalyzer.anlyze("src/test/fixture");
        assertThat(fileCount,is(1));
    }
}