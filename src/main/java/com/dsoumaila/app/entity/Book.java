package com.dsoumaila.app.entity;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity(name = "book")
@Access(AccessType.FIELD)
public class Book {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true)
    private String title;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String image;

    /**
     * Default constructor
     */
    public Book() {
    }

    /**
     * Constructor with parameters
     *
     * @param title the title of book
     * @param description the description of book
     * @param image the name of book image
     */
    public Book(String title, String description, String image) {
        this.title = title;
        this.description = description;
        this.image = image;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
