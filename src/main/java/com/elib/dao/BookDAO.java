package com.elib.dao;

import java.io.Serializable;
import java.util.List;

import com.elib.entity.Book;

/**
 * 
 * @author Pavlo Romankevych
 *
 */
public interface BookDAO extends Serializable, GenericDAO<Book, Integer> {
  
  /**
   * 
   * @param identifier
   * @return book
   */
  Book findByIdentifier(String identifier);
  
  /**
   * 
   * @param input string
   * @return books
   */
  List<Book> findByAll(String str);
  
  /**
   * 
   * @param md5
   * @return book
   */
  Book findByMD5(String md5);
  
  /**
   * 
   * @return all books
   */
  List<Book> getAllBooks();

}
