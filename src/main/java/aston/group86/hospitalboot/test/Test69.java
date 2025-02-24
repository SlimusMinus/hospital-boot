package aston.group86.hospitalboot.test;

/*
Задача: Валидация скобочных последовательностей
Дана строка, содержащая только символы '(', ')', '{', '}', '[' и ']'.
Определите, является ли входная строка валидной.

Правила валидности:
1. Открытые скобки должны закрываться скобками того же типа.
2. Открытые скобки должны закрываться в правильном порядке.
3. Каждая закрывающая скобка должна иметь
Примеры:
Вход: "()[]{}" → true
Вход: "([)]"   → false
Вход: "{[]}"   → true
*/


import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Test69 {

  public static void main(String[] args) {
    System.out.println(isValid("()[]{}")); // true
    System.out.println(isValid("([)]"));   // false
    System.out.println(isValid("{[]}"));   // true
  }

  public static boolean isValid(String s) {

    Map<Character, Character> map = Map.of(
        '(', ')',
        '[', ']',
        '{', '}'
    );

    Stack<Character> stack = new Stack<>();

    for (char str : s.toCharArray()) {
      if (map.containsKey(str)) {
        stack.push(map.get(str));
      } else {
        if (stack.isEmpty() || str != stack.pop()) {
          return false;
        }
      }
    }
    return stack.isEmpty();
  }

}
