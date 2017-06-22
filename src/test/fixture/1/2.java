package codeAnalyzer;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class CodeAnalyzerTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void should_throw_IllegalArgumentException_if_path_not_exist(){
        CodeAnalyzer codeAnalyzer = new CodeAnalyzer();
        thrown.expect(IllegalArgumentException.class);
        codeAnalyzer.anlyze("not_exist");
    }

    @Test
    public void can_count_files_under_given_folder(){
        CodeAnalyzer codeAnalyzer = new CodeAnalyzer();
        int fileCount = codeAnalyzer.anlyze("src/test/fixture");
        assertThat(fileCount,is(3));
    }



    @Test
    public void should_throw_IllegalArgumentException_if_path_is_not_a_directory(){
        CodeAnalyzer codeAnalyzer = new CodeAnalyzer();
        thrown.expect(IllegalArgumentException.class);
        codeAnalyzer.anlyze("src/test/fixture/1.java");
    }
}