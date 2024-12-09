package com.store.bookstore.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.store.bookstore.Model.Book;
import com.store.bookstore.Model.BorrowHistory;
import com.store.bookstore.Model.BorrowRecord;
import com.store.bookstore.Model.User;
import com.store.bookstore.Repository.BookRepository;
import com.store.bookstore.Repository.BorrowHistoryRepository;
import com.store.bookstore.Repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BookService bookService;
    @Autowired
    private BorrowHistoryRepository borrowHistoryRepository;
    @Autowired
    private BookRepository bookRepository;

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
    public User bookBorrowByUser(String userid,String bookid){
       User user = userRepository.findById(Long.valueOf(userid)).get();
       if(user==null){
        return null;
       }
       Book book = bookService.borrowbook(bookid);
       if(book!=null){
        BorrowRecord record = new BorrowRecord();
        record.setBorrowDate(LocalDate.now());
        record.setReturnDate(LocalDate.now().plusDays(14));
        record.setUser(user);
        record.setBookId(book.getId());
        user.getBorrowRecords().add(record);
        borrowHistoryRepository.save(new BorrowHistory(book.getTitle(),LocalDate.now(),null,user.getUsername(),user.getId()));

        return userRepository.save(user);
       }
       return null;

    }
    public List<User> adduser(List<User> user) {
       return userRepository.saveAll(user);
    }
    public List<User> getAlluser() {
        return userRepository.findAll();
    }
    public void deleteUser(String id) {
        userRepository.deleteById(Long.valueOf(id));
    }
    /*public User bookReturn(String userid, String bookid) {
      Optional<User> user = userRepository.findById(Long.valueOf(userid));
      if(!user.isPresent()){
        return null;
      }else{
        User user1=user.get();
       Book book = bookRepository.findById(Long.valueOf(bookid)).get();
      int availablecopies = book.getAvailableCopies()+1;
        book.setAvailableCopies(availablecopies);
        bookRepository.save(book);
       List<BorrowRecord> borrowrecords = user1.getBorrowRecords();
       List<BorrowRecord> updatedboBorrowRecords = new ArrayList<BorrowRecord>();
       for(BorrowRecord borrowrecord : borrowrecords){
        if(borrowrecord.getBookId()!=Long.valueOf(bookid)){
          updatedboBorrowRecords.add(borrowrecord);
        }
       }
       user1.getBorrowRecords().clear();
       user1.setBorrowRecords(updatedboBorrowRecords);
       userRepository.save(user1);
       return user1;
      }
      
    }*/
    public User bookReturn(String userId, String bookId) {
      Optional<User> userOptional = userRepository.findById(Long.valueOf(userId));
      if (!userOptional.isPresent()) {
          return null; // User not found
      }
  
      User user = userOptional.get();
      Optional<Book> bookOptional = bookRepository.findById(Long.valueOf(bookId));
      if (!bookOptional.isPresent()) {
          return null; // Book not found
      }
  
      Book book = bookOptional.get();
      book.setAvailableCopies(book.getAvailableCopies() + 1); // Increment available copies
      bookRepository.save(book);
  
      // Directly modify the borrowRecords collection
      user.getBorrowRecords().removeIf(borrowRecord -> 
          borrowRecord.getBookId().equals(Long.valueOf(bookId))
      );
  
      // Save the updated user entity
      userRepository.save(user);
      borrowHistoryRepository.updateBorrowHistoryByuseridAndBookname(Long.valueOf(userId), book.getTitle(), LocalDate.now());
      return user;
  }
  
}
