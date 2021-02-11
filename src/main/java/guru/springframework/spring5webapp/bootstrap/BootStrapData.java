package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Publisher paw = new Publisher("Nikhil","3242 Mong St","Santa Clara","CA","85012");
        publisherRepository.save(paw);

        Author eric = new Author("Eric","Evans");
        Book bbb = new Book("Domain Driven Design","123123");
        eric.getBooks().add(bbb);
        bbb.getAuthors().add(eric);

        bbb.setPublisher(paw);
        paw.getPbooks().add(bbb);

        authorRepository.save(eric);
        bookRepository.save(bbb);

        Author rod = new Author("Rod","Johnson");
        Book bbd = new Book("J2EE Development","4252423432423");

        rod.getBooks().add(bbd);
        bbd.getAuthors().add(rod);
        bbd.setPublisher(paw);
        paw.getPbooks().add(bbd);

        authorRepository.save(rod);
        bookRepository.save(bbd);


        System.out.println("Started in BootStrap");
        System.out.println("Number of Books: "+bookRepository.count());
        System.out.println("Number of Books published: "+paw.getPbooks().size());


    }
}
