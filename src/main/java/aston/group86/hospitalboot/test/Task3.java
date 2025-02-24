package aston.group86.hospitalboot.test;


import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.apache.kafka.common.protocol.types.Field.Str;

public class Task3 {

  public static void main(String[] args) {
    List<String> colors = Arrays.asList("Red", "Green", "Blue", "Pink", "Brown");

    System.out.println(startColorCount(colors, "B"));

    Map<Boolean, List<String>> listMap = startWithB(colors);
    System.out.println(listMap);
  }

  public static long startColorCount(List<String> strings, String colorLetter) {
    return strings.stream()
        .filter(color-> String.valueOf(color.charAt(0)).equals(colorLetter))
        .count();
  }

  public static Map<Boolean, List<String>> startWithB(List<String> colors) {
    return colors.stream()
        //.collect(Collectors.partitioningBy(color -> color.charAt(0) == 'B'));
    .collect(Collectors.groupingBy(color -> color.charAt(0) == 'B'));

  }
}
