package chap09.member;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@JdbcTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class MemberDaoJdbcTest {

    @Autowired
    JdbcTemplate jdbcTemplate;

    private MemberDao dao;

    @BeforeEach
    void setUp() {
        dao = new MemberDao(jdbcTemplate);
    }

    @Test
    void findAll() {
        List<Member> members = dao.selectAll();
        assertNotNull(members);
    }
}
