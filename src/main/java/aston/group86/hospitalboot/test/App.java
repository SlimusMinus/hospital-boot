package aston.group86.hospitalboot.test;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class App {

  public static void main(String[] args) {
    List<Data> dataList = List.of(new Data("22", "1"),
        new Data("11", "3"),
        new Data("11", "4"),
        new Data("33", "1"));
    System.out.println(findData2(dataList));
//Задача: Реализовать метод, который сравнит даты и уберет дубликаты по кодам (версии при сравнении не учитываются)
  }



  public static Collection<Data> findData2(List<Data> data){
    return data.stream()
        .collect(Collectors.toMap(Data::getCode, obj->obj, (k1, k2)-> k1))
        .values();
  }



}
