package com.kimmoller.bookcollection;

import java.util.Map;

import com.google.common.collect.Maps;

import org.springframework.stereotype.Component;

@Component
public class BookCollection {
    private Map<Integer, Book> bookCollection;

    public BookCollection() {
        this.bookCollection = Maps.newHashMap();
    }

    public void initCollection() {
        Book lotr = new Book(0, "Lord of the Rings", "J. R. Tolkien", "Epic high fantasy");
        Book harryPotter = new Book(1, "Harry Potter and the Chamber of Secrets", "J. K. Rowlin",
                "Second book in the Harry Potter series");
        Book gameOfThrones = new Book(2, "Game of Thrones", "J. R. R. Martin",
                "First book of the Song of Ice and Fire series");
        this.bookCollection.put(lotr.getId(), lotr);
        this.bookCollection.put(harryPotter.getId(), harryPotter);
        this.bookCollection.put(gameOfThrones.getId(), gameOfThrones);
    }

    public Map<Integer, Book> getBookCollection() {
        return this.bookCollection;
    }

    public void addBookToCollection(Book book) {
        this.bookCollection.put(book.getId(), book);
    }

}
