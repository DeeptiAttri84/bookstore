package com.store.bookstore.Model;

import jakarta.persistence.*;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table
public class BorrowRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public Long bookId;
    public LocalDate borrowDate;
    public LocalDate returnDate;
    @ManyToOne
    @JoinColumn(name = "userid")
    @JsonBackReference
    private User user;
    

    public User getUser() {
        return user;
    }


    public void setUser(User user) {
        this.user = user;
    }


    public BorrowRecord(Long bookId, LocalDate borrowDate, LocalDate returnDate) {
        this.bookId = bookId;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
    }


    @Override
    public String toString() {
        return "BorrowRecord [bookId=" + bookId + ", borrowDate=" + borrowDate + ", returnDate=" + returnDate + "]";
    }


    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }


    public void setBorrowDate(LocalDate borrowDate) {
        this.borrowDate = borrowDate;
    }


    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }


    public Long getBookId() {
        return bookId;
    }


    public LocalDate getBorrowDate() {
        return borrowDate;
    }


    public LocalDate getReturnDate() {
        return returnDate;
    }


    /*@ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    public User user;

    @ManyToOne
    @JoinColumn(name = "book_id", nullable = false)
    public Book book;

    public void setId(Long id) {
        this.id = id;
    }
    @Override
    public String toString() {
        return "BorrowRecord [id=" + id + ", user=" + user + ", book=" + book + ", borrowDate=" + borrowDate
                + ", returnDate=" + returnDate + "]";
    }
    public void setUser(User user) {
        this.user = user;
    }
    public void setBook(Book book) {
        this.book = book;
    }
    public void setBorrowDate(LocalDate borrowDate) {
        this.borrowDate = borrowDate;
    }
    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }
    public LocalDate borrowDate;
    public Long getId() {
        return id;
    }
    public User getUser() {
        return user;
    }
    public Book getBook() {
        return book;
    }
    public LocalDate getBorrowDate() {
        return borrowDate;
    }
    public LocalDate getReturnDate() {
        return returnDate;
    }
    public LocalDate returnDate; // Null if not returned
    public BorrowRecord(Long id, User user, Book book, LocalDate borrowDate, LocalDate returnDate) {
        this.id = id;
        this.user = user;
        this.book = book;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
    }*/
    public  BorrowRecord(){
        
    }
    
}
