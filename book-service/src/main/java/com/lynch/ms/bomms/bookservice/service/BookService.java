package com.lynch.ms.bomms.bookservice.service;

import com.lynch.ms.bomms.bookservice.model.Book;
import com.lynch.ms.bomms.bookservice.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

  @Autowired
  private BookRepository bookRepository;

  public void addBook(Book book){
    bookRepository.save(book);
  }

  public void editBook(Book book){
    bookRepository.save(book);
  }

  public void deleteBook(Long id){
    bookRepository.deleteById(id);
  }

  public Optional<Book> getBook(Long id){
    return bookRepository.findById(id);
  }

  public List<Book> getAllBooks(){
    return bookRepository.findAll();
  }
}
