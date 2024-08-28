package com.onlinebookstore.BookstoreAPI.controller;

import com.onlinebookstore.BookstoreAPI.dto.CustomerDTO;

import com.onlinebookstore.BookstoreAPI.entity.Customer;
import com.onlinebookstore.BookstoreAPI.mapper.CustomerMapper;
import com.onlinebookstore.BookstoreAPI.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CustomerDTO createCustomer(@RequestBody CustomerDTO customerDTO) {
        Customer customer = CustomerMapper.INSTANCE.toCustomer(customerDTO);
        Customer savedCustomer = customerRepository.save(customer);
        return CustomerMapper.INSTANCE.toCustomerDTO(savedCustomer);
    }

  
    @GetMapping
    public ResponseEntity<List<CustomerDTO>> getAllCustomers() {
        List<Customer> customers = customerRepository.findAll();
        List<CustomerDTO> customerDTOs = customers.stream()
                .map(CustomerMapper.INSTANCE::toCustomerDTO)
                .toList();
        return ResponseEntity.ok(customerDTOs);
    }


    @GetMapping("/{id}")
    public ResponseEntity<CustomerDTO> getCustomerById(@PathVariable Long id) {
        Optional<Customer> customer = customerRepository.findById(id);
        return customer.map(value -> ResponseEntity.ok(CustomerMapper.INSTANCE.toCustomerDTO(value)))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerDTO> updateCustomer(@PathVariable Long id, @RequestBody CustomerDTO customerDTO) {
        Optional<Customer> existingCustomer = customerRepository.findById(id);
        if (existingCustomer.isPresent()) {
            Customer customer = existingCustomer.get();
            customer.setName(customerDTO.getName());
            customer.setEmail(customerDTO.getEmail());
            customer.setPhoneNumber(customerDTO.getPhoneNumber());
            Customer updatedCustomer = customerRepository.save(customer);
            return ResponseEntity.ok(CustomerMapper.INSTANCE.toCustomerDTO(updatedCustomer));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

  
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {
        Optional<Customer> existingCustomer = customerRepository.findById(id);
        if (existingCustomer.isPresent()) {
            customerRepository.delete(existingCustomer.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
