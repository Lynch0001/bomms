package com.lynch.ms.bomms.bookorderservice.service;

import com.lynch.ms.bomms.bookorderservice.model.BookItem;
import com.lynch.ms.bomms.bookorderservice.repository.BookItemRepository;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.List;
import java.util.Optional;

@Service
public class BookItemService {

  private BookItemRepository bookItemRepository;

  BookItemService(BookItemRepository bookItemRepository){
    this.bookItemRepository = bookItemRepository;
  }

  public void addBookItem(BookItem bookItem){
    bookItemRepository.save(bookItem);
  }

  public void updateBookItem(BookItem bookItem){
    bookItemRepository.save(bookItem);
  }

  public void deleteBookItem(Long id){
    bookItemRepository.deleteById(id);
  }

  public Optional<BookItem> getBookItem(Long id){
    return bookItemRepository.findById(id);
  }

  public List<BookItem> getAllBookItems(){
    return bookItemRepository.findAll();
  }

}
