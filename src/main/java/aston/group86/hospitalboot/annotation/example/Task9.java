package aston.group86.hospitalboot.annotation.example;

import java.util.Objects;

public class Task9 {

    public static void main(String[] args) {

        Book book1 = new Book("name2", "author2");
        Book book2 = new Book("name2", "author2");

        System.out.println(System.identityHashCode(book1) == System.identityHashCode(book2)); //

        System.out.println(book1.hashCode() == book2.hashCode()); //

        Integer number = 128;
        System.out.println(number.hashCode()); //

        Boolean result1 = 5 > 4;
        Boolean result2 = 10 < 50;
        System.out.println(result1.hashCode() == result2.hashCode()); //

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
