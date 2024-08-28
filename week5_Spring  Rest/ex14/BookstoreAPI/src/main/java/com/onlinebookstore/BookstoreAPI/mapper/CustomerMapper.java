package com.onlinebookstore.BookstoreAPI.mapper;

import com.onlinebookstore.BookstoreAPI.dto.CustomerDTO;
import com.onlinebookstore.BookstoreAPI.entity.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CustomerMapper {
    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

   
    CustomerDTO toCustomerDTO(Customer customer);

   
    Customer toCustomer(CustomerDTO customerDTO);
}
