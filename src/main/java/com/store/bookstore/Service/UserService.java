package com.store.bookstore.Service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.store.bookstore.Model.Book;
import com.store.bookstore.Model.BorrowHistory;
import com.store.bookstore.Model.BorrowRecord;
import com.store.bookstore.Model.User;
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
    public User adduser(User user) {
       return userRepository.save(user);
    }
    public List<User> getAlluser() {
        return userRepository.findAll();
    }
    public void deleteUser(String id) {
        userRepository.deleteById(Long.valueOf(id));
    }
}
