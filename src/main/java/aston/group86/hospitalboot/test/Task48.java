package aston.group86.hospitalboot.test;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;
import javax.print.DocFlavor.STRING;

public class Task48 {

  public static void main(String[] args) {
    String str1 = "cat";
    String str2 = "tca";
    System.out.println(anagram(str1, str2));

  }

  public static boolean anagram(String str1, String str2) {
    if (str1.length() != str2.length()) {
      return false;
    }

    char[] charArray = str1.toCharArray();
    char[] charArray1 = str2.toCharArray();
    Arrays.sort(charArray);
    Arrays.sort(charArray1);

    return Arrays.equals(charArray, charArray1);

  }
}
