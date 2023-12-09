package habib.springframework.spring6webapp.services;

import habib.springframework.spring6webapp.domain.Book;

public interface BookService {
	Iterable<Book> findAll();
}
