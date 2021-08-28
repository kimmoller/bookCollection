package com.kimmoller.bookcollection;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookCollection {
    @Autowired
    BookRepository bookRepository;

    public List<Book> getBookCollection() {
        return bookRepository.findAll();
    }

    public void saveOrCreateBook(Book book) {
        bookRepository.save(book);
    }

    public void deleteFromCollection(Book book) {
        bookRepository.delete(book);
    }

    /**
     * used only for unit tests
     */
    public Optional<Book> getBookFromCollection(Book book) {
        return bookRepository.findById(book.getId());
    }

}
