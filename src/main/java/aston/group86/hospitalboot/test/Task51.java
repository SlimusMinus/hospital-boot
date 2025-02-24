package aston.group86.hospitalboot.test;

import java.util.HashSet;
import java.util.Set;

public class Task51 {

  public static void main(String[] args) {
    System.out.println(lengthOfLongestSubstring("qrsvbspk"));
  }

  static int lengthOfLongestSubstring(String s) {
    Set<Character> set = new HashSet<>(); // Множество для хранения уникальных символов
    int maxLength = 0; // Максимальная длина подстроки
    int leftIndex = 0; // Левый указатель (начало окна)

    // Перебираем символы строки с помощью правого указателя
    for (int rightIndex = 0; rightIndex < s.length(); rightIndex++) {
      char currentChar = s.charAt(rightIndex); // Текущий символ

      // Если символ уже есть в множестве, сдвигаем левый указатель, удаляя символы из окна
      while (set.contains(currentChar)) {
        set.remove(s.charAt(leftIndex));
        leftIndex++;
      }

      // Добавляем текущий символ в множество
      set.add(currentChar);

      // Обновляем максимальную длину подстроки
      maxLength = Math.max(maxLength, rightIndex - leftIndex + 1);
    }

    return maxLength; // Возвращаем максимальную длину
  }
}
