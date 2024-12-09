package com.store.bookstore.Controller;

import com.store.bookstore.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.store.bookstore.Model.Book;
import com.store.bookstore.Service.BookService;
import com.store.bookstore.Service.UserService;

//import com.store.bookstore.Model.BorrowRecord;


import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private BookService bookService;
    @Autowired
    private UserService userService;
    @GetMapping("/getBooks")
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }
    @GetMapping("/getbook/{id}")
    public Book getBook(@PathVariable("id") String id) {
        return bookService.getByBookid(id);
    }
      @PutMapping("/borrowbook/{userid}/{bookid}")
      public String borrowbook(@PathVariable("userid") String userid,@PathVariable("bookid") String bookid) {
          User user = userService.bookBorrowByUser(userid, bookid);
          if(user!=null){
            return "borrow success";
          }else{
            return "borrow failed";
          }
        
        
      }
      @PostMapping("/adduser")
      public List<User> addUser(@RequestBody List<User> user){
         return userService.adduser(user);

      }
      @GetMapping("/getAllUser")
      public List<User> getAlluser() {
        return userService.getAlluser();
      }

      @DeleteMapping("/deleteUser/{id}")
      public void  deleteUser(@PathVariable("id") String id ){
         userService.deleteUser(id);

      }

      @PutMapping("/bookReturn/{userid}/{bookid}")
      public User bookReturn(@PathVariable("userid") String userid,@PathVariable("bookid") String bookid) {
         return userService.bookReturn(userid,bookid);
      }
      
    
    
    

    // Get all borrow records
    /*
     * @GetMapping("/borrowRecords")
     * public List<BorrowRecord> getAllBorrowRecords() {
     * return borrowService.getAllBorrowRecords();
     * }
     * 
     * // Add a new borrow record
     * 
     * @PostMapping("/borrowRecords")
     * public BorrowRecord addBorrowRecord(@RequestBody BorrowRecord borrowRecord) {
     * return borrowService.addBorrowRecord(borrowRecord);
     * }
     * 
     * // Update an existing borrow record
     * 
     * @PutMapping("/borrowRecords/{id}")
     * public BorrowRecord updateBorrowRecord(@PathVariable Long id, @RequestBody
     * BorrowRecord borrowRecord) {
     * // Assuming you might want to ensure that the ID is the same as the record
     * being updated
     * borrowRecord.setId(id);
     * return borrowService.updateBorrowRecord(borrowRecord);
     * }
     * 
     * // Delete a borrow record
     * 
     * @DeleteMapping("/borrowRecords/{id}")
     * public void deleteBorrowRecord(@PathVariable Long id) {
     * borrowService.deleteBorrowRecord(id);
     * }
     */
}
