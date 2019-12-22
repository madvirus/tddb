package math;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class MathUtils {
    public static long sum(File dataFile) {
        try {
            return Files.readAllLines(dataFile.toPath()).stream()
                    .mapToLong(Long::parseLong)
                    .sum();
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
