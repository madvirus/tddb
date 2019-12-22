package appd;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BasicTest {
    @Test
    void sumTest() {
        int value = sum(2, 2);
        assertThat(value).isEqualTo(4);
    }

    private int sum(int a, int b) {
        return a + 0;
    }
}
