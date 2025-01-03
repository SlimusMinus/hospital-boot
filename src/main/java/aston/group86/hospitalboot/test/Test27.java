package aston.group86.hospitalboot.test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.Data;

/*
* В списке клиентов (Customer), содержащих адрес (CustomerAddress)
найти клиентов, количество которых в городе 3 или больше;
отсортировать по городу, потом по улице,
потом по номеру дома в обратном порядке,
затем по фамилии.
Полученный список вывести в консоль в формате:
Фамилия Имя, город, улица, дом - квартира.
Пример вывода одной строки:
"Ellsworth Mills, city: Columbus, street: Borge, 185-72"
*/

public class Test27 {

  public static void main(String[] args) {
    List<Customers> customersList = List.of(
        new Customers(1, "Kerry", "Andreia", "kandreia0@comsenz.com",
            new CustomerAddress(238713, "Minsk", "Elin", "20", "28")),
        new Customers(2, "Goddart", "Bentall", "gbentall1@etsy.com",
            new CustomerAddress(523555, "Moscow", "Browning", "76", "74")),
        new Customers(3, "Gerome", "McGraw", "gmcgraw2@hubpages.com",
            new CustomerAddress(405867, "Minsk", "Queens", "199", "42")),
        new Customers(4, "Kristin", "Joscelyn", "kjoscelyn3@cyberchimps.com",
            new CustomerAddress(499449, "Minsk", "Eleseum", "55", "7")),
        new Customers(5, "Cammie", "Joyson", "cjoyson4@opera.com",
            new CustomerAddress(279219, "Moscow", "Eleseum", "58", "40")),
        new Customers(6, "Sofia", "Swadon", "sswadon5@arizona.edu",
            new CustomerAddress(740725, "Minsk", "Horn", "147", "65")),
        new Customers(7, "Shayla", "Johananoff", "sjohananoff6@imageshack.us",
            new CustomerAddress(233859, "Moscow", "Borge", "161", "16")),
        new Customers(8, "Trixi", "Pautot", "tpautot7@goo.gl",
            new CustomerAddress(814154, "Samara", "Work", "48", "7")),
        new Customers(9, "Sigmund", "McGougan", "smcgougan8@senate.gov",
            new CustomerAddress(100021, "Grodno", "Borge", "30", "55")),
        new Customers(10, "Nathaniel", "Parradine", "nparradine9@freewebs.com",
            new CustomerAddress(268167, "Krzynowłoga Mała", "Silver", "114", "22")));

    Map<String, Long> cityMap = customersList.stream()
        .collect(Collectors.groupingBy(customers -> customers.getAddress().getCity(),
            Collectors.counting()));

    Comparator<Customers> cityComparing = Comparator.comparing(
        customers -> customers.getAddress().getCity());

    Comparator<Customers> streetComparing = Comparator.comparing(
        customers -> customers.getAddress().getStreet());

    Comparator<Customers> houseComparing = Comparator.comparing(
        customers -> customers.getAddress().getBuildingNumber());

    Comparator<Customers> familyComparing = Comparator.comparing(
        Customers::getLastName);

    customersList.stream()
        .filter(customers -> cityMap.get(customers.getAddress().getCity()) >= 3)
        .sorted(cityComparing.thenComparing(streetComparing).thenComparing(houseComparing.reversed()).thenComparing(familyComparing))
        .forEach(customers -> System.out.println(customers.getLastName() + " " + customers.getFirstName() + ", " + customers.getAddress().getCity()));


  }
}

@Data
@AllArgsConstructor
class Customers {

  private int id;
  private String firstName;
  private String lastName;
  private String email;
  private CustomerAddress address;

  public Customers() {
  }

}

@Data
@AllArgsConstructor
class CustomerAddress {

  private int zip;
  private String city;
  private String street;
  private String buildingNumber;
  private String flatNumber;
}