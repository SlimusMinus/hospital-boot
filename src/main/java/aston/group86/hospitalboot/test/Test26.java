package aston.group86.hospitalboot.test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;
import lombok.Data;

/*
Надвигается цунами и в районе эвакуации требуется в первую очередь обойти дома и эвакуировать больных и раненых (из Hospital),
во вторую очередь детей и стариков (до 18 и пенсионного возраста) а после всех остальных. В первый этап эвакуации мест
в эвакуационном транспорте только 500. Вывести всех людей попадающих в первый этап эвакуации в порядке приоритета (в консоль).
*/

public class Test26 {

  public static void main(String[] args) {
    List<House> houses = new ArrayList<>();

    Predicate<House> housePredicate = building -> "Hospital".equals(building.getBuildingType());
    Function<House, Stream<? extends Person>> houseStreamFunction = house -> house.getPersonList().stream();
    Predicate<Person> childPredicate = person -> person.getDateOfBirth().isAfter(LocalDate.now().minusYears(18));
    Predicate<Person> gpPredicate =  person -> person.getDateOfBirth().isBefore(LocalDate.now().minusYears(65));

    Stream<Person> hospitalStream = houses.stream()
        .filter(housePredicate)
        .flatMap(houseStreamFunction);

    Stream<Person> childAndGP = houses.stream()
        .filter(housePredicate.negate())
        .flatMap(houseStreamFunction)
        .filter(childPredicate.or(gpPredicate));

    Stream<Person> personStream = houses.stream()
        .filter(housePredicate.negate())
        .flatMap(houseStreamFunction)
        .filter(childPredicate.negate().and(gpPredicate.negate()));

    Stream.concat(Stream.concat(hospitalStream, childAndGP), personStream).limit(500).forEach(System.out::println);

  }
}

@Data
class House {

  private int id;
  private String buildingType;
  private List<Person> personList;

  public House() {
  }
}

@Data
class Person {

  private int id;
  private String firstName;
  private String lastName;

  private LocalDate dateOfBirth;
  private String email;

  private String gender;
  private int recruitmentGroup;
  private String city;
  private String occupation;

  public Person() {
  }
}