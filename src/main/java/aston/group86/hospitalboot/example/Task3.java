package aston.group86.hospitalboot.example;


import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.Data;

public class Task3 {

    public static void main(String[] args) {

        List<List<Book>> listOflists = List.of(
                List.of(new Book("Книга1", "Пушкин", 200),
                        new Book("Книга2", "Лермонтов", 50),
                        new Book("Книга3", "Пушкин", 100),
                        new Book("Книга4", "Чехов", 70)),
                List.of(new Book("Книга5", "Крылов", 100),
                        new Book("Книга6", "Толстой", 250))
        );

        /*
    Сгруппировать книги по автору, а внутри группы отсортировать по количеству страниц (по возрастанию)
     (Map<String, List<Book>> map), либо Map<String, List<String>> map - автор и названия его книг
      */

        Map<String, List<Book>> collect = listOflists.stream()
            .flatMap(books -> books.stream())
            .sorted(Comparator.comparing(Book::getPageSize))
            .collect(Collectors.groupingBy(Book::getAuthor));

        System.out.println(collect);

    }

    @Data
    @AllArgsConstructor
    private static class Book {
        private String name;
        private String author;
        private int pageSize;
    }
}
