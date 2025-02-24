package aston.group86.hospitalboot.annotation;

import java.util.Arrays;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class MessageListener {

  public void onMessageReceived(MessageReceivedEvent event) {

    String message = String.valueOf(event.getMessage()).toLowerCase();
    if (message.startsWith("бот")) {
      try {
        //получим массив {"Бот", "(команду)", "аргумент1", "аргумент2",... "аргументN"};
        String[] args = message.split(" ");
        //Для удобства уберем "бот" и отделим команду от аргументов
        String command = args[1];
        String[] nArgs = Arrays.copyOfRange(args, 2, args.length);
        //Получили command = "(команда)"; nArgs = {"аргумент1", "аргумент2",..."аргументN"};
        //Данный массив может быть пустым
      } catch (ArrayIndexOutOfBoundsException e) {
        //Вывод списка команд или какого-либо сообщения
        //В случае если просто написать "Бот"
      }
    }
  }
}
