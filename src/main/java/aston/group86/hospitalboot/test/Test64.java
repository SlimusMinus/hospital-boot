package aston.group86.hospitalboot.test;

import java.util.Arrays;

public class Test64 {

  public static void main(String[] args) {
    String[] str = {"flower", "awow", "rtight"};
    System.out.println(longestCommonPrefix(str));

  }
  //поиск самого длинного префикса во всех словах
  public static String longestCommonPrefix(String[] strs) {
    int i = 0;
    Arrays.sort(strs);
    String startWord = strs[0];
    String finishWord = strs[strs.length - 1];
    while (startWord.charAt(i) == finishWord.charAt(i)) {
      i++;
    }
    return startWord.substring(0, i);
  }
}
