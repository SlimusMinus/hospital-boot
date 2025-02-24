package aston.group86.hospitalboot.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Command {
  //Команда за которую будет отвечать функция (например "привет");
  String name();

  //Аргументы команды, использоваться будут для вывода списка команд
  String args();

  //Минимальное количество аргументов, сразу присвоили 0 (логично)
  int minArgs() default 0;

  //Описание, тоже для списка
  String desc();

  //Максимальное число аргументов. В целом не обязательно, но тоже можно использовать
  int maxArgs() default Integer.MAX_VALUE;

  //Показывать ли команду в списке (вовсе необязательная строка, но мало ли, пригодится!)
  boolean showInHelp() default true;

  //Какие команды будут считаться эквивалентными нашей
  //(Например для "привет", это может быть "Здаров", "Прив" и т.д.)
  //Под каждый случай заводить функцию - не рационально
  String[] aliases();
}
