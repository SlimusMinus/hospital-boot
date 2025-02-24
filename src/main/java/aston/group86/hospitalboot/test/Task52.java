package aston.group86.hospitalboot.test;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Task52 {

  public static void main(String[] args) throws ExecutionException, InterruptedException {
    List<Integer> unSortedList = List.of(55, 12, 3, 7, 99, 44, 1, 120, 1);
    System.out.println(getSortedList(unSortedList));
  }

  public static List<Integer> getSortedList(List<Integer> unSortedList) {
    return Stream.concat(
            getEvenOrOddSortedStream(unSortedList, num -> num % 2 == 0),
            getEvenOrOddSortedStream(unSortedList, num -> num % 2 != 0))
        .toList();
  }

  private static Stream<Integer> getEvenOrOddSortedStream(List<Integer> unSortedList, Predicate<Integer> evenOrOddPredicate) {
    return unSortedList.stream()
        .filter(evenOrOddPredicate)
        .sorted();
  }

}
