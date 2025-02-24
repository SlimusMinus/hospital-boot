package aston.group86.hospitalboot.test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import lombok.Data;

/*Из перечня автомобилей приходящих на рынок Азии логистическому агентству предстоит отсортировать их в порядке следования
1.Туркменистан - 2.Узбекистан - 3.Казахстан - 4.Кыргызстан - 5.Россия - 6.Монголия.
Все автомобили марки "Jaguar" а так же все авто цвета White идут в первую страну.
Из оставшихся все автомобили с массой до 1500 кг и марок BMW, Lexus, Chrysler и Toyota идут во второй эшелон.
Из оставшихся все автомобили Черного цвета с массой более 4000 кг и все GMC и Dodge идут в третий эшелон.
Из оставшихся все автомобили года выпуска до 1982 или все модели "Civic" и "Cherokee" идут в четвёртый эшелон.
Из оставшихся все автомобили цветов НЕ Yellow, Red, Green и Blue или же по стоимости дороже 40000 в пятый эшелон
Из оставшиеся все автомобили в vin номере которых есть цифра "59" идут в последний шестой эшелон.
Оставшиеся автомобили отбрасываем, они никуда не идут.
Измерить суммарные массы автомобилей всех эшелонов для каждой из стран и подсчитать сколько для каждой страны
будет стоить транспортные расходы если учесть что на 1 тонну транспорта будет потрачено 7.14 $.
Вывести суммарные стоимости в консоль. Вывести общую выручку логистической кампании.
    */
public class Test21 {

  public static void main(String[] args) {
    List<Car> carList = new ArrayList<>();

    List<Car> listTurk = carList.stream()
        .filter(car -> "White".equals(car.getColor()) || "Jaguar".equals(car.getCarModel()))
        .toList();

    carList.removeAll(listTurk);

    List<Car> listSec = carList.stream()
        .filter(car -> car.getMass() <= 1500 && ("BMW".equals(car.getCarMake()) || "Lexus".equals(
            car.getCarMake())
            || "Toyota".equals(car.getCarMake()) || "Chrysler".equals(car.getCarMake())))
        .toList();

    int sum = Stream.concat(listTurk.stream(), listSec.stream())
        .mapToInt(Car::getMass)
        .sum();

  }

}

@Data
class Car {

  private int id;
  private String vin;
  private String carMake;
  private String carModel;
  private int releaseYear;
  private String color;
  private int mass; // kilograms
  private int price; // $

  public Car() {
  }
}