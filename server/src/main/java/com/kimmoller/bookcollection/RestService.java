package com.kimmoller.bookcollection;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
public class RestService {

    @Autowired
    private BookCollection bookCollection;
    @Autowired
    private ObjectMapper mapper;

    @GetMapping("/getBook")
    public Book getBook(@RequestParam(value = "id", defaultValue = "0") int id) {
        return bookCollection.getBookCollection().get(id);
    }

    @GetMapping("/getAll")
    public List<Book> getAll() {
        return bookCollection.getBookCollection();
    }

    @PostMapping(path = "/addBook", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Book> addBookToCollection(@RequestBody String payload) {
        Book book;
        try {
            book = mapper.readValue(payload, Book.class);
            bookCollection.saveOrCreateBook(book);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bookCollection.getBookCollection();
    }

    @DeleteMapping(path = "/deleteBook", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Book> deleteBookFromCollection(@RequestBody String payload) {
        Book book;
        try {
            book = mapper.readValue(payload, Book.class);
            bookCollection.deleteFromCollection(book);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bookCollection.getBookCollection();
    }

    @PutMapping(path = "/updateBook", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Book> updateBook(@RequestBody String payload) {
        Book book;
        try {
            book = mapper.readValue(payload, Book.class);
            bookCollection.saveOrCreateBook(book);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bookCollection.getBookCollection();
    }
}