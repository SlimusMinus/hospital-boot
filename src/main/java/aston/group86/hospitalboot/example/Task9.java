package aston.group86.hospitalboot.example;

import java.util.Objects;

public class Task9 {

    public static void main(String[] args) {

        Book book1 = new Book("name2", "author2");
        Book book2 = new Book("name2", "author2");

        System.out.println(System.identityHashCode(book1) == System.identityHashCode(book2)); //false

        System.out.println(book1.hashCode() == book2.hashCode()); //true

        Integer number = 128;
        System.out.println(number.hashCode()); //128

        Boolean result1 = 5 > 4;
        Boolean result2 = 10 < 50;
        System.out.println(result1.hashCode() == result2.hashCode()); //true

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

        @Override
        public int hashCode() {
            return Objects.hash(name, author);
        }
    }
}
