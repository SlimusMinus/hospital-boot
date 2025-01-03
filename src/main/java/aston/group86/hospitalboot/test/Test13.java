package aston.group86.hospitalboot.test;

import java.util.LinkedHashMap;
import java.util.Map;

public class Test13 {
  // 1. найти первый неповторяющийся символ в строке

  public static void main(String[] args) {
    String str = "sadvawidsvs";
    System.out.println("First unique char: " + getFirstUniqueChar(str));
  }

  public static Character getFirstUniqueChar(String str) {
    char[] charArray = str.toCharArray();
    Map<Character, Integer> arrays = new LinkedHashMap<>();
    for (char c : charArray) {
      if(arrays.containsKey(c)) {
        Integer count = arrays.get(c);
        count++;
        arrays.put(c, count);
      }
      else{
        arrays.put(c, 1);
      }
    }

    for(var item : arrays.entrySet()){
      if(item.getValue() == 1)
        return item.getKey();
    }
    return null;
  }

}
