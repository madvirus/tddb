package nontestable;

import net.bytebuddy.asm.Advice;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DailyBatchLoader {
    private String basePath = ".";

    public int load() {
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        Path batchPath = Paths.get(basePath, date.format(formatter), "batch.txt");

        // ...batchPath에서 데이터를 읽어와 저장하는 코드

        return 0;
    }
}
