package aston.group86.hospitalboot.test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Task1 {

  public static void main(String[] args) {
    //Дана коллекция интов. Найти второй самый маленький элемент в коллекции.
    List<Integer> nums = Arrays.asList(1, 17, 54, 14, 14, 33, 45, -11);

   /* Optional<Integer> first = nums.stream()
        .sorted((num1, num2) -> Integer.compare(num2, num1))
        .skip(1)
        .findFirst();

    first.ifPresent(System.out::println);*/

    /*nums.stream()
        .reduce(Math::max)
        .ifPresent(System.out::println);*/

    Integer reduce = nums.stream()
        .reduce(0, (num1, num2) -> {
          if (num2 % 2 != 0) {
            return num1;
          } else {
            return num1 + num2;
          }
        });
    System.out.println(reduce);

  }

}
