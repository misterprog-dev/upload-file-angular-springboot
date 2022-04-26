package com.dsoumaila.app.dto;


import com.dsoumaila.app.entity.Book;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class BookDto {
    private Integer id;

    @NotNull
    @NotBlank
    private String title;

    @NotNull
    @NotBlank
    private String description;

    @NotNull
    @NotBlank
    private String image;

    public BookDto(Book book) {
        this.id = book.getId();
        this.title = book.getTitle();
        this.description = book.getDescription();
        this.image = book.getImage();
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getImage() {
        return image;
    }
}
