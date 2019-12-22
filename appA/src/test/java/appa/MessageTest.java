package appa;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MessageTest {
    @Test
    void message() {
        List<Integer> ret = getResults();
        List<Integer> expected = Arrays.asList(1, 2, 3);
        for (int i = 0 ; i < expected.size() ; i++) {
            assertEquals(expected.get(i), ret.get(i), "ret[" + i + "]");
        }
    }

    private List<Integer> getResults() {
        return Arrays.asList(1, 6, 3);
    }

}
