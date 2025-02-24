package aston.group86.hospitalboot.test;

import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import org.apache.kafka.common.protocol.types.Field.Str;

class Product1 {
  private final String name;
  private final double price;
  private final String category;

  public Product1(String name, double price, String category) {
    this.name = name;
    this.price = price;
    this.category = category;
  }

  public String getName() {
    return name;
  }

  public double getPrice() {
    return price;
  }

  public String getCategory() {
    return category;
  }
}

class ProductService {
  private final List<Product1> products;

  public ProductService(Collection<Product1> products) {
    this.products = new ArrayList<>(products);
  }

  public List<Product1> filterAndSortProducts(ProductFilter productFilter) {

    /*ExecutorService executor = Executors.newFixedThreadPool(4);

    List<Future<List<Product1>>> futures = new ArrayList<>();
    for (int i = 0; i < 4; i++) {
      int start = i * (products.size() / 4);
      int end = (i + 1) * (products.size() / 4);
      futures.add(executor.submit(() -> {
        return products.subList(start, end).stream()
            .filter(p -> p.getPrice() > 20)
            .sorted(Comparator.comparing(Product1::getPrice))
            .collect(Collectors.toList());
      }));
    }

    List<Product1> result = new ArrayList<>();
    for (Future<List<Product1>> future : futures) {
      try {
        result.addAll(future.get());
      } catch (Exception e) {
        e.printStackTrace();
      }
    }

    executor.shutdown();
    return result.stream().sorted(Comparator.comparing(Product1::getPrice)).collect(Collectors.toList());*/

    return products.parallelStream().filter(productFilter::filter).sorted(Comparator.comparing(Product1::getPrice)).toList();
  }
}

@FunctionalInterface
interface ProductFilter{
  boolean filter(Product1 product1);
}

class FilterByPrice implements ProductFilter{

  private final double trashHold;

  public FilterByPrice(double trashHold) {
    this.trashHold = trashHold;
  }

  @Override
  public boolean filter(Product1 product1) {
    return product1.getPrice() > trashHold;
  }
}

class FilterByName implements ProductFilter{

  private final String name;

  public FilterByName(String name) {
    this.name = name;
  }

  @Override
  public boolean filter(Product1 product1) {
    return product1.getName().equals(name);
  }
}

class Main {
  public static void main(String[] args) {
    List<Product1> products = Arrays.asList(
        new Product1("Laptop", 1500, "Electronics"),
        new Product1("Shirt", 30, "Clothing"),
        new Product1("Smartphone", 800, "Electronics"),
        new Product1("Book", 15, "Stationery"),
        new Product1("Chair", 50, "Furniture")
    );

    ProductService productService = new ProductService(products);

    ProductFilter productFilter = new FilterByName("Laptop");

    List<Product1> filteredProducts = productService.filterAndSortProducts(productFilter);

    filteredProducts.forEach(p -> System.out.println(p.getName() + " - " + p.getPrice()));
  }
}