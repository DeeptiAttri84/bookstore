package com.store.bookstore.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Author {
    public void setId(Long id) {
        this.id = id;
    }
    @Override
    public String toString() {
        return "Author [id=" + id + ", name=" + name + "]";
    }
    public void setName(String name) {
        this.name = name;
    }
    @Id
    public Long id;
    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String name;
    public Author(Long id, String name) {
        this.id = id;
        this.name = name;
    }
public Author(){
    
}
    // Getters, Setters, and Constructors
}
