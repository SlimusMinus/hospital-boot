package aston.group86.hospitalboot.test;

import java.util.Stack;
import org.apache.kafka.common.protocol.types.Field.Str;

public class Task45 {

  public static void main(String[] args) {
    String arr = "}}";
    System.out.println(validString(arr));
  }

  //Есть строка из символов [ ] { } ( ). Надо провалидировать строку.
  // Валидна в том случае, если каждой открывающейся скобке //есть пара в закрывающейся
//Примеры: [{()}] - valid; []{} - valid; [}] – invalid
  public static boolean validString(String str) {
    Stack<String> stack = new Stack<>();

    String[] split = str.split("");

    for (int i = 0; i < str.length(); i++) {
      switch (split[i]) {
        case "{", "[", "(" -> stack.push(split[i]);
        default -> {
          if (stack.isEmpty()) {
            return false;
          }
          String pop = stack.pop();
          if (pop.equals("{") && !split[i].equals("}")) {
            return false;
          }
          if (pop.equals("[") && !split[i].equals("]")) {
            return false;
          }
          if (pop.equals("(") && !split[i].equals(")")) {
            return false;
          }
        }
      }
    }
    return true;
  }

}