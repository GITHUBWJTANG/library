package com.ibm.library.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

import com.ibm.library.endpoint.BookInventoryEndpoint;
import com.ibm.library.model.BookData;


class LibraryServiceImplTest {
	
	@Mock 
    private BookInventoryEndpoint bookInventoryEndpoint;

    @InjectMocks  
    private LibraryServiceImpl libraryService;
    
    @BeforeEach
    public void init() {
       MockitoAnnotations.initMocks(this);
    }

    /*@Test
	void testGetBooks() {
		fail("Not yet implemented");
	}

	@Test
	void testGetBook() {
		fail("Not yet implemented");
	}*/
    
    @DisplayName("Test libraryservice getBook with valid isbn")
    @Test
    void testGetBookExistingIsbn() {
        // Given - set the parameter values and mock the methods for this test case
        String isbn = "1234";
        BookData bookDataMocked = new BookData("FICTION", isbn, "SomeBook", "SomeAuthor");
        when(bookInventoryEndpoint.getBook(isbn)).thenReturn(bookDataMocked);
     
        // When - call the method being tested and save the response
        BookData bookData = libraryService.getBookbyISBN(isbn);
        
        // Then - check that the results are valid (and that the expected mocked methods were called)
        assertNotNull(bookData, "bookData should not be null");
        assertEquals(bookData, bookDataMocked, "bookData should be the same as: " + bookDataMocked);
     
        verify(bookInventoryEndpoint).getBook(isbn);

   }


}
