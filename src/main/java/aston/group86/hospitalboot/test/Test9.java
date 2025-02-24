package aston.group86.hospitalboot.test;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;

public class Test9 {

}

@AllArgsConstructor
@lombok.Data
class Order {

  private int id;
  private Customer customer;
  private List<OrderItem> items;

  //У вас есть интернет-магазин, который продаёт различные товары.
  // Вам дан список заказов, где каждый заказ содержит информацию о клиенте,
  // купленных товарах и их количестве. Нужно провести анализ продаж и выполнить несколько задач:
  //
  //1) Найти топ-3 самых популярных товаров (по количеству проданных единиц).
  //2) Вычислить общую сумму выручки по каждому клиенту.
  //3)Сгруппировать товары по категориям и вывести список товаров в каждой категории,
  // отсортированный по количеству продаж.
  //4)Определить, есть ли клиенты, купившие товары из более чем одной категории.
  public static void main(String[] args) {
    // Пример данных
    List<Order> orders = List.of(
        new Order(1, new Customer(1, "Alice"), List.of(
            new OrderItem(new Product(1, "Laptop", "Electronics", 1000), 1),
            new OrderItem(new Product(2, "Mouse", "Electronics", 20), 2)
        )),
        new Order(2, new Customer(2, "Bob"), List.of(
            new OrderItem(new Product(3, "Chair", "Furniture", 50), 4),
            new OrderItem(new Product(4, "Table", "Furniture", 150), 1)
        )),
        new Order(3, new Customer(1, "Alice"), List.of(
            new OrderItem(new Product(5, "Notebook", "Stationery", 5), 10)
        ))
    );


    orders.stream()
        .collect(Collectors.groupingBy(order -> order.customer.getName(),
            Collectors.flatMapping(order -> order.items.stream()
                    .map(orderItem -> orderItem.getProduct().getCategory()),
                Collectors.toSet()))).entrySet()
        .stream().filter(entry -> entry.getValue().size() >= 2)
        .map(Entry::getKey).forEach(System.out::println);


    Map<String, Double> collect = orders.stream()
        .collect(Collectors.groupingBy(order -> order.customer.getName(),
            Collectors.summingDouble(order -> order.items.stream()
                .mapToDouble(item -> item.getQuantity() * item.getProduct().getPrice()).sum())));

    System.out.println(collect);

    orders.stream()
        .flatMap(order -> order.items.stream())
        .collect(Collectors.groupingBy(OrderItem::getProduct,
            Collectors.summingInt(OrderItem::getQuantity))).entrySet()
        .stream().sorted(Entry.comparingByValue(Comparator.reverseOrder()))
        .limit(3)
        .map(Entry::getKey).forEach(System.out::println);

  }
}

@AllArgsConstructor
@lombok.Data
class Customer {

  private int id;
  private String name;
}

@AllArgsConstructor
@lombok.Data
class OrderItem {

  private Product product;
  private int quantity;
}

@AllArgsConstructor
@lombok.Data
class Product {

  private int id;
  private String name;
  private String category;
  private double price;
}