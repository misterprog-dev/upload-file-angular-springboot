package com.dsoumaila.app.controller;

import com.dsoumaila.app.dto.BookDto;
import com.dsoumaila.app.service.BookService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;

import java.util.List;

import static org.apache.tomcat.util.http.fileupload.FileUploadBase.MULTIPART_FORM_DATA;

@RestController
@RequestMapping("/api/v1/books")
@CrossOrigin("*")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    /**
     * Create book
     *
     * @param book the book information
     * @param file the book image
     */
    @PostMapping(consumes = MULTIPART_FORM_DATA)
    public void createBooks(@RequestPart @Valid BookDto book, @RequestPart MultipartFile file) {
        bookService.createBook(book, file);
    }

    /**
     * List all books
     *
     * @return the list of books saved
     */
    @GetMapping()
    public List<BookDto> listBooks() {
        return bookService.listBook();
    }
}
