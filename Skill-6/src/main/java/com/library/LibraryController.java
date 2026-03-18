package com.library;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class LibraryController {

    // In-memory list
    List<Book> bookList = new ArrayList<>();

    // 2. /welcome
    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome to Library Management System";
    }

    // 3. /count
    @GetMapping("/count")
    public int count() {
        return 100;
    }

    // 4. /price
    @GetMapping("/price")
    public double price() {
        return 499.99;
    }

    // 5. /books
    @GetMapping("/books")
    public List<String> getBooks() {
        return Arrays.asList("Java", "Spring", "Python");
    }

    // 6. /books/{id}
    @GetMapping("/books/{id}")
    public String getBookById(@PathVariable int id) {
        return "Book details for ID: " + id;
    }

    // 7. /search?title=
    @GetMapping("/search")
    public String searchBook(@RequestParam String title) {
        return "Searching for book: " + title;
    }

    // 8. /author/{name}
    @GetMapping("/author/{name}")
    public String getAuthor(@PathVariable String name) {
        return "Books written by: " + name;
    }

    // 9. /addbook (POST)
    @PostMapping("/addbook")
    public String addBook(@RequestBody Book book) {
        bookList.add(book);
        return "Book added successfully";
    }

    // 10. /viewbooks
    @GetMapping("/viewbooks")
    public List<Book> viewBooks() {
        return bookList;
    }
}