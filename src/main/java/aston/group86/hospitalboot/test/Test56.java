package aston.group86.hospitalboot.test;


import java.util.HashMap;
import java.util.Map;

/***
 *
 * Задача: Самая длинная подстрока с четным количеством согласных
 *
 * Условие:
 * Дана строка s, состоящая из строчных букв английского алфавита.
 * Необходимо найти длину самой длинной подстроки, в которой количество каждой согласной буквы является четным.
 * Гласными буквами считаются: a, e, i, o, u. Они не учитываются при проверке условия.
 *
 * Примеры:
 *
 *     Ввод: s = "bcbcbc"
 *     Вывод: 4
 *     Объяснение:
 *     Подстрока "bcbc" (индексы 0–3) содержит согласные b, c, b, c. Количество b и c равно 2 (четное). Это самая длинная подходящая подстрока.
 *
 *     Ввод: s = "aabbcd"
 *     Вывод: 2
 *     Объяснение:
 *     Подстрока "ab" (индексы 0–1) содержит только согласную b (количество 2). Остальные подстроки либо содержат нечетные количества согласных, либо короче.
 *
 * Требования:
 *
 *     Решение должно работать за O(n) времени, где n — длина строки s.
 *
 * Подсказка:
 * Используйте битовую маску для отслеживания четности количества каждой согласной.
 * Сохраняйте первую позицию каждой маски. Если маска повторяется, разница между текущей позицией и первой даст длину валидной подстроки.
 *
 */

public class Test56 {

  public static String vowels = "aeiou";

  public static void main(String[] args) {

    System.out.println(longestSubstring("bcbcbc")); // 4
    System.out.println(longestSubstring("aabbcd")); // 2
  }

  private static int longestSubstring(String str) {

    int maxLength = 0;
    int mask = 0;
    Map<Integer, Integer> map = new HashMap<>();

    for (int i = 0; i < str.length(); i++) {
      char c = str.charAt(i);
      if (vowels.indexOf(c) == -1) {
        int bit = c - 'a';
        mask ^= (1 << bit);
      }

      if (map.containsKey(mask)) {
        maxLength = Math.max(maxLength, i - map.get(mask));
      } else {
        map.put(mask, i);
      }
    }
    return maxLength;
  }
}
