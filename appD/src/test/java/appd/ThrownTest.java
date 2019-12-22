package appd;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class ThrownTest {

    @Test
    void thrownBy() {
        assertThatThrownBy(() -> readFile(new File("nofile.txt")))
            .isInstanceOf(IOException.class);
    }

    @Test
    void exceptionOfType() {
        assertThatExceptionOfType(IOException.class)
                .isThrownBy(() -> {
                    readFile(new File("nofile.txct"));
                });
    }

    @Test
    void exceptionOfIOException() {
        assertThatIOException()
                .isThrownBy(() -> {
                    readFile(new File("nofile.txct"));
                });
    }

    @Test
    void noThrown() {
        assertThatCode(() -> {
            readFile(new File("pom.xml"));
        }).doesNotThrowAnyException();
    }

    List<String> readFile(File file) throws IOException {
        return Files.readAllLines(Paths.get(file.toURI()));
    }
}
