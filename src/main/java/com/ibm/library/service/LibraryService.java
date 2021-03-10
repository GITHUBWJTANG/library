package com.ibm.library.service;

import java.util.Collection;
//import com.ibm.library.model.Book;
import com.ibm.library.model.BookData;

public interface LibraryService {

	public Collection<BookData> getBooks();
	
	BookData getBookbyISBN(String isbn);
}
