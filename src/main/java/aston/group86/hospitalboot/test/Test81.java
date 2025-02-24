package aston.group86.hospitalboot.test;

import java.util.Optional;

public class Test81 {
  public static void main(String[] args) {
    System.out.println(getStringToUpperCase(null));

  }
  public static String getStringToUpperCase(String str) {
    return Optional.ofNullable(str).map(String::toUpperCase).orElse(null);
  }

}
