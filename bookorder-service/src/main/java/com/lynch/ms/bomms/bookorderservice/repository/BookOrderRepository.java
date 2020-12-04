package com.lynch.ms.bomms.bookorderservice.repository;

import com.lynch.ms.bomms.bookorderservice.model.BookOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookOrderRepository extends JpaRepository <BookOrder, Long> {

  public List<BookOrder> getBookOrdersByCustId(String custId);

}
