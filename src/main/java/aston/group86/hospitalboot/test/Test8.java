package aston.group86.hospitalboot.test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.Data;
import nonapi.io.github.classgraph.json.JSONUtils;
import org.w3c.dom.ls.LSOutput;

public class Test8 {

}

@AllArgsConstructor
@Data
class Student {

  private String name; // имя
  private int age; // возраст
  private double grade; // оценка (0-100)
  private String major; // специальность

  //1. Отфильтровать студентов, старше 18 лет.
  //2. Группировать студентов по специальности.
  //3. Найти среднюю оценку для каждой специальности.
  //4. Отсортировать специальности по средней оценке в порядке убывания.
  //5. Вернуть результат как `Map`, где ключом является специальность, а значением — средняя оценка.
  public static void main(String[] args) {
    List<Student> students = Arrays.asList(
        new Student("Alice", 20, 85, "Computer Science"),
        new Student("Bob", 17, 90, "Mathematics"),
        new Student("Charlie", 22, 70, "Computer Science"),
        new Student("Dave", 19, 60, "Mathematics"),
        new Student("Eve", 21, 95, "Physics"),
        new Student("Frank", 24, 80, "Physics")
    );

    /*
Map<String, Double> collect = students.stream()
    .filter(student -> student.age > 18)
    .collect(
        Collectors.groupingBy(Student::getMajor, Collectors.averagingDouble(Student::getGrade)))
    .entrySet()
    .stream().sorted(Entry.<String, Double>comparingByValue().reversed())
    .collect(
        Collectors.toMap(Entry::getKey, Entry::getValue, (v1, v2) -> v1, LinkedHashMap::new));
    System.out.println(collect);*/


  }
}



















