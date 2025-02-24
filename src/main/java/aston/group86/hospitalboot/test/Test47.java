package aston.group86.hospitalboot.test;

import java.util.Map;

public class Test47 {
  /*Задача: дан массив целых чисел,
  нужно найти максимальную длинну подмассива,
  в котором каждый элемент повторяется не более двух раз
  Пример
  new int[]{1,2,1,1,1,2,1,3}) = 4*/

  public static void main(String[] args) {
    System.out.println(maxSequence(new int[]{2,2,2,2}));
  }

  public static int maxSequence(int[] arr) {
    int leftIndex= 0;
    int rightIndex = 0;
    int[] arrIndex = new int[20];
    int maxLength = 0;

    while (rightIndex < arr.length){

      if(arrIndex[arr[rightIndex]] < 2){
        arrIndex[arr[rightIndex]]++;
        rightIndex++;
      } else {
        arrIndex[arr[leftIndex]]--;
        leftIndex++;
      }
      int count = rightIndex - leftIndex;
      if(count > maxLength){
        maxLength = count;
      }
    }

    return maxLength;
  }

}
