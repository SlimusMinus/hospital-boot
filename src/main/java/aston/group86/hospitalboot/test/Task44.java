package aston.group86.hospitalboot.test;

public class Task44 {

  public static void main(String[] args) {
     int[] arr = new int[] {-3,-1,2,-1,1,1};
    System.out.println(subarray(arr));
  }


  //Найти подмассив с наибольшей суммой в массиве. Вывести результат
// Пример массива new int[] {-3,-1,2,-1,1,1} = 3


  public static int subarray(int[] arr) {
    int sum = arr[0];
    int currentSum = arr[0];
    for (int i = 1; i < arr.length; i++) {

      if (currentSum >= arr[i]) {
        currentSum = currentSum + arr[i];
      } else{
        currentSum = arr[i];
      }

      if(currentSum > sum){
        sum = currentSum;
      }
    }
    return sum;
  }






























}
