package aston.group86.hospitalboot.test;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;

public class Test101 {

  public static void main(String[] args) {
    List<Student1> students = new ArrayList<>();

    students.stream()
        .flatMap(stud -> stud.getBooks().stream())
        .toList();
  }

}

@Data
class Student1 {
  private String name;
  private List<Book> books;
}

//Входные данные: List<Student> students = ...

//Получить: List<Book> books = ...