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
}
