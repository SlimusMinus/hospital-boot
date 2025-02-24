package aston.group86.hospitalboot.test;

public class Test86 {

  public static void main(String[] args) {
    System.out.println(searchInsert(new int[]{1, 3, 5, 6}, 5));
    System.out.println(searchInsert(new int[]{1, 3, 5, 6}, 2));
    System.out.println(searchInsert(new int[]{1, 3, 5, 6}, 7));

  }

  //Input: nums = [1,3,5,6], target = 5, Output: 2
  //Input: nums = [1,3,5,6], target = 2, Output: 1
  //Input: nums = [1,3,5,6], target = 7, Output: 4

/*
  Дано отсортированное множество различных целых чисел и целевое значение,
  вернуть индекс, если цель найдена. Если нет, вернуть индекс, где бы он был,
  если бы он был вставлен по порядку.
*/

  public static int searchInsert(int[] nums, int target) {

    int leftIndex = 0;
    int rightIndex = nums.length - 1;
    int middle = 0;

    while (leftIndex <= rightIndex) {
      middle = (rightIndex - leftIndex) / 2 + leftIndex;
      if (target == nums[middle]) {
        return middle;
      }
      if (target > nums[middle]) {
        leftIndex = middle + 1;
      } else if (target < nums[middle]) {
        rightIndex = middle - 1;
      }
    }

    if(target > nums[middle]){
      return ++middle;
    }

    return middle;

  }
}
