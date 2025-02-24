package aston.group86.hospitalboot.example;

import java.util.OptionalDouble;
import java.util.Random;
import java.util.stream.IntStream;

public class Task1 {


  public static void main(String[] args) {

    // 1. Сгенерировать стрим из 10 случайных целых чисел от 1 до 100, найти максимальный элемент с помощью reduce

    /*Random random = new Random();
    int reduce = random.ints(10, 1, 100)
        .peek(System.out::println)
        .reduce(Integer.MIN_VALUE, Math::max);

    System.out.println(reduce);*/

    // 2. Сгенерировать стрим из 10 целых чисел, кратных 5 (5, 10, 15, 20, 25 ....). Найти среднее значение, вывести в консоль

    double v = IntStream.iterate(5, value -> value + 5)
        .filter(num -> num % 5 == 0)
        .peek(System.out::println)
        .average()
        .orElse(1);

    System.out.println(v);

  }
}
