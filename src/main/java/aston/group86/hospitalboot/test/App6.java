package aston.group86.hospitalboot.test;

//Найди людей старше 30 лет, сгруппируйте их по городу, и для каждого города отсортируй людей по имени.

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class App6 {

  public static void main(String[] args) {
    List<Person2> people = Arrays.asList(
        new Person2("John", 25, "New York"),
        new Person2("Alice", 35, "Los Angeles"),
        new Person2("Bob", 40, "New York"),
        new Person2("Charlie", 32, "Los Angeles"),
        new Person2("David", 28, "Chicago"),
        new Person2("Eve", 45, "Chicago"));

    Map<String, List<Person2>> collect = people.stream()
        .filter(person -> person.age > 30)
        .collect(Collectors.groupingBy(Person2::getCity,
            Collectors.collectingAndThen(Collectors.toList(),
                list -> list.stream()
                    .sorted(Comparator.comparing(Person2::getName))
                    .toList())));

    System.out.println(collect);


  }

}

class Person2 {

  String name;
  int age;
  String city;

  Person2(String name, int age, String city) {
    this.name = name;
    this.age = age;
    this.city = city;
  }

  public String getName() {
    return name;
  }

  public int getAge() {
    return age;
  }

  public String getCity() {
    return city;
  }

  @Override
  public String toString() {
    return name + " (" + age + ", " + city + ")";
  }
}