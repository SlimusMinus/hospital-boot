package aston.group86.hospitalboot.test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Test46 {
  /*Автоматизация для кофейного автомата. Нужно написать функцию,
  которая будет рассчитывать сдачу в монетах. На вход приходит
  два значения: стоимость кофе и депозит который внес пользователь.
  Считаем что это всегда целые числа в монетках. В автомате есть бокс загруженный разными типами монет.
  Номиналы монет: 1,2,5,10,20,50. Функция будет набирать сдачу и определять какими монетами оптимально отдавать сдачу.
  Функция должна отдавать сдачу максимально крупными монетами.
    Например, сдачу 100 нужно отдать двумя монетами по 50 (выходной массив [50, 50]).
  Результат для 17: [10, 5, 2]. Функция должна принимать доступные номиналы монет.*/

  public static void main(String[] args) {
    System.out.println(sdacha(100, 200));
  }

  private static List<Integer> sdacha(int price, int deposit) {
    int cash = deposit - price;
    if (cash < 0) {
      throw new RuntimeException();
    }
    Set<Integer> nominals = Set.of(1, 2, 5, 10, 20, 50).stream()
        .sorted(Comparator.reverseOrder())
        .collect(Collectors.toCollection(LinkedHashSet::new));

    List<Integer> money = new ArrayList<>();

    for (var item : nominals){
      while(cash >= item){
        cash -= item;
        money.add(item);
      }
    }

    return money;
  }

}
