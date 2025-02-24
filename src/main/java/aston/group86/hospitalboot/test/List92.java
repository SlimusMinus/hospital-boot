package aston.group86.hospitalboot.test;

import java.util.DoubleSummaryStatistics;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class List92 {

  public static void main(String[] args) {
    List<Phones> phoneStream = List.of(new Phones("iPhone X", "Apple", 600),
        new Phones("Pixel 2", "Google", 500),
        new Phones("iPhone 8", "Apple",450),
        new Phones("Galaxy S9", "Samsung", 440),
        new Phones("Galaxy S8", "Samsung", 340));

    Map<String, DoubleSummaryStatistics> collect = phoneStream.stream()
        .collect(Collectors.groupingBy(Phones::getCompany,
            Collectors.summarizingDouble(Phones::getPrice)));

    System.out.println(collect);
  }

}

class Phones{

  private String name;
  private String company;
  private int price;

  public Phones(String name, String comp, int price){
    this.name=name;
    this.company=comp;
    this.price = price;
  }

  public String getName() { return name; }
  public int getPrice() { return price; }
  public String getCompany() { return company; }
}