package aston.group86.hospitalboot.test;


/*Дан список заказов, каждый из которых содержит список товаров.
Найдите самый популярный товар (по количеству заказов) в каждой категории товаров.*/

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.Getter;

public class App7 {

  public static void main(String[] args) {
    List<Order5> orders =
        List.of(
            new Order5(1, List.of(new Product5("Laptop", "Electronics"),
                new Product5("Phone", "Electronics"))),
            new Order5(2, List.of(new Product5("Laptop", "Electronics"),
                new Product5("Tablet", "Electronics"))),
            new Order5(3, List.of(new Product5("Tablet", "Electronics"),
                new Product5("Headphones", "Electronics"))),
            new Order5(4,
                List.of(new Product5("Shirt", "Clothing"), new Product5("Shoes", "Clothing"))),
            new Order5(5,
                List.of(new Product5("Shirt", "Clothing"), new Product5("Shoes", "Clothing"))),
            new Order5(6, List.of(new Product5("Laptop", "Electronics"),
                new Product5("Headphones", "Electronics"))),
            new Order5(7, List.of(new Product5("Tablet", "Electronics"),
                new Product5("Phone", "Electronics"))),
            new Order5(8,
                List.of(new Product5("Shoes", "Clothing"), new Product5("Jeans", "Clothing"))),
            new Order5(9,
                List.of(new Product5("Shirt", "Clothing"), new Product5("Jeans", "Clothing"))),
            new Order5(10, List.of(new Product5("Headphones", "Electronics"),
                new Product5("Laptop", "Electronics"))),
            new Order5(11, List.of(new Product5("Laptop", "Electronics"),
                new Product5("Tablet", "Electronics"))),
            new Order5(12,
                List.of(new Product5("Shoes", "Clothing"), new Product5("Jeans", "Clothing"))),
            new Order5(13, List.of(new Product5("Tablet", "Electronics"),
                new Product5("Phone", "Electronics"))),
            new Order5(14,
                List.of(new Product5("Shoes", "Clothing"), new Product5("Shirt", "Clothing"))),
            new Order5(15, List.of(new Product5("Laptop", "Electronics"),
                new Product5("Headphones", "Electronics"))));

    Map<String, String> collect = orders.stream()
        .flatMap(order -> order.getProduct5s().stream())
        .collect(Collectors.groupingBy(Product5::getCategory,
            Collectors.groupingBy(Product5::getName, Collectors.counting())))
        .entrySet().stream()
        .collect(Collectors.toMap(Map.Entry::getKey,
            entry -> entry.getValue()
                .entrySet().stream()
                .max(Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("default_value") // Или заменить на .orElse("default_value")
        ));

    System.out.println(collect);

  }

}

class Order5 {

  private int id;
  private List<Product5> Products;

  public Order5(int id, List<Product5> Product5s) {
    this.id = id;
    this.Products = Product5s;
  }

  public List<Product5> getProduct5s() {
    return Products;
  }
}

class Product5 {

  private String name;
  private String category;

  public Product5(String name, String category) {
    this.name = name;
    this.category = category;
  }

  public String getName() {
    return name;
  }

  public String getCategory() {
    return category;
  }
}


