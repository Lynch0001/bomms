package com.lynch.ms.bomms.bookservice.repository;

import com.lynch.ms.bomms.bookservice.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository  extends JpaRepository<Book, Long> {
}
