package codeAnalyzer;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class CodeAnalyzerTest {

    public static final String SRC_TEST_FIXTURE = "src/test/fixture";
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void should_throw_IllegalArgumentException_if_path_not_exist(){
        CodeAnalyzer codeAnalyzer = new CodeAnalyzer();
        thrown.expect(IllegalArgumentException.class);
        codeAnalyzer.totalFileCount("not_exist");
    }

    @Test
    public void can_count_files_under_given_folder(){
        CodeAnalyzer codeAnalyzer = new CodeAnalyzer();
        int fileCount = codeAnalyzer.totalFileCount(SRC_TEST_FIXTURE);
        assertThat(fileCount,is(3));
    }



    @Test
    public void should_throw_IllegalArgumentException_if_path_is_not_a_directory(){
        CodeAnalyzer codeAnalyzer = new CodeAnalyzer();
        thrown.expect(IllegalArgumentException.class);
        codeAnalyzer.totalFileCount(SRC_TEST_FIXTURE + "/1.java");
    }

    @Test
    public void can_count_total_line_of_code() throws IOException {
        CodeAnalyzer codeAnalyzer = new CodeAnalyzer();
        long loc = codeAnalyzer.totalLine(SRC_TEST_FIXTURE);
        assertThat(loc, is(82L));
    }
}