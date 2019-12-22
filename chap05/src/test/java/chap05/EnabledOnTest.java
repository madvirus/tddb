package chap05;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.api.condition.OS;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EnabledOnTest {
    @Test
    @EnabledOnOs(OS.WINDOWS)
    void testOnWindows() {
        assertEquals(2, 1 + 1);
    }

    @Test
    @EnabledOnOs({OS.MAC, OS.LINUX})
    void testOnMac() {
        assertEquals(2, 1 + 1);
    }

    @Test
    @EnabledOnJre({JRE.JAVA_8, JRE.JAVA_9, JRE.JAVA_10, JRE.JAVA_11})
    void testOnJre() {
        assertEquals(LocalDate.of(1919, 3, 1), LocalDate.of(2019, 3, 1).minusYears(100));
    }

}
