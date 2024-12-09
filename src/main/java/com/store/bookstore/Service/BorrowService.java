/*package com.store.bookstore.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.store.bookstore.Model.BorrowRecord;
import com.store.bookstore.Repository.BorrowRecordRepository;

import java.util.List;

@Service
public class BorrowService {
    @Autowired
    private BorrowRecordRepository borrowRecordRepository;

  

    

    public List<BorrowRecord> getAllBorrowRecords() {
        return borrowRecordRepository.findAll();
        
    }

    public BorrowRecord addBorrowRecord(BorrowRecord borrowRecord) {
        return borrowRecordRepository.save(borrowRecord);
    }

    public BorrowRecord updateBorrowRecord(BorrowRecord borrowRecord) {
        // TODO Auto-generated method stub
        return borrowRecordRepository.save(borrowRecord);
    }

    public void deleteBorrowRecord(Long id) {
   
        borrowRecordRepository.deleteById(id);
    }
}
    */
