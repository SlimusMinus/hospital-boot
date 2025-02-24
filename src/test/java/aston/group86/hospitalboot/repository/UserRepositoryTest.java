package aston.group86.hospitalboot.repository;

import static org.assertj.core.api.Assertions.assertThat;

import aston.group86.hospitalboot.entity.User;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("test2")
@DataJpaTest
public class UserRepositoryTest {

  @Autowired
  private TestEntityManager testEntityManager;

  @Autowired
  private UserRepository userRepository;

  @Test
  void findByEmail_shouldReturnUSer(){

    User user = new User();
    user.setEmail("123@gmail.com");
    user.setName("Alex");
    testEntityManager.persist(user); // Сохраняем вручную
    testEntityManager.flush(); // Применяем изменения в БД

    Optional<User> foundUser = userRepository.findByEmail("123@gmail.com");

    assertThat(foundUser.isPresent()).isTrue();
    assertThat(foundUser.get().getName()).isEqualTo("Alex");

  }
}
