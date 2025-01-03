package aston.group86.hospitalboot.test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Test20 {

  /*
  new int[] { 20, 37, 20, 21 }, 1
new int[] { 20, 37, 21 }

new int[] { 1, 1, 3, 3, 7, 2, 2, 2, 2 }, 3
new int[] { 1, 1, 3, 3, 7, 2, 2, 2 }

new int[] { 1, 2, 3, 1, 1, 2, 1, 2, 3, 3, 2, 4, 5, 3, 1 }, 3
new int[] { 1, 2, 3, 1, 1, 2, 2, 3, 3, 4, 5 }

new int[] { 1, 1, 1, 1, 1 }, 5
new int[] { 1, 1, 1, 1, 1 }

new int[] { }, 5
new int[] { }
   */
  public static void main(String[] args) {
    System.out.println(Arrays.toString(arrInt(new int[]{1, 1, 3, 3, 7, 2, 2, 2, 2}, 1)));
  }

  static int[] arrInt(int[] array, int num) {
    Map<Integer, Integer> map = new HashMap<>();

    return Arrays.stream(array)
        .boxed()
        .peek(num1 -> map.put(num1, map.getOrDefault(num1, 0) + 1))
        .filter(num1 -> map.get(num1) <= num)
        .mapToInt(val -> val)
        .toArray();
  }

}