package aston.group86.hospitalboot.test;


import java.util.List;

public class Test10 {

  public static void main(String[] args) {
    /*
     * Посчитать сумму квадратов четных чисел
     */
    List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

  }
  public static int getSumOfSquares(List<Integer> numbers) {
    return numbers.stream()
        .filter(num->num%2==0)
        .map(num->num*num)
        .reduce(0, Integer::sum);
  }
}
