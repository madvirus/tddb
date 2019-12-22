package user;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserRegisterNestedTest {
    private UserRegister userRegister;
    private StubWeakPasswordChecker stubPasswordChecker = new StubWeakPasswordChecker();
    private MemoryUserRepository fakeRepository = new MemoryUserRepository();
    private SpyEmailNotifier spyEmailNotifier = new SpyEmailNotifier();

    @BeforeEach
    void setUp() {
        userRegister = new UserRegister(stubPasswordChecker,
                fakeRepository,
                spyEmailNotifier);
    }

    @DisplayName("약한 암호면 가입 실패")
    @Test
    void weakPassword() {
        stubPasswordChecker.setWeak(true);

        assertThrows(WeakPasswordException.class, () -> {
            userRegister.register("id", "pw", "email");
        });
    }

    @Nested
    class GivenUser {
        @BeforeEach
        void givenUser() {
            // 이미 같은 ID 존재하는 상황 만들기
            fakeRepository.save(new User("id", "pw1", "email@email.com"));
        }

        @DisplayName("이미 같은 ID가 존재하면 가입 실패")
        @Test
        void dupIdExists() {
            assertThrows(DupIdException.class, () -> {
                userRegister.register("id", "pw2", "email");
            });
        }
    }

    @Nested
    class GivenNoDupId {
        @DisplayName("같은 ID가 없으면 가입 성공함")
        @Test
        void noDupId_RegisterSuccess() {
            userRegister.register("id", "pw", "email");

            User savedUser = fakeRepository.findById("id");
            assertEquals("id", savedUser.getId());
            assertEquals("email", savedUser.getEmail());
        }

        @DisplayName("가입하면 메일을 전송함")
        @Test
        void whenRegisterThenSendMail() {
            userRegister.register("id", "pw", "email@email.com");

            assertTrue(spyEmailNotifier.isCalled());
            assertEquals(
                    "email@email.com",
                    spyEmailNotifier.getEmail());
        }

    }
}
