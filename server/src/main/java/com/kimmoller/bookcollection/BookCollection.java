package com.kimmoller.bookcollection;

import java.util.List;

import com.google.common.collect.Lists;

import org.springframework.stereotype.Component;

@Component
public class BookCollection {
    private List<Book> bookCollection;

    public BookCollection() {
        this.bookCollection = Lists.newArrayList();
    }

    public void initCollection() {
        Book lotr = new Book(0, "Lord of the Rings", "J. R. Tolkien", "Epic high fantasy");
        Book harryPotter = new Book(1, "Harry Potter and the Chamber of Secrets", "J. K. Rowlin",
                "Second book in the Harry Potter series");
        Book gameOfThrones = new Book(2, "Game of Thrones", "J. R. R. Martin",
                "First book of the Song of Ice and Fire series");
        this.bookCollection.add(lotr);
        this.bookCollection.add(harryPotter);
        this.bookCollection.add(gameOfThrones);
    }

    public List<Book> getBookCollection() {
        return this.bookCollection;
    }

    public void addBookToCollection(Book book) {
        int newId = this.bookCollection.get(-1).getId() + 1;
        book.setId(newId);
        this.bookCollection.add(book);
    }
}
