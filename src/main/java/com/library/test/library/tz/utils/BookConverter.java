package com.library.test.library.tz.utils;

import com.library.test.library.tz.DTO.BookDTO;
import com.library.test.library.tz.models.Book;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookConverter {

    private ModelMapper modelMapper;

    public Book convertToBook (BookDTO bookDTO){
        return  modelMapper.map(bookDTO,Book.class);
    }

    public  BookDTO convertToBookDTO (Book book){
        return  modelMapper.map(book,BookDTO.class);
    }



}
