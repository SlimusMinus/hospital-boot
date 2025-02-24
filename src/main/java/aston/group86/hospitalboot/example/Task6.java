package aston.group86.hospitalboot.example;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Task6 {

  // Дан массив чисел, сколько раз встречается каждое число

  // * самое популярное число

  public static void main(String[] args) {

    int[] arr = new int[]{1, 1, 2, 3};
    System.out.println(getIntegerMap(arr));

  }

  public static Integer getIntegerMap(int[] arr) {

    Map<Integer, Integer> map = new HashMap<>();

    for (int i = 0; i < arr.length; i++) {
      if (map.containsKey(arr[i])) {
        map.put(arr[i], map.get(arr[i]) + 1);
      } else {
        map.put(arr[i], 1);
      }
    }

    int max = 0;
    for(var item : map.entrySet()){
      if(max < item.getValue()){
        max = item.getKey();
      }
    }

    return max;

  }

}