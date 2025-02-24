package aston.group86.hospitalboot.test;

public class Task41 {

  public static void main(String[] args) {
    //Дан массив, содержащий 1 и 0.
    // Найти длинну самой большой неприрывной последовательности 1.
//Пример int[]{1,1,0,1,1,1,0} = 3
    int[] arr = new int[]{1, 1, 0, 1, 1, 1, 0};
    System.out.println(biggestOne(arr));
  }

  public static int biggestOne(int[] arr) {
    int max = 0;
    int count = 0;
    for (int j : arr) {
      if (j == 1) {
        count++;
      } else {
        count = 0;
      }
      if (count > max) {
        max = count;
      }
    }
    return max;
  }

}
