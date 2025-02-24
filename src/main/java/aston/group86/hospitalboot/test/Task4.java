package aston.group86.hospitalboot.test;

import java.util.Collections;
import java.util.List;

public class Task4 {
  
  public List<String> filterStrings(List<String> strings, int minLength) {

    if (strings == null) {
      return Collections.emptyList();
    }

    return strings.stream()
        .filter(str-> str != null && str.length() >= minLength)
        .toList();
  }

}

class PersonDto {

  public Long id;
  public String fullName;
  public int age;
  public String userName;
  public String password;

}