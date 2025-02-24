package aston.group86.hospitalboot.test;

import java.util.ArrayDeque;
import java.util.Map;

public class Test14 {
/*6. Дана строка, состоящая из символов (,),{,},[,]
  Корректной считается строка, если каждая открытая скобка закрывается закрывающей скобкой того же типа в правильном порядке
  Определить, является ли строка корректной
  Input: s = "[(])"
  Output: false

  Input: s = "([{}])"
  Output: true

  Input: s = "[]"
  Output: true*/

  public static void main(String[] args) {
    String s = "[(])";
    System.out.println(isValid(s));

  }

  public static boolean isValid(String s) {
    Map<Character, Character> chars = Map.of(
        '}', '{',
        ')', '(',
        ']', '['
    );

    ArrayDeque<Character> stack = new ArrayDeque<>();

    char[] charArray = s.toCharArray();

    for (var item : charArray) {
      if (chars.containsKey(item)) {
        if(!stack.isEmpty() && (chars.get(item) == stack.peek())){
          stack.pop();
        } else {
          return false;
        }
      } else {
        stack.push(item);
      }
    }
    return stack.isEmpty();
  }

}
