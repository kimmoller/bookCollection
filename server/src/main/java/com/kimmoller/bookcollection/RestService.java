package com.kimmoller.bookcollection;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestService {

    @Autowired
    private BookCollection bookCollection;

    @GetMapping("/getBook")
    public Book getBook(@RequestParam(value = "id", defaultValue = "0") int id) {
        return bookCollection.getBookCollection().get(id);
    }

    @GetMapping("/getAll")
    public Map<Integer, Book> getAll() {
        return bookCollection.getBookCollection();
    }
}