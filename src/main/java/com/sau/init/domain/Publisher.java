package com.sau.init.domain;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Publisher {

    private String name;

    @OneToMany
    @JoinColumn(name="publisher_id")
    private List<Book> books;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Publisher(String name) {
        this.name = name;
    }

    public Publisher() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Publisher{" +
                "name='" + name + '\'' +
                ", books=" + books +
                ", id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Publisher publisher = (Publisher) o;
        return Objects.equals(id, publisher.id);
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
