package aston.group86.hospitalboot.test;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.logging.Logger;
import javax.xml.bind.ValidationException;

public class Test55 {


  class UserService {

    private final Set<User> users;
    private final Logger log = Logger.getLogger(UserService.class.getName());

    public UserService() {
      WeakHashMap<User, Boolean> weakHashMap = new WeakHashMap<>();
      Set<User> userSet = Collections.newSetFromMap(weakHashMap);
      users = Collections.synchronizedSet(userSet);
    }

    public User addUser(User user) throws ValidationException {
      if (!validation(user)) {
        throw new ValidationException("validation is error");
      }
      users.add(user);
      log.info("User added successfully");
      return user;
    }

    private boolean validation(User user) {
      if (user == null) {
        log.warning("User is null");
        return false;
      }

      if (user.name() == null || user.name().isEmpty()) {
        log.warning("User name is empty");
        return false;
      }

      if (user.age() < 0) {
        log.warning("User age is invalid");
        return false;
      }

      if (users.contains(user)) {
        log.warning("User already exists");
        return false;
      }
      return true;
    }

    public Set<User> getUsers() {
      return new HashSet<>(users);
    }
  }

  record User(
      String name,
      int age
  ) {

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }
      User user = (User) o;
      return age == user.age && Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
      return Objects.hash(name, age);
    }
  }
}
