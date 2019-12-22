package autodebit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;

public class AutoDebitRegister_Mock_Test {
    private AutoDebitRegister register;
    private CardNumberValidator cardNumberValidator = Mockito.mock(CardNumberValidator.class);
    private AutoDebitInfoRepository repository = Mockito.mock(AutoDebitInfoRepository.class);

    @BeforeEach
    void setUp() {
        register = new AutoDebitRegister(cardNumberValidator, repository);
    }

    @Test
    void validCard() {
        given(cardNumberValidator.validate(anyString())).willReturn(CardValidity.VALID);

        AutoDebitReq req = new AutoDebitReq("user1", "1234123412341234");
        RegisterResult result = this.register.register(req);

        BDDMockito.then(repository).should().save(Mockito.any());
    }
}
