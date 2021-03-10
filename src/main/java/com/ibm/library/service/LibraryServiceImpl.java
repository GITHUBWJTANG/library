package com.ibm.library.service;

import java.util.Collection;

import com.ibm.library.model.BookData;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.library.endpoint.BookInventoryEndpoint;

@Service
public class LibraryServiceImpl implements LibraryService {
	private final Logger logger = LoggerFactory.getLogger(LibraryServiceImpl.class);

	@Autowired
	private BookInventoryEndpoint bookInventoryEndpoint;

	public LibraryServiceImpl() {
	}

	@Override
	public Collection<BookData> getBooks() {
		
		logger.debug("Entered LibraryServiceImpl.getBooks()");
		
		Collection<BookData> books = this.bookInventoryEndpoint.getBooks();
		
		logger.info("Number of books retrieved: {}", books.size());
	    logger.debug("Leaving LibraryServiceImpl.getBooks()");

		return books;
	}

	@Override
	public BookData getBookbyISBN(String isbn) {
		logger.debug("Entered LibraryServiceImpl.getBookByISBN()");
		
		//BookData book = this.bookInventoryEndpoint.getBook(isbn);
		BookData book = new BookData("FICTION", isbn, "Dummy Book", "Dummy Author"); //temp soluation
		
		logger.info("Book retrieved: {}", book);
	    logger.debug("Leaving LibraryServiceImpl.getBookByISBN()");

		return book;
	}
	
	
}
