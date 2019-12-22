package appc;

import org.junit.jupiter.api.Test;

import java.util.concurrent.Callable;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

public class TypeMockingTest {
    @Test
    void mockInterface() throws Exception {
        Callable<Integer> mock = mock(Callable.class);
        given(mock.call()).willReturn(10);

        assertEquals(10, mock.call());
    }

    @Test
    void mockClass() {
        GameNumGen mockGen = mock(GameNumGen.class);
        given(mockGen.generate(GameLevel.EASY)).willReturn("123");
        assertEquals("123", mockGen.generate(GameLevel.EASY));
    }

    @Test
    void mockAbstract() {
        AbstractClass mock = mock(AbstractClass.class);
        given(mock.nextNum()).willReturn(100);
        assertEquals(100, mock.nextNum());
    }
}
