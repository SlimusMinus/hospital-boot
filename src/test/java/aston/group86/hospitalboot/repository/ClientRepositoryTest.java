package aston.group86.hospitalboot.repository;

import static org.junit.jupiter.api.Assertions.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
class ClientRepositoryTest {

  @Autowired
  ClientRepository clientRepository;
}