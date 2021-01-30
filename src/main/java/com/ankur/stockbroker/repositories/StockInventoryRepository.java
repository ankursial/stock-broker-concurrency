package com.ankur.stockbroker.repositories;

import com.ankur.stockbroker.models.Stock;
import com.ankur.stockbroker.models.StockInventory;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockInventoryRepository extends JpaRepository<StockInventory, Long> {

  Optional<StockInventory> findByStock(Stock stock);
}
