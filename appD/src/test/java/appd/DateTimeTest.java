package appd;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZonedDateTime;
import java.util.Collections;
import java.util.Date;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

public class DateTimeTest {
    @Test
    void ignoring() {
        LocalDateTime time = LocalDateTime.of(2019, 7, 31, 19, 30, 31, 123);

        assertThat(time).isEqualToIgnoringNanos(
                LocalDateTime.of(2019, 7, 31, 19, 30, 31, 456)
        );
        assertThat(time).isEqualToIgnoringSeconds(
                LocalDateTime.of(2019, 7, 31, 19, 30, 39)
        );
        assertThat(time).isEqualToIgnoringMinutes(
                LocalDateTime.of(2019, 7, 31, 19, 10)
        );
        assertThat(time).isEqualToIgnoringHours(
                LocalDateTime.of(2019, 7, 31, 15, 10)
        );
    }
}
