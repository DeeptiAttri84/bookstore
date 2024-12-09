package com.store.bookstore.Model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table
public class BorrowHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int historyid;
    public String getBookname() {
        return bookname;
    }
    public void setBookname(String bookname) {
        this.bookname = bookname;
    }
    public LocalDate getBorrowDate() {
        return borrowDate;
    }
    public void setBorrowDate(LocalDate borrowDate) {
        this.borrowDate = borrowDate;
    }
    public LocalDate getReturnDate() {
        return returnDate;
    }
    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public Long getUserid() {
        return userid;
    }
    public void setUserid(Long userid) {
        this.userid = userid;
    }
    public BorrowHistory(String bookname, LocalDate borrowDate, LocalDate returnDate, String username, Long userid) {
        this.bookname = bookname;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
        this.username = username;
        this.userid = userid;
    }
    String bookname;
    LocalDate borrowDate;
    LocalDate returnDate;
    String username;
    Long userid;

    public BorrowHistory(){
        
    }
}

