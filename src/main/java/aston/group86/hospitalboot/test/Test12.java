package aston.group86.hospitalboot.test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Test12 {

  public static void main(String[] args) {

  }

  /*
   * Вернуть строку, которая содержит уникальные названия продуктов. Названия продуктов в строке должны быть разделены запятой
   */
  private List<String> products = List.of(
      "bacon avocado carrot banana",
      "butter bacon milk",
      "avocado carrot eggs"
  );

  public static String getUniqueProducts(List<String> products) {
   return products.stream()
        .flatMap(product-> Arrays.stream(product.split(" ")))
        .distinct()
        .collect(Collectors.joining(","));
  }
}
