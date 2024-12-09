package com.store.bookstore.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.store.bookstore.Model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
