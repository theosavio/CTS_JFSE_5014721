package com.onlinebookstore.BookstoreAPI.mapper;

import com.onlinebookstore.BookstoreAPI.dto.BookDTO;
import com.onlinebookstore.BookstoreAPI.entity.Book;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BookMapper {
    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

    BookDTO toBookDTO(Book book);
    Book toBook(BookDTO bookDTO);
}
