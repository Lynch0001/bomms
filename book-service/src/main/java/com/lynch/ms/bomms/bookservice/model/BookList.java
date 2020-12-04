package com.lynch.ms.bomms.bookservice.model;

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

