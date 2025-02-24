package aston.group86.hospitalboot.test;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.Data;

public class Test32 {
  public static void main(String[] args) {
    Worker worker1 = new Worker("Tom", 22, 100, "Manager");
    Worker worker2 = new Worker("Max", 22, 200, "Manager");
    Worker worker3 = new Worker("Anna", 44, 150, "Manager");
    Worker worker4 = new Worker("Ted", 19, 122, "QA");
    Worker worker5 = new Worker("Vladislav", 25, 500, "QA");

    List<Worker> workers = List.of(worker1, worker2, worker3, worker4, worker5);

    Map<String, Long> collect = workers.stream()
        .collect(Collectors.groupingBy(Worker::getPosition, Collectors.counting()));
    System.out.println(collect);

    Map<String, Double> collect1 = workers.stream()
        .collect(Collectors.groupingBy(Worker::getPosition, Collectors.averagingLong(Worker::getSalary)));
    System.out.println(collect1);

    Map<String, String> collect2 = workers.stream()
        .collect(Collectors.groupingBy(Worker::getPosition, Collectors.mapping(Worker::getName, Collectors.joining(","))));
    System.out.println(collect2);

  }
}

@AllArgsConstructor
@Data
class Worker{
  String name;
  int age;
  int salary;
  String position;
}
