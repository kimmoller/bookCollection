package com.kimmoller.bookcollection;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BookCollectionTest {

    private BookCollection bookCollection;

    @BeforeEach
    void setup() {
        bookCollection = new BookCollection();
    }

    @Test
    void addToCollection() {
        Book book = new Book("title", "author", "description");
        bookCollection.addBookToCollection(book);
        assertEquals(1, bookCollection.getBookCollection().size());
    }

    @Test
    void deleteFromCollection() {
        Book book = new Book("title", "author", "description");
        bookCollection.deleteFromCollection(book);
        assertEquals(0, bookCollection.getBookCollection().size());
        bookCollection.addBookToCollection(book);
        assertEquals(1, bookCollection.getBookCollection().size());
        bookCollection.deleteFromCollection(book);
        assertEquals(0, bookCollection.getBookCollection().size());
    }

    @Test
    void updateBookInCollection() {
        Book book = new Book(0, "title", "author", "description");
        bookCollection.addBookToCollection(book);
        assertEquals(1, bookCollection.getBookCollection().size());
        assertTrue(bookCollection.getBookFromCollection(book).isPresent());
        assertEquals("title", bookCollection.getBookFromCollection(book).get().getTitle());
        book.setTitle("newTitle");
        bookCollection.updateBook(book);
        assertEquals(1, bookCollection.getBookCollection().size());
        assertTrue(bookCollection.getBookFromCollection(book).isPresent());
        assertEquals("newTitle", bookCollection.getBookFromCollection(book).get().getTitle());
    }
}
