package com.store.bookstore.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.store.bookstore.Model.BorrowHistory;

@Repository
public interface BorrowHistoryRepository extends JpaRepository<BorrowHistory,Integer>{
    
}
