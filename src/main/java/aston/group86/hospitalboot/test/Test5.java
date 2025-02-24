package aston.group86.hospitalboot.test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import lombok.Data;

public class Test5 {

}

@Data
class Sale {

  String productName;
  String category;
  double price;
  int quantity;

  Sale(String productName, String category, double price, int quantity) {
    this.productName = productName;
    this.category = category;
    this.price = price;
    this.quantity = quantity;
  }

  public String getCategory() {
    return category;
  }

  public double getTotalSale() {
    return price * quantity;
  }


  //
//### Задача: Анализ продаж
//**Условие:** Дано список объектов класса `Sale`, представляющего информацию о продажах.
// Каждый объект содержит данные о названии продукта, категории, цене и количестве. Напишите программу, которая:
//
//            1. Сгруппирует продажи по категории продукта и
//            для каждой категории вычислит общую сумму продаж (цена * количество).
//            2. Отфильтрует категории, у которых сумма продаж больше 100.
//            3. Отсортирует оставшиеся категории по общей сумме продаж в порядке убывания.
//            4. Выведет название категории и общую сумму продаж для оставшихся категорий.
  public static void main(String[] args) {
    List<Sale> sales = Arrays.asList(
        new Sale("Laptop", "Electronics", 1000, 1),
        new Sale("Smartphone", "Electronics", 500, 2),
        new Sale("Chair", "Furniture", 150, 5),
        new Sale("Desk", "Furniture", 300, 1),
        new Sale("Pen", "Stationery", 1, 100),
        new Sale("Notebook", "Stationery", 2, 50)
    );

   sales.stream()
        .collect(Collectors.groupingBy(Sale::getCategory, Collectors.summingDouble(sale-> sale.price*sale.quantity)))
        .entrySet()
        .stream().filter(sale->sale.getValue() > 100)
        .sorted(Entry.comparingByValue(Comparator.reverseOrder()))
        .forEach(System.out::println);

    Map<String, List<Sale>> collect = sales.stream()
        .collect(Collectors.groupingBy(Sale::getCategory));
    System.out.println(collect);

  }
}













