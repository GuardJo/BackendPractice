package org.example.jdbc;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

import java.sql.SQLException;

import static org.assertj.core.api.Assertions.assertThat;

public class UserDaoTest {
    @BeforeEach
    void setUp() {
        ResourceDatabasePopulator resourceDatabasePopulator = new ResourceDatabasePopulator();
        resourceDatabasePopulator.addScript(new ClassPathResource("db_schema.sql"));
        DatabasePopulatorUtils.execute(resourceDatabasePopulator, ConnectionHandler.getDataSource());
    }

    @DisplayName("UserDao 생성 및 정상 생성 확인 테스트")
    @Test
    void testCreate() throws SQLException {
        UserDao userDao = new UserDao();
        User createUser = new User("userId", "password", "name", "email");

        userDao.create(createUser);

        User findUser = userDao.findById("userId");

        assertThat(createUser).isEqualTo(findUser);
    }
}
