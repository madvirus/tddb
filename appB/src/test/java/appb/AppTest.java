package appb;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AppTest {
    @Before
    public void setUp() {

    }

    @Test
    public void plus() {
        assertEquals(2, 1 + 1);
    }

    @Test(expected = ArithmeticException.class)
    public void throwEx() {
        divide(1, 0);
    }

    @Test
    public void throwEx2() {
        ArithmeticException thrown = null;
        try {
            divide(1, 0);
        } catch(ArithmeticException ex) {
            thrown = ex;
        }
        assertNotNull(thrown);
        assertTrue(thrown.getMessage().contains("zero"));
    }

    private int divide(int a1, int a2) {
        return a1 / a2;
    }

    @After
    public void tearDown() {

    }
}
