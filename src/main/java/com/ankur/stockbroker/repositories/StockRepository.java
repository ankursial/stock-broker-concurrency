package com.ankur.stockbroker.repositories;

import com.ankur.stockbroker.models.Stock;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockRepository extends JpaRepository<Stock, Long> {

  Optional<Stock> findBySymbol(String symbol);
}
