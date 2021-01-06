package com.sau.init.bootstrap;

import com.sau.init.domain.Author;
import com.sau.init.domain.Book;
import com.sau.init.domain.Publisher;
import com.sau.init.repositories.AuthorRepository;
import com.sau.init.repositories.BookRepository;
import com.sau.init.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

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
        Author author1 = new Author("Evans", "Eric");
        Book book1 = new Book("Data Structures Explained", "123221");
        List books = new ArrayList();
        books.add(book1);
        author1.setBooks(books);
        authorRepository.save(author1);
        bookRepository.save(book1);

        Author author2 = new Author("Mila", "Kunis");
        Book book2 = new Book("Friends with benefits", "434344");
        List booksd = new ArrayList();
        booksd.add(book2);
        author2.setBooks(books);
        authorRepository.save(author2);
        bookRepository.save(book2);

        Publisher publisher1 = new Publisher("Maven Prints");
        List<Book> publisherBooks = new ArrayList();
        publisherBooks.add(book1);
        publisherBooks.add(book2);
        publisher1.setBooks(publisherBooks);
        publisherRepository.save(publisher1);

        System.out.println("Started loading data");

        System.out.println("Books count :: " + bookRepository.count());
        System.out.println("Authors count :: " + authorRepository.count());
        System.out.println("Publishers count :: " + publisherRepository.count());

    }
}
