package aston.group86.hospitalboot.test;

/*
Задача: Слияние интервалов
Дан список интервалов, где каждый интервал представлен в виде [start, end].
Необходимо объединить все перекрывающиеся интервалы и вернуть список непересекающихся интервалов.

Пример:
Вход: [[1,3],[2,6],[8,10],[15,18]] → [[1,6],[8,10],[15,18]]
Вход: [[1,4],[4,5]] → [[1,5]]
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Test70 {

  public static List<List<Integer>> mergeIntervals(List<List<Integer>> intervals) {

    intervals.sort(Comparator.comparingInt(interval -> interval.get(0)));

    List<List<Integer>> finalInterval = new ArrayList<>();
    finalInterval.add(intervals.get(0));

    for (int i = 1; i < intervals.size(); i++) {

      List<Integer> firstArray = finalInterval.get(finalInterval.size() - 1);

      Integer secondIndexFirstArray = firstArray.get(1);
      Integer firstIndexSecondArray = intervals.get(i).get(0);
      Integer secondIndexSecondArray = intervals.get(i).get(1);

      if (firstIndexSecondArray <= secondIndexFirstArray) {
        firstArray.set(1, Math.max(secondIndexSecondArray, secondIndexFirstArray));
      } else {
        finalInterval.add(new ArrayList<>(intervals.get(i)));
      }
    }

    return finalInterval;
  }

  public static void main(String[] args) {
    List<List<Integer>> input1 = Arrays.asList(
        Arrays.asList(1, 3),
        Arrays.asList(2, 6),
        Arrays.asList(8, 10),
        Arrays.asList(15, 18)
    );
    System.out.println(mergeIntervals(input1)); // [[1,6], [8,10], [15,18]]

    List<List<Integer>> input2 = Arrays.asList(
        Arrays.asList(1, 4),
        Arrays.asList(4, 5)
    );
    System.out.println(mergeIntervals(input2)); // [[1,5]]
  }
}
