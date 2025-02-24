package aston.group86.hospitalboot.test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Task54 {

  public static void main(String[] args) {
    int[] array = new int[]{3,3};
    System.out.println(Arrays.toString(twoSum(array, 6)));
  }

  public static int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();

    for (int i = 0; i < nums.length; i++) {

      int secondIndex = target - nums[i];

      if(map.containsKey(secondIndex)){
        return new int[]{i, map.get(secondIndex)};
      }

      map.put(nums[i],i);
    }
    
    throw new RuntimeException("nums not found");
  }

}
