package org.example.mvc.repository;

import org.example.mvc.model.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

public class UserRepositoryTest {
    @DisplayName("User 객체 저장 및 탐색 테스트")
    @Test
    void testCreate() {
        User user = new User("testId", "testName");

        assertThatCode(() -> UserRepository.saveUser(user)).doesNotThrowAnyException();

        User findUser = UserRepository.findUser("testId");

        assertThat(findUser).isEqualTo(user);
    }

    @DisplayName("User 객체 리스트 반환 테스트")
    @Test
    void testFindAll() {
        List<User> list = List.of(new User("1", "test1"), new User("2", "test2"));

        list.forEach(UserRepository::saveUser);

        List<User> findAllList = UserRepository.findAll();

        assertThat(findAllList).isEqualTo(list);
    }
}
