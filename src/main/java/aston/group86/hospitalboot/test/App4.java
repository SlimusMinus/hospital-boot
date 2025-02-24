package aston.group86.hospitalboot.test;

/*Найти второй максимальный элемент и вывести его
34, 82, 21, 2, 43, 50, 27, 16, 95, 7, 23, 77*/

import java.util.Comparator;
import java.util.List;

public class App4 {

  public static void main(String[] args) {

   List<Integer> list = List.of(34, 82, 21, 2, 43, 50, 27, 16, 95, 7, 23, 77);
    /* System.out.println(getNum(list));*/
    System.out.println(sum(list));

  }

  public static int getNum(List<Integer> list){
    return list.stream()
        .sorted(Comparator.reverseOrder())
        .skip(1)
        .findFirst().get();

  }

  public static int sum(List<Integer> list){
    return list.stream()
        .filter(num-> (num % 2 == 0) && num > 40)
        .mapToInt(Integer::intValue)
        .sum();
  }

}
