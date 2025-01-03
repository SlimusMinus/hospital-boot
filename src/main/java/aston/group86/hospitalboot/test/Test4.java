package aston.group86.hospitalboot.test;

public class Test4 {

  public static void main(String[] args) {
    System.out.println(equalSidesOfAnArray(new int[]{1, 100, 50, -51, 1, 1}));
  }

  // {1,2,3,4,3,2,1} = 3
  // {1,100,50,-51,1,1} = 1
  // {20,10,-80,10,10,15,35} = 0
  private static int equalSidesOfAnArray(int[] arr) {

   /* int sumL = 0;
    int sumR = 0;

    for (int i = 0; i < arr.length; i++) {

      for (int j = i + 1; j < arr.length; j++) {
        sumR += arr[j];
      }
      if (sumL == sumR) {
       return i;
      }
      sumL += arr[i];
      sumR=0;
    }*/

    for (int i = 0; i < arr.length; i++) {
      int sumR = 0;
      int sumL = 0;
      for (int j = i + 1; j < arr.length; j++) {
        sumR += arr[j];
      }
      for (int k = 0; k < i; k++) {
        sumL += arr[k];
      }
      if (sumR == sumL) {
        return i;
      }
    }

    return -1;
  }

}
