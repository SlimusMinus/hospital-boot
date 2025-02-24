package aston.group86.hospitalboot.annotation.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Task8 {
    public static void main(String[] args) {

        Book book1 = new Book("name1", "author1");
        Book book2 = new Book("name2", "author2");
        Book book3 = new Book("name2", "author2");
        Book book4 = new Book("name3", "author3");

        Map<Book, Integer> books = new HashMap<>();
        books.put(book1, 100);
        books.put(book2, 200);
        books.put(book3, 300);
        books.put(book4, 400);

        System.out.println(books.size()); // ?
        System.out.println(books.get(new Book("name2", "author2"))); // ?
    }


    private static class Book {

        private final String name;
        private final String author;

        public Book(String name, String author) {
            this.name = name;
            this.author = author;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Book book = (Book) o;
            return Objects.equals(name, book.name) && Objects.equals(author, book.author);
        }
    }
}