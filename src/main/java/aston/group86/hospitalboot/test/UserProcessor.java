package aston.group86.hospitalboot.test;

import java.util.Comparator;
import java.util.List;

class User {

  private String name;
  private boolean isActive;

  public User(String name, boolean isActive) {
    this.name = name;
    this.isActive = isActive;
  }

  public String getName() {
    return name;
  }

  public boolean isActive() {
    return isActive;
  }
}

public class UserProcessor {

  private static final int LIMIT = 5;

  public static List<String> processUsers(List<User> users) {

    return users.stream()
        .filter(User::isActive)
        .sorted(Comparator.comparing(User::getName))
        .limit(LIMIT)
        .map(User::getName)
        .toList();

  }

  public static void main(String[] args) {
    List<User> users = List.of(
        new User("Alice", true),
        new User("Bob", false),
        new User("Charlie", true),
        new User("Dave", true),
        new User("Eve", true),
        new User("Frank", true),
        new User("Grace", true)
    );

    List<String> result = processUsers(users);
    System.out.println(result);
  }
}