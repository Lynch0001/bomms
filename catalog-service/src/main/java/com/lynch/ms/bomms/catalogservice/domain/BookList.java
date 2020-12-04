package com.lynch.ms.bomms.catalogservice.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class BookList implements Serializable {
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
