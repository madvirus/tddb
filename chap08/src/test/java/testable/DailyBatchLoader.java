package testable;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DailyBatchLoader {
    private Times times = new Times();
    private String basePath = ".";

    public void setBasePath(String basePath) {
        this.basePath = basePath;
    }

    public void setTimes(Times times) {
        this.times = times;
    }

    public int load() {
        LocalDate date = times.today();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        Path batchPath = Paths.get(basePath, date.format(formatter), "batch.txt");

        try {
            return (int) Files.lines(batchPath).count();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
