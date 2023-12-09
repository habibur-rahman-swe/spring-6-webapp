package habib.springframework.spring6webapp.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import habib.springframework.spring6webapp.domain.Author;
import habib.springframework.spring6webapp.domain.Book;
import habib.springframework.spring6webapp.domain.Publisher;
import habib.springframework.spring6webapp.repositories.AuthorRepository;
import habib.springframework.spring6webapp.repositories.BookRepository;
import habib.springframework.spring6webapp.repositories.PublisherRepository;

@Component
public class BootstrapData implements CommandLineRunner {

	private final AuthorRepository authorRepository;
	private final BookRepository bookRepository;
	private final PublisherRepository publisherRepository;
	
	public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository ) {
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.publisherRepository = publisherRepository;
	}
	
	@Override
	public void run(String... args) throws Exception {
		
		Author author1 = new Author();
		author1.setFirstName("A1");
		author1.setLastName("B1");
		
		Book book1 = new Book();
		book1.setTitle("T1");
		book1.setIsbn("11");
		
		Author authorSaved1 = authorRepository.save(author1);
		Book bookSaved1 = bookRepository.save(book1);
		
		
		
		Author author2 = new Author();
		author2.setFirstName("A2");
		author1.setLastName("B2");
		
		Book book2 = new Book();
		book1.setTitle("T2");
		book1.setIsbn("12");
		
		Author authorSaved2 = authorRepository.save(author2);
		Book bookSaved2 = bookRepository.save(book2);
		
		
		Publisher publisher = new Publisher();
		publisher.setPublisherName("My Publisher");
		publisher.setAddress("123 Main");
		Publisher savedPublisher = publisherRepository.save(publisher);
		
		book1.setPublisher(savedPublisher);
		book2.setPublisher(savedPublisher);
		
		bookRepository.save(book1);
		bookRepository.save(book2);
		
		authorSaved1.getBooks().add(bookSaved1);
		authorSaved2.getBooks().add(bookSaved2);
		
		
		authorRepository.save(authorSaved1);
		authorRepository.save(authorSaved2);
		
		System.out.println("In BootStrap");
		System.out.println("Author Count: " + authorRepository.count());
		System.out.println("Book Count: " + bookRepository.count());
		System.out.println("Publisher Count: " + publisherRepository.count());
		System.out.println(authorSaved1);
		System.out.println(bookSaved1);
		
	}

	
}
