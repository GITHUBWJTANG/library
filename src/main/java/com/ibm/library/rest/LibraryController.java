package com.ibm.library.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.library.service.LibraryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;
import com.ibm.library.model.BookData;

import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping(value = "/library")
public class LibraryController {
	@Autowired
	private LibraryService libraryService;
	private final Logger logger = LoggerFactory.getLogger(LibraryController.class);

	public LibraryController() {
	}

	@RequestMapping(value = "/books")
	public ResponseEntity<?> getBooks() {

		logger.info("Entered LibraryController.getBooks()");
		Collection<BookData> books = this.libraryService.getBooks();
		ResponseEntity<Collection<BookData>> responseEntity = new ResponseEntity<Collection<BookData>>(books,
				HttpStatus.OK);
		logger.info("Leaving LibraryController.getBooks()");

		return responseEntity;
	}
}
