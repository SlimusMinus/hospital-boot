package aston.group86.hospitalboot.test;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Task53 {

  public static void main(String[] args) {

    Set<Integer> sets = Set.of(8,9,33,6,1,15);

    sets.stream().sorted().collect(Collectors.toCollection(LinkedHashSet::new)).forEach(System.out::println);

  }

}
