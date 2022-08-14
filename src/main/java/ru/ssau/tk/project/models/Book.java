package ru.ssau.tk.project.models;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

public class Book {
    private int id;

    private int personId;
    @NotEmpty(message = "Название книги должно иметь какое-либо значение")
    private String name;
    @NotEmpty(message = "У книги должен быть указан автор")
    private String author;
    @Min(value = 0, message = "Год выпуска книги должен быть не меньше 0")
    private int date;

    public Book(int id, int personId, String name, String author, int date) {
        this.id = id;
        this.personId = personId;
        this.name = name;
        this.author = author;
        this.date = date;
    }

    public Book() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }
}
