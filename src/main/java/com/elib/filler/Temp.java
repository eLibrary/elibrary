package com.elib.filler;

import org.springframework.beans.factory.annotation.Autowired;

import com.elib.dao.BookDAO;
import com.elib.entity.Book;

public class Temp {
  
  @Autowired
  public BookDAO bookDAO;
  
  public void store(Book book){
    bookDAO.save(book);
  }

}
