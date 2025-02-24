package aston.group86.hospitalboot.test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Test91 {
  public static void main(String[] args) {
    Map<Integer, List<Long>> input = new HashMap<>();
    input.put(1, Arrays.asList(0l, 1l, 2l));
    input.put(2, Arrays.asList(3l, 4l));

    Map<Long, Integer> output = input.entrySet().stream()
        .flatMap(e -> e.getValue().stream().map(l -> new long[] {l, e.getKey()})) //long[] {v, k}
        .collect(Collectors.toMap(arr -> arr[0], arr -> (int) arr[1]));

    System.out.println(output);// 0=1, 1=1, 2=1, 3=2, 4=2

  }

}
