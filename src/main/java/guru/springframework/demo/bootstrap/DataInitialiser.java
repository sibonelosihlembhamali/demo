package guru.springframework.demo.bootstrap;

import guru.springframework.demo.domain.Book;
import guru.springframework.demo.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitialiser implements CommandLineRunner {

  private final BookRepository bookRepository;

  public DataInitialiser(BookRepository bookRepository) {
    this.bookRepository = bookRepository;
  }

  @Override
  public void run(String... args) throws Exception {
    Book bookDDD = new Book("DDD", "123", "Random");
    Book savedDDD = bookRepository.save(bookDDD);

    Book bookSIA = new Book("Spring in Action", "23455", "Oreilly");
    Book savedSIA = bookRepository.save(bookSIA);

    bookRepository.findAll().forEach(book -> {
      System.out.println("Book Id: " + book.getId());
      System.out.println("Book Title: " + book.getTitle());
    });
  }
}
