package aston.group86.hospitalboot.test;

import java.util.List;
import java.util.stream.Stream;
import lombok.AllArgsConstructor;

public class Test6 {

}

@lombok.Data
@AllArgsConstructor
class Author {
  private String name;

  private List<Book> books;

  public static void main(String[] args) {
    Book jamesBond = new Book("James Bond", 2001);
    Book jamesBond2 = new Book("James Bond2", 2003);
    Book jamesBond3 = new Book("James Bond3", 2008);
    Book jamesBond4 = new Book("James Bond4", 2011);
    Author author1 = new Author("Ian Fleming", List.of(jamesBond, jamesBond2, jamesBond3, jamesBond4));

    Book garryPotter = new Book("Garry Potter", 2001);
    Book garryPotter2 = new Book("Garry Potter2", 2003);
    Book garryPotter3 = new Book("Garry Potter3", 2008);
    Book garryPotter4 = new Book("Garry Potter4", 2011);
    Author author2 = new Author("Joanne Rowling", List.of(garryPotter, garryPotter2, garryPotter3, garryPotter4));

    Stream.of(author1, author2)
        .flatMap(author -> author.books.stream())
        .filter(book -> book.getYear() > 2005)
    //    .map(Book::getName)
        .forEach(System.out::println);



    // вывести список названий книг авторов написанных после 2005
  }
}

@lombok.Data
@AllArgsConstructor
class Book {
  private String name;
  private Integer year;
}