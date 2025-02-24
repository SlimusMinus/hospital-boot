package aston.group86.hospitalboot.test;

public class Test15 {

  public static void main(String[] args) {
    // Напишите программу, чтобы найти второе по величине число в массиве
    int[] numbersArray = {10, 15, 32, 100, -99, 11, 98, 36, 95, 33, 100};
  //  int[] numbersArray = {-10, -15, -32, -100};

    int firstMax = Integer.MIN_VALUE;
    int secondMax = Integer.MIN_VALUE;

    for (int i = 0; i < numbersArray.length; i++) {
      if (firstMax < numbersArray[i]) {
        secondMax = firstMax;
        firstMax = numbersArray[i];
      } else if (numbersArray[i] < firstMax && numbersArray[i] > secondMax) {
        secondMax = numbersArray[i];
      }
    }
    System.out.println(secondMax);

  }

}
