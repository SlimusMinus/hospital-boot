package aston.group86.hospitalboot.example;


public class Task7 {

 /*
    Задача: сформировать список имен клиентов, у которых меньше 5 счетов при помощи 1 запроса.

    Вывести имена клиентов и количество счетов

 Структура таблиц:

    Clients:
    *   id (целочисленный, первичный ключ)
    *   name (строка, имя клиента)

    Accounts:
    *   id (целочисленный, первичный ключ)
    *   number (строка, номер счета)
    *   client_id (целочисленный, внешний ключ, ссылающийся на Clients.id)

    SELECT c.name, COUNT(a.number) FROM Clients c
    LEFT JOIN Accounts a ON c.id = a.client_id
    GROUP BY c.name
    HAVING COUNT(a.number) < 5


 */
}