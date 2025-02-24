package aston.group86.hospitalboot.test;

import java.util.Arrays;
import java.util.List;

public class Tset18 {
  /*
   Что будет результатом? (выбрать один)
 a) ничего не будет выведено
 b) 5, 70.0
 c) 1, 50.0
 d) 7, 70.0
    */
  public static void main(String[] args) {
    List<Order2> orders = Arrays.asList(
        new Order2(1, 50),
        new Order2(5, 70),
        new Order2(7, 70));

    orders.stream()
        .reduce((p1, p2) -> p1.amount > p2.amount ? p1 : p2)
        .ifPresent(System.out::println);
  }
}

class Order2 {
  long orderId;
  double amount;
  public Order2(long orderId, double amount) {
    this.orderId = orderId;
    this.amount = amount;
  }
  public String toString() {
    return orderId + ", " + amount ;
  }
}