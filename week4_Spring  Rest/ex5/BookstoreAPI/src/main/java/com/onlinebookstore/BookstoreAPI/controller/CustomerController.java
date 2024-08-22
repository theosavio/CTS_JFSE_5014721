package com.onlinebookstore.BookstoreAPI.controller;

import com.onlinebookstore.BookstoreAPI.entity.Customer;
import com.onlinebookstore.BookstoreAPI.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @PostMapping
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        Customer savedCustomer = customerRepository.save(customer);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCustomer);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Long id) {
        Optional<Customer> customer = customerRepository.findById(id);
        return customer.map(ResponseEntity::ok)
                       .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
    
    @PostMapping("/register")
    public ResponseEntity<Customer> registerCustomer(
            @RequestParam("name") String name,
            @RequestParam("email") String email,
            @RequestParam("password") String password) {

        
        Customer customer = new Customer();
        customer.setName(name);
        customer.setEmail(email);
        customer.setPassword(password);

       
        Customer savedCustomer = customerRepository.save(customer);

        return ResponseEntity.status(HttpStatus.CREATED).body(savedCustomer);
    }

    
    

    
}
