package aston.group86.hospitalboot.test;

import java.util.Arrays;
import java.util.stream.Collectors;

public class App2 {

  public static void main(String[] args) {
    int[] arr = {1, 2, 3, 4, 5};
  /*  Слейте элементы этого массива в строку: "12345"*/

    String collect = Arrays.stream(arr)
        .boxed()
        .map(String::valueOf)
        .collect(Collectors.joining(","));
    System.out.println(collect);

  }



}
