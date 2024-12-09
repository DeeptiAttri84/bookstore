package com.store.bookstore.Model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;

@Entity
@Table
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public String username;
    public String classname;
    
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.LAZY)
    @JsonManagedReference
public List<BorrowRecord> borrowRecords;

public List<BorrowRecord> getBorrowRecords() {
        return borrowRecords;
    }



    public void setBorrowRecords(List<BorrowRecord> borrowRecords) {
        this.borrowRecords = borrowRecords;
    }



public User( String username, String classname) {
        
        this.username = username;
        this.classname = classname;
    }



public void setUsername(String username) {
    this.username = username;
}



@Override
public String toString() {
    return "User [username=" + username + ", classname=" + classname + "]";
}



public void setClassname(String classname) {
    this.classname = classname;
}



public String getUsername() {
    return username;
}




public String getClassname() {
    return classname;
}



public User(){
    
}
    // Getters and Setters
}
