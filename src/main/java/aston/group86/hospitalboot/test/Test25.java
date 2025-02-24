package aston.group86.hospitalboot.test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class Test25 {

  public static void main(String[] args) {
    List<Sale> sales = Arrays.asList(
        new Sale("Laptop", "Electronics", 2, 1500.0),
        new Sale("Smartphone", "Electronics", 5, 800.0),
        new Sale("T-Shirt", "Clothing", 10, 25.0),
        new Sale("Jeans", "Clothing", 4, 50.0),
        new Sale("Coffee Machine", "Home Appliances", 1, 200.0),
        new Sale("Vacuum Cleaner", "Home Appliances", 3, 300.0)
    );

    //вывести товары с общей стоимостью больше 1000
    //развернуть мапу где ключ - категория, значение - лист продаж

  /*  Set<String> list = sales.stream()
        .map(Sale::getCategory)
        .collect(Collectors.toSet());
    list.forEach(System.out::println);*/

    /*Optional<Sale> max = sales.stream()
        .max(Comparator.comparingDouble(Sale::getTotalPrice));
    max.ifPresent(m-> System.out.println(m.getProductName()));*/

    /*Map<String, Double> collect = sales.stream()
        .collect(Collectors.groupingBy(
            Sale::getCategory, Collectors.summingDouble(Sale::getTotalPrice)
        ));
    System.out.println(collect);*/

  }

  private static class Sale {

    private String productName;
    private String category;
    private int quantity;
    private double price;

    public Sale(String productName, String category, int quantity, double price) {
      this.productName = productName;
      this.category = category;
      this.quantity = quantity;
      this.price = price;
    }

    public String getProductName() {
      return productName;
    }

    public String getCategory() {
      return category;
    }

    public int getQuantity() {
      return quantity;
    }

    public double getPrice() {
      return price;
    }

    public double getTotalPrice() {
      return quantity * price;
    }


  }
  }

