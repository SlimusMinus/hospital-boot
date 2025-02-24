package aston.group86.hospitalboot.test;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

public class App3 {

}

/*
@RestController
@RequiredArgsConstructor
public class AuthorController {

  private final AuthorSearchService service;

  @GetMapping("/authors")
  public List<AuthorDto> readAllAuthors(@RequestParam String query) {
    return service.findAllAuthors(query);
  }
}

@Service
@Slf4j
@RequiredArgsConstructor
public class AuthorSearchService {

  private final AuthorRepository authorRepository;
  private final StatisticRepository statisticRepository;
  private final MapperAuthor mapper;
  private final AlertRestClient alert;

  @Transactional
  public List<Author> getAuthors(String name) {

    List<Author> authors = authorRepository.findByNameContainingIgnoringCase(name);

    Statistics statistic = statisticRepository.findByName(name).orElseGet(()->new Statistics(query));
    statistic.setNumbers(statistic.getNumbers + 1);
    statisticRepository.save(statistic);

    if (statistic.getNumbers() > 1000 && authors.sise() > 1000) {
      log.info("too popular with too many authors");
      arc.send(query, s.getNumbers(), authors.size());
    }
    return authors;
  }

  public List<AuthorDto> findAllAuthors(String query){
    return getAuthors(query)
        .stream()
        .map(mapper::mapToAuthorDto) // .map(authorMapper::toDto)
        .collect(Collectors.toList());
  }

}

public interface AuthorRepository extends CrudRepository<Author, Long> {
  List<Author> findByNameContainingIgnoreCase(String name);
}

@Entity
@Data
@Buider
public class Author {
  @Id
  @GeneratedValue
  private Long id;
  private String name;

  @EqualsAndHashCode.Exclude
  @ToString.Exclude
  @OneToMany(mappedBy = "author")
  private List<Book> books;

}

@Entity
@Data
public class Statistics {
  @Id
  private String query;
  private Integer numbers;

  public Statistics(String query) {
    this.query = query;
  }
}*/