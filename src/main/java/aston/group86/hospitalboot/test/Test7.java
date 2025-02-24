package aston.group86.hospitalboot.test;

import java.util.Comparator;
import java.util.List;
import lombok.AllArgsConstructor;

public class Test7 {

}

@lombok.Data
@AllArgsConstructor
class Client {
  Integer id;
  String name;
  Integer age;
  List<Phone> phones;

  public static void main(String[] args) {
    Phone phone1 = new Phone(1234567L, Phone.PhoneType.MOBIL);
    Phone phone2 = new Phone(321434L, Phone.PhoneType.STATIONARY);
    Phone phone3 = new Phone(4214L, Phone.PhoneType.MOBIL);
    Client firstClient = new Client(1, "first client", 25, List.of(phone1, phone2, phone3));
    Phone phone4 = new Phone(1234567L, Phone.PhoneType.MOBIL);
    Client secondClient = new Client(2, "second client", 48, List.of(phone4));
    Phone phone5 = new Phone(1234567L, Phone.PhoneType.MOBIL);
    Phone phone6 = new Phone(1234567L, Phone.PhoneType.STATIONARY);
    Client thirdClient = new Client(3, "third client", 48, List.of(phone5, phone6));
    //Найти самого возрастного клиента, которой пользуется стационарным телефоном
    List<Client> list = List.of(firstClient, secondClient, thirdClient);

    /*list.stream()
        .filter(client -> client.phones.stream()
            .anyMatch(phone -> phone.type.equals(Phone.PhoneType.STATIONARY)))
    .max(Comparator.comparing(Client::getAge)).ifPresent(System.out::println);*/


  }
}

@lombok.Data
@AllArgsConstructor
class Phone {
  Long number;
  PhoneType type;

  enum PhoneType {
    STATIONARY,
    MOBIL
  }
}