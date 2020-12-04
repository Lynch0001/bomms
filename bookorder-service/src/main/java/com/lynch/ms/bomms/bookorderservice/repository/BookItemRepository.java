package com.lynch.ms.bomms.bookorderservice.repository;

import com.lynch.ms.bomms.bookorderservice.model.BookItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookItemRepository extends JpaRepository<BookItem, Long> {

}
