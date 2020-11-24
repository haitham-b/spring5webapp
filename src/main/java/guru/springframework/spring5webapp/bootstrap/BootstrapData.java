package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repository.AuthorRepository;
import guru.springframework.spring5webapp.repository.BookRepository;
import guru.springframework.spring5webapp.repository.PublisherRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Slf4j
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    @Override
    public void run(String... args) throws Exception {

        Publisher publisher = new Publisher();
        publisher.setName("SFG Publishing").setAddressLine1("hesiterbacher Str. 119").setCity("Königswinter").setState("NRW").setZip("53639");

        Author eric = new Author();
        eric.setFirstName("Eric").setLastName("Evans");
        Book ddd = new Book();
        ddd.setTitle("Domain Driven Design").setIsbn("123123");
        publisher.getBooks().add(ddd);

        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);
        authorRepository.save(eric);
        bookRepository.save(ddd);


        Author rod = new Author();
        rod.setFirstName("Rod").setLastName("Evans");
        Book noEJB = new Book();
        noEJB.setTitle("J2EE Development without EJB").setIsbn("39485723048");

        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);
        publisher.getBooks().add(noEJB);


        authorRepository.save(eric);
        bookRepository.save(ddd);
        authorRepository.save(rod);
        bookRepository.save(noEJB);

        publisherRepository.save(publisher);

        log.info(rod.toString());
        log.info(noEJB.toString());

        log.info("Starting boot");
        log.info("Books count:" + bookRepository.count());
        log.info("Books count for publisher:" + publisher.getBooks().size());

    }
}
