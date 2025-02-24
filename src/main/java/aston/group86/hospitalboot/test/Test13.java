package aston.group86.hospitalboot.test;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Test13 {
  // 1. найти первый неповторяющийся символ в строке

  public static void main(String[] args) {
    String str = "sadvawidsvs";

    String[] arr = str.split("");
    Map<String, Integer> map = new LinkedHashMap<>();

    for(var item : arr){
      if(map.containsKey(item)){
        Integer count = map.get(item);
        count++;
        map.put(item, count);
      } else{
        map.put(item, 1);
      }
    }

   for(var item : map.entrySet()){
     if(item.getValue() == 1){
       System.out.println("First unique char: " + item.getKey());
       return;
     }
   }

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
