package aston.group86.hospitalboot.test;

import java.util.Arrays;
import java.util.concurrent.CyclicBarrier;
import java.util.stream.Collectors;

public class App2 {

  public static void main(String[] args) {
    int[] arr = {1, 2, 3, 4, 5};
  /*  Слейте элементы этого массива в строку: "12345"*/

/*    String collect = Arrays.stream(arr)
        .boxed()
        .map(String::valueOf)
        .collect(Collectors.joining(","));
    System.out.println(collect);*/

    CyclicBarrier barrier = new CyclicBarrier(3,
        () -> System.out.println("Все готовы. Гонка начинается!"));

    for (int i = 1; i <= 3; i++) {
      int racer = i;
      new Thread(() -> {
        System.out.println("Гонщик " + racer + " готов");
        try {
          barrier.await(); // Ждем остальных
        } catch (Exception e) {}
        System.out.println("Гонщик " + racer + " стартует!");
      }).start();
    }

  }



}
