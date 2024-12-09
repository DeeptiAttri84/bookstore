package com.store.bookstore.Repository;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.store.bookstore.Model.BorrowHistory;

import jakarta.transaction.Transactional;

@Repository
public interface BorrowHistoryRepository extends JpaRepository<BorrowHistory,Integer>{
    @Transactional
    @Modifying
    @Query("UPDATE BorrowHistory b SET b.returnDate= :returnDate WHERE b.userid = :userid AND b.bookname= :bookname")
    int updateBorrowHistoryByuseridAndBookname(@Param("userid") Long userid, 
                                         @Param("bookname") String bookname, 
                                         @Param("returnDate") LocalDate returnDate);  
}
