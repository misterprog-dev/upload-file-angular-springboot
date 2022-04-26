package com.dsoumaila.app.service;

import static java.util.stream.Collectors.toList;

import com.dsoumaila.app.dto.BookDto;
import com.dsoumaila.app.entity.Book;
import com.dsoumaila.app.repository.BookRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;
import java.util.List;

@Service
public class BookService {
    private final BookRepository bookRepository;
    private final FileStorageService fileStorageService;

    public BookService(BookRepository bookRepository, FileStorageService fileStorageService) {
        this.bookRepository = bookRepository;
        this.fileStorageService = fileStorageService;
    }

    @Transactional(readOnly = true)
    public List<BookDto> listBook() {
        List<Book> books = bookRepository.findAll();
        return books.stream().map(BookDto::new).collect(toList());
    }

    /**
     * Create a book
     * @param bookDto book information for saving
     * @param image book image
     */
    @Transactional
    public void createBook(@NotNull BookDto bookDto, @NotNull MultipartFile image) {
        String imageName = StringUtils.cleanPath(image.getOriginalFilename());
        Book book = new Book(
                bookDto.getTitle(),
                bookDto.getDescription(),
                imageName
        );
        bookRepository.save(book);
        fileStorageService.storeLocal(image, imageName);
    }
}
