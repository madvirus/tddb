package appd;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class AsTest {
    @Test
    void as() {
        List<Integer> ret = getResults();

        List<Integer> expected = Arrays.asList(1, 2, 3);
        SoftAssertions soft = new SoftAssertions();
        for (int i = 0 ; i < expected.size() ; i++) {
            soft.assertThat(ret.get(i)).as("ret[%d]", i).isEqualTo(expected.get(i));
        }
        soft.assertAll();
    }

    @Test
    void describeAs() {
        List<Integer> ret = getResults();

        List<Integer> expected = Arrays.asList(1, 2, 3);
        SoftAssertions soft = new SoftAssertions();
        for (int i = 0 ; i < expected.size() ; i++) {
            soft.assertThat(ret.get(i)).describedAs("ret[%d] desc", i).isEqualTo(expected.get(i));
        }
        soft.assertAll();
    }

    private List<Integer> getResults() {
        return Arrays.asList(1, 6, 3);
    }
}
