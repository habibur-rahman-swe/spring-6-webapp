package habib.springframework.spring6webapp.services.impl;

import org.springframework.stereotype.Service;

import habib.springframework.spring6webapp.domain.Book;
import habib.springframework.spring6webapp.repositories.BookRepository;
import habib.springframework.spring6webapp.services.BookService;

@Service
public class BookServiceImpl implements BookService{

	private final BookRepository bookRepository;
	
	public BookServiceImpl(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}
	
	@Override
	public Iterable<Book> findAll() {
		return bookRepository.findAll();
	}

}
