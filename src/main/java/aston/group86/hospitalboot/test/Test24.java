package aston.group86.hospitalboot.test;

//      Дан массив и длинна подмассива. Необходимо найти подмассив,
//      среднее значение элементов которого будет максимальным.
//      В данном случае подмассив с максимальным среднем значением является {12,-5,-6,50}
//        (12 - 5 - 6 + 50) / 4 = 12.75


import java.util.Arrays;

public class Test24 {

  public static void main(String[] args) {

   /*
   int k = 4;
    int max = 0;
    int sum = 0;
    int indexMax = 0;

    for (int i = 0; i < nums.length-k; i++) {

      for (int j = i; j < i+k; j++) {
        sum += nums[j];
      }

      if(max < sum){
        max = sum;
        indexMax = i;
        System.out.println(indexMax);
      }

      sum = 0;
    }

    System.out.println(Arrays.toString(Arrays.copyOfRange(nums, indexMax, indexMax + k)));*/
    int[] nums = {1, 12, -5, -6, 50, 3};

    int k = 4;
    int max = 0;
    int result = 0;
    int index = 0;
    for (int i = 0; i < k; i++) {
      max += nums[i];
    }
    result = max;
    for (int i = 1; i < nums.length - k; i++) {
      max = max - nums[i - 1] + nums[i + k];
      if (max > result) {
        result = max;
        index = i;
      }
    }
    System.out.println(Arrays.toString(Arrays.copyOfRange(nums, index, index + k)));

  }
}
