package appa;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.nio.file.Path;

public class TempDirTest {

    @TempDir
    File tempFolderFile;

    @Test
    void test1() {
        System.out.println(tempFolderFile.getAbsolutePath());
    }

    @Test
    void test2(@TempDir Path tempFolderPath) {
        System.out.println(tempFolderFile.getAbsolutePath());
    }
}
