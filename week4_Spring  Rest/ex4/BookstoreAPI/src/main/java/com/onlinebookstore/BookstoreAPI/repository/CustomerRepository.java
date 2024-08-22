package com.onlinebookstore.BookstoreAPI.repository;

import com.onlinebookstore.BookstoreAPI.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
