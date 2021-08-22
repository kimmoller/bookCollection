package com.kimmoller.bookcollection;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BookTest {
    @Test
    void createBook() {
        Book book = new Book("title", "author", "description");
        assertEquals("title", book.getTitle());
        assertEquals("author", book.getAuthor());
        assertEquals("description", book.getDescription());
    }

    @Test
    void createBookWithId() {
        Book book = new Book(0, "title", "author", "description");
        assertEquals(0, book.getId());
        assertEquals("title", book.getTitle());
        assertEquals("author", book.getAuthor());
        assertEquals("description", book.getDescription());
    }

}
