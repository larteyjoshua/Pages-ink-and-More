package com.joshua.pim.Repository;

import com.joshua.pim.Model.Stock;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface StockRepository extends CrudRepository<Stock, Long> {
    Iterable<Stock> findByStockID(Long stockID);
}
