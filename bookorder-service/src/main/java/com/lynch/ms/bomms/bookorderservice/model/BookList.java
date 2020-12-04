package com.lynch.ms.bomms.bookorderservice.model;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;

public class BookList {
  private List<Book> booklist;

  public BookList(){
    booklist = new ArrayList<>();
  }

  public List<Book> getBooklist() {
    return booklist;
  }

  public void setBooklist(List<Book> booklist) {
    this.booklist = booklist;
  }
}
