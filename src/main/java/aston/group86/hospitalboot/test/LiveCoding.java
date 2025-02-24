package aston.group86.hospitalboot.test;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LiveCoding {

  public static void main(String[] args) {
    System.out.println(Arrays.toString(plusOne(new int[]{9,9,9,9})));
  }

 /* Вам задано большое целое число, представленное
  в виде целого массива цифр, где каждая цифра [i] является i-й цифрой целого числа.
  Цифры расположены слева направо в порядке от наиболее значимого к наименее значимому.
  Большое целое число не содержит начальных 0. Увеличьте большое целое число на единицу
  и верните результирующий массив цифр.*/

  /*Example 1:

  Input: digits = [1,2,3]
  Output: [1,2,4]
  Explanation: The array represents the integer 123.
  Incrementing by one gives 123 + 1 = 124.
  Thus, the result should be [1,2,4].
  Example 2:

  Input: digits = [4,3,2,1]
  Output: [4,3,2,2]
  Explanation: The array represents the integer 4321.
  Incrementing by one gives 4321 + 1 = 4322.
  Thus, the result should be [4,3,2,2].
  Example 3:

  Input: digits = [9]
  Output: [1,0]
  Explanation: The array represents the integer 9.
  Incrementing by one gives 9 + 1 = 10.
  Thus, the result should be [1,0].*/


  public static int[] plusOne(int[] digits) {
      if(digits[digits.length-1] != 9){
        digits[digits.length-1]++;
        return digits;
      } else {
        int[] newArr = new int[digits.length+1];
        System.arraycopy(digits, 0, newArr, 0, newArr.length - 2);
        newArr[newArr.length-1] = 0;
        newArr[newArr.length-2] = 1;
        return newArr;
      }

  }
}

